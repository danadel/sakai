package es.upv.seguridad;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import es.upv.seguridad.MensajeCheck;

import com.google.gson.Gson;

import es.upv.seguridad.excepciones.*;


public class ServicioOAuthUPV{

   public static final String BEARER_TYPE = "Bearer";
   public static final String CABECERA_AUTORIZACION = "Authorization";
   public final static String DEFAULT_OAUTH_CHECK_SERVER = "";
   public final static String SEPARADOR = ":";
   public final static String CAMPO_TOKEN = "token";
   public final static String CAMPO_DISPOSITIVO = "UPV_UUID";
   
   private String oAuthCheckServer = DEFAULT_OAUTH_CHECK_SERVER; //El servidor de autenticación por defecto
   public String agenteCheck=""; //agente que hace el check al servidor de autenticacion, esta aplicacion en este caso. 
   public String agenteCheckPassword=""; //Passwword del agente que realiza el check al servidor de autenticación
	
   //Este dato se codifica en Base64 a partir de => servicioRest + SEPARADOR + servicioRestPassword
   private String agenteCheckEncoded=null;
   
   
   
   
   public MensajeCheck readAccessToken(HttpServletRequest request) throws Exception {		
		System.out.println("INI readAccessToken");
		
		String tokenValue = extractHeaderToken(request);
		MensajeCheck check = null;

		if(tokenValue!=null && !"".equals(tokenValue)){
		
			//System.out.println("tokenValue=>"+tokenValue);
			
			//Viene codificada toda la cadena en Base64 (incluido=> token:dispositivo)
		    //tokenValue = new String(Base64.decodeBase64(tokenValue));
			
			// Contiene en primer lugar el token y en segundo el dispositivo (separado por :)
			int posSeparador = tokenValue.indexOf(SEPARADOR);
						
			//El tokenValue debe contener únicamente token y dispositivo			
			if(posSeparador!=-1){
						
				String token = tokenValue.substring(0, posSeparador);
				String dispositivo =  tokenValue.substring(posSeparador+1);		
				//Se hace la peticion check				
				String cadenaJSONCheck = realizarPeticionCheck(token,dispositivo);				
				System.out.println("OAUTH-UPV: Respuesta de siupv:"+cadenaJSONCheck);
				try {
				     Gson gson = new Gson();
				     check = (MensajeCheck) gson.fromJson(cadenaJSONCheck,MensajeCheck.class);
				} catch (Throwable e) {
					e.printStackTrace();
					System.out.println("OAUTH-UPV: ERROR parseando Json:"+cadenaJSONCheck);
				};
				
			}else{
				System.out.println("OAUTH-UPV:  Se ha recibido un token incorrecto=>" +tokenValue);
			}			 

		}

	
		System.out.println("FIN readAccessToken");	
		
		return check;
	}
   
   
   
   
	/* Forma de hacer la peticion sin usar las capacidades JERSEY*/
	public String realizarPeticionCheck(String token,String dispositivo) throws Exception{		

        System.out.println("INI realizarPeticionCheck");      
 	   if(this.agenteCheck==null || this.agenteCheckPassword==null || "".equals(this.agenteCheck) || "".equals(this.agenteCheckPassword)){			
 			throw new Exception("Es obligatorio configurar en UPVTokenStore los atributos 'servicioRest' y 'servicioRestPassword'");
 	   }			

		
		if(token==null || dispositivo==null || "".equals(token) || "".equals(dispositivo)){
			return null; //No tiene sentido realizar la petición
		}
		String resultado = null;
		
		String query = ServicioOAuthUPV.CAMPO_TOKEN + "= " + token + "&" + ServicioOAuthUPV.CAMPO_DISPOSITIVO + "=" + dispositivo ;
	
        
			   //Solo se realiza el encoded la primera vez (LAZY)
	    if(agenteCheckEncoded==null){
		   String servicioSinCodificar = this.agenteCheck + SEPARADOR + this.agenteCheckPassword;
		   byte[] encoded = Base64.encodeBase64(servicioSinCodificar.getBytes());
		   this.agenteCheckEncoded = new String(encoded);
	   }
	        
		

        
		URL myurl = new URL(oAuthCheckServer);
		HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
		con.setRequestMethod("POST");

		con.setRequestProperty("Content-length", String.valueOf(query.length())); 
		con.setRequestProperty("Content-Type","application/x-www-form-urlencoded"); 
		con.setRequestProperty("Authorization", "Basic " + this.agenteCheckEncoded) ; //Servicio Rest + pwd en Base64
		con.setDoOutput(true); 
		con.setDoInput(true); 

        //En el cuerpo va la query (token + dispositivo)
		DataOutputStream output = new DataOutputStream(con.getOutputStream());  
		output.writeBytes(query);
		output.close();

		StringBuilder sb = new StringBuilder();
		String line=null;
		BufferedReader br;
		if(con.getResponseCode()==200){
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			System.out.println("OAUTH-UPV PRE-FILTER:....Sale por excepcion en OauthPreFilter:"+con.getResponseCode());
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		if (con.getResponseCode()==403) { 
			   throw new ForbiddenException(sb.toString());  };
		if (con.getResponseCode()==401) { 
			   throw new NotAuthorizedException(sb.toString());};
		if (con.getResponseCode()==404) { 
				   throw new NotFoundException(sb.toString());};
	    if (con.getResponseCode()!=200) { 
					   throw new Exception(sb.toString());};
		
		resultado = sb.toString();
		
		
			System.out.println("Resultado:"+resultado);
			System.out.println("getResponseCode:"+con .getResponseCode() + ",  getResponseMessage:"+ con .getResponseMessage()); 
		
		
		return resultado;
	}
	
    /*
	  Extraido de org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor
	*/
	protected String extractHeaderToken(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaders(ServicioOAuthUPV.CABECERA_AUTORIZACION);		
		while (headers.hasMoreElements()) { 
			String value = headers.nextElement();			
			if ((value.toLowerCase().startsWith(ServicioOAuthUPV.BEARER_TYPE.toLowerCase()))) {
				String authHeaderValue = value.substring(ServicioOAuthUPV.BEARER_TYPE.length()).trim();				
				int commaIndex = authHeaderValue.indexOf(',');
				if (commaIndex > 0) {
					authHeaderValue = authHeaderValue.substring(0, commaIndex);
				}
				return authHeaderValue;
			}
		}
		return null;
	}


	/**
	 * Permite establecer otro servidor de autenticación distinto al servidor por defecto {@link UPVTokenStore.DEFAULT_OAUTH_CHECK_TOKEN}
	 * @param oAuthCheckToken Servidor de autenticación
	 */
	public void setoAuthCheckServer(String oAuthCheckServer) {		
		this.oAuthCheckServer = oAuthCheckServer;
	}

	/**
	 * Identificador del agente que solicita check al servidor de autenticación
	 * @param agenteCheck
	 */
	public void setAgenteCheck(String agenteCheck) {
		this.agenteCheck = agenteCheck;
	}

	/**
	 * Password del agente que solicita check al servidor de autenticación
	 * @param agenteCheckPassword 
	 */
	public void setAgenteCheckPassword(String agenteCheckPassword) {
		this.agenteCheckPassword = agenteCheckPassword;
	}

	
}