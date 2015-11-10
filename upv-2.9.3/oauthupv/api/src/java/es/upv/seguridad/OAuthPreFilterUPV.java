/*
 * Filtro de seguridad UPV para autenticar contra el servidor siupv.upv.es
 */
package es.upv.seguridad;

import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.util.RequestFilter;
//import org.sakaiproject.oauth.domain.Accessor;
//import org.sakaiproject.oauth.exception.InvalidAccessorException;
//import org.sakaiproject.oauth.service.OAuthHttpService;

import es.upv.seguridad.ServicioOAuthUPV;
import es.upv.seguridad.MensajeCheck;



import org.sakaiproject.authz.api.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Set;
import java.util.HashSet;

import es.upv.seguridad.LimitedPermissionsAdvisor;
import org.sakaiproject.authz.api.AuthzGroupService;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.component.api.ServerConfigurationService;

import es.upv.seguridad.excepciones.*;
/**
 * First filter to apply with OAuth protocol
 * <p>
 * Checks the validity of the current request and OAuth parameters.
 * Sets a security advisor for the request.
 * </p>
 *
 * @author Colin Hebert
 */
public class OAuthPreFilterUPV implements Filter {
    private String encoding;
    //private OAuthHttpService oAuthHttpService;
    private ServicioOAuthUPV srvOAuth;
    private SecurityService securityService;
    private AuthzGroupService authzGroupService;
    private ServerConfigurationService serverConfigurationService;
    private UserDirectoryService userDirectoryService;
    private String nomrealm;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.srvOAuth = new ServicioOAuthUPV();        
        this.securityService = (SecurityService) ComponentManager.getInstance().get(SecurityService.class);
        String initEncoding = filterConfig.getInitParameter(RequestFilter.CONFIG_CHARACTER_ENCODING);
        this.encoding = initEncoding != null ? initEncoding : "UTF-8";
        this.authzGroupService = (AuthzGroupService) ComponentManager.getInstance().get(AuthzGroupService.class);
        this.serverConfigurationService = (ServerConfigurationService) ComponentManager.getInstance().get(ServerConfigurationService.class);
        this.userDirectoryService = (UserDirectoryService) ComponentManager.getInstance().get(UserDirectoryService.class);
        
        this.nomrealm = serverConfigurationService.getString("upv.rest.realm","/apps/permisos");
        
        String servidorCheck=serverConfigurationService.getString("upv.rest.server");
        String agenteCheck=serverConfigurationService.getString("upv.rest.agenteCheck");
        String agenteCheckPassword=serverConfigurationService.getString("upv.rest.agenteCheckPassword");
        this.srvOAuth.setAgenteCheck(agenteCheck);
        this.srvOAuth.setAgenteCheckPassword(agenteCheckPassword);
        this.srvOAuth.setoAuthCheckServer(servidorCheck);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Force the character encoding for HTTP body content
        setEncoding(request);
 
        

        try {
            MensajeCheck check = srvOAuth.readAccessToken(req);
			if (check!=null) {
				System.out.println("OAUTH-UPV: Validado Bearer: "+check);				
				final String userEid=check.getId_user();
				final String userId=userDirectoryService.getUserId(check.getId_user());
                HttpServletRequest wrappedRequest = new HttpServletRequestWrapper(req) {
                public Principal getUserPrincipal() {
                    return new Principal() {
                        public String getName() {
							return userId;
                        }
                    };
                }
			    };
			   
			   Set<String> funciones=new HashSet<String>();
			   
			   for(String scope : check.getScopes()){  				   
				   funciones.addAll(authzGroupService.getAuthzGroup(this.nomrealm).getRole(scope).getAllowedFunctions());
			   }			    								
				LimitedPermissionsAdvisor advi=new LimitedPermissionsAdvisor(funciones);
				securityService.pushAdvisor(advi);	
				System.out.println("OAUTH-UPV: Estableciendo entorno Usuario:"+userEid+" Permisos:"+funciones.toString());
				chain.doFilter(wrappedRequest, response);
            } else {
			   chain.doFilter(request, response);
            };
                    
        } catch (ForbiddenException e) {
		   System.out.println("OAUTH-UPV PRE-FILTER:....Sale por excepcion en OauthPreFilter:"+e);
		   res.setStatus(403);
		   res.getOutputStream().print(e.getMessage());
        } catch (NotAuthorizedException e) {
		   System.out.println("OAUTH-UPV PRE-FILTER:....Sale por excepcion en OauthPreFilter:"+e);
		   res.setStatus(401);
		   res.getOutputStream().print(e.getMessage());
        } catch (NotFoundException e) {
		   System.out.println("OAUTH-UPV PRE-FILTER:....Sale por excepcion en OauthPreFilter:"+e);
		   res.setStatus(404);
		   res.getOutputStream().print(e.getMessage());
        } catch (Exception e) {
 		   System.out.println("OAUTH-UPV PRE-FILTER:....Sale por excepcion en OauthPreFilter:"+e);
 		   chain.doFilter(request, response);
		}
		
    }

    /**
     * Sets the encoding for parameters submitted through a POST request.
     * <p>
     * If a charset isn't set manually, OAuth will try to decode some of the submitted parameters by the user with
     * ISO-8859-1 (those parameters are supposed to be in ASCII in the first place).<br />
     * Parameters are only decoded once, and {@link org.sakaiproject.util.RequestFilter} usually sets the charset
     * encoding itself, but the pre-filter reads the parameters first, so it needs to be done here.
     * </p>
     * <p>
     * Usually only parameters sent through a multipart/form-data POST request already provide the character encoding
     * used to encode the parameters.<br />
     * Parameters sent through a application/x-www-form-urlencoded POST request are expected to be only
     * ASCII characters.<br />
     * To avoid problems with developers who forget to set their POST forms in multipart/form-data, it will be assumed
     * that every client sends their forms (multipart/form-data and application/x-www-form-urlencoded POST forms)
     * using UTF-8.<br />
     * This might cause some problems if the client doesn't actually use UTF-8 though.
     * </p>
     * <p>
     * It's possible to specify an other encoding than "UTF-8" by setting the charset with in the filter configuration
     * parameter {@link RequestFilter#CONFIG_CHARACTER_ENCODING}
     * </p>
     *
     * @param request request on which the character encoding will be specified.
     * @throws UnsupportedEncodingException
     */
    private void setEncoding(ServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding(this.encoding);
    }

    @Override
    public void destroy() {
    }
}
