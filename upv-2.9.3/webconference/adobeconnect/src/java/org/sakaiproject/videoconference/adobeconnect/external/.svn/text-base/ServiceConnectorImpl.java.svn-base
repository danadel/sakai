package org.sakaiproject.videoconference.adobeconnect.external;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.tool.api.ToolManager;
import org.sakaiproject.user.api.User;
import org.sakaiproject.videoconference.adobeconnect.service.AdobeConnectService;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.external.ServiceConnector;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;
import org.sakaiproject.videoconference.common.external.I18nService;


public class ServiceConnectorImpl implements ServiceConnector {
	
	private AdobeConnectService adobeConnectService;		
	
	private String session;
	
	private static final String ACCESS_URL = "/openmeetings/main.swf8.swf?";
	
	private String server_URL;	
	private String server_user;
	private String server_pass;
	
	//Modifica UMU
	protected ToolManager toolManager;
	
	public void setToolManager(ToolManager toolManager){
		this.toolManager=toolManager;
	}
	public ToolManager getToolManager(){
		return toolManager;
	}
	
	private SiteService siteService = (SiteService) ComponentManager.get("org.sakaiproject.site.api.SiteService");
	//Fin Modifica UMU
	
	private static Log log = LogFactory.getLog(ServiceConnectorImpl.class);	
	
	//Modifica UMU
	private static final String GROUP_NAME="Usuarios PoliformaT";
	//Fin modifica UMU
	
	private ExternalLogic externalLogic;
	public void setExternalLogic(ExternalLogic externalLogic) {
		this.externalLogic = externalLogic;
	}
	
	public void init()
	{		
		server_URL = externalLogic.getSakaiProperty(ExternalLogic.VC_CNN_ADDRESS);
		server_user = externalLogic.getSakaiProperty(ExternalLogic.VC_CNN_USER);
		server_pass = externalLogic.getSakaiProperty(ExternalLogic.VC_CNN_PASS);		
		
		if (!server_URL.toLowerCase().startsWith("http"))
			server_URL = "http://" + server_URL;	
		
		try
		{
			adobeConnectService = new AdobeConnectService(server_URL);
		}
		catch(Exception e)
		{
			adobeConnectService = null;
			log.warn("Constructor -> "+e);
		}		
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#pingServer()
	 */
	public boolean pingServer()
	{
		boolean ret = true;
		try
		{
			URL url = new URL(server_URL + ACCESS_URL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			int res = conn.getResponseCode();
			
			if(res != 200)
				ret = false;
		}catch(Exception e)
		{
			ret = false;
			log.warn("pingServer -> "+e);
		}
		return ret;
	}
	
	/**
	 * Abre una sesion con el servidor de videoconferencias
	 * 	
	 * @return - La sesion devuelta por el servidor
	 */
	private String getSession() 
	{
		String ret;
		try
		{			
			ret = adobeConnectService.getSession();
		}
		catch(Exception e)
		{
			log.warn("getSession -> "+e);
			ret = "";
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#getSessionAndLogin()
	 */
	public boolean getSessionAndLogin() {
		boolean ret;
		try
		{
			ret = false;
			session = getSession();
			log.debug("ServiceConnector: getSessionAndLogin: sesion -> "+session);
			
			if(!session.equals(""))
			{		
				ret = adobeConnectService.loginUser(session, server_user, server_pass);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.warn("getSessionAndLogin -> "+e);
			ret = false;
		}
		return ret;
	}	
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#addRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom)
	 */
	public String addRoom(VideoconferenceRoom room) throws Exception
	{				
		String roomId = "";
		try
		{
			if(getSessionAndLogin())
			{
				//Modifica UMU
					String idSitio = toolManager.getCurrentPlacement().getContext(); 
					
					Site siteObject = siteService.getSite(idSitio);
					String siteType = siteObject.getType();

					String siteTerm = (String) siteObject.getProperties().get("term");
				
					//pasamos el id del sitio sin espacios y adem�s quitamos el signo + en el tipo de sitios
					roomId = adobeConnectService.createMeeting(session, idSitio.replaceAll(" ", "_"), siteType.replaceAll("\\+", ""), siteTerm, room.getName(), room.getType(), room.getStartDate(), room.getEndDate(), room.isPublic());
					//se a�ade el usuario aulavirtual a todas las salas como  host
//					adobeConnectService.addHost(session, roomId, server_user);
				//Fin Modifica UMU
			}			
		}
		catch(org.sakaiproject.videoconference.adobeconnect.exceptions.VideoconferenceExceptions.DuplicatedNameException dne)
		{
			dne.printStackTrace();
			throw dne;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.warn("addRoom -> "+e);
			throw e;
		}
		return roomId;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#updateRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom)
	 */
	public boolean updateRoom(VideoconferenceRoom room) throws Exception
	{		
		boolean ret = false;
		try
		{
			if(getSessionAndLogin())
			{
				ret = adobeConnectService.updateMeeting(session, room.getRoomId(), room.getName(), room.getType(), room.getStartDate(), room.getEndDate(), room.isPublic());				
			}			
		}
		catch(org.sakaiproject.videoconference.adobeconnect.exceptions.VideoconferenceExceptions.DuplicatedNameException dne)
		{
			throw dne;
		}
		catch(Exception e)
		{
			log.warn("updateRoom -> "+e);
			throw e;
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#deleteRooms(java.util.List)
	 */
	public boolean deleteRooms(List<VideoconferenceRoom> rooms)
	{
		boolean ret = true;
		
		if(getSessionAndLogin())
		{
			for(VideoconferenceRoom room : rooms)
			{
				try
				{
					adobeConnectService.deleteMeeting(session, room.getRoomId());

					room.setActive(false);	
				}
				catch(Exception e)
				{
					log.warn("deleteRooms -> "+e);
					ret = false;
				}
			}
		}			
		
		return ret;
	}
	
	public String getRoomURL(VideoconferenceRoom room){
		if (room!=null){
			try{
				if(getSessionAndLogin()){
					return server_URL + adobeConnectService.getMeetingURL(session, room.getRoomId());
				}else{
					return "";
				}
			}catch(Exception e){
				return "";
			}
		}
		return "";
	}
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#getRoomList(java.util.List)
	 */
	public boolean getRoomList(List<VideoconferenceRoom> roomList)
	{
		boolean ret = true;
		
		if(roomList != null)
		{
			//solo logeamos una vez
			if(getSessionAndLogin())
			{
				//para cada sala de la lista
				for(VideoconferenceRoom room : roomList)
				{
					try
					{
						String aux = adobeConnectService.getMeetingName(session, room.getRoomId());
						room.setName((aux.equals("")) ? I18nService.getInstance().getMessage("room_not_found") : aux);
						room.setType(adobeConnectService.getMeetingTemplate(session, room.getRoomId()));
						room.setPublic(adobeConnectService.isPublicMeeting(session, room.getRoomId()));
						room.setActive(!aux.equals(""));
						room.setUrl(server_URL + adobeConnectService.getMeetingURL(session, room.getRoomId()));
					}
					catch(Exception e)
					{
						log.warn("getRoomList -> "+e);
						//en caso de fallo al obtener los datos de la sala del servidor de videoconferencias, se establecen valores de "error"
						room.setName(I18nService.getInstance().getMessage("room_not_found"));
						room.setActive(false);
						ret = false;
					}
				}
			}
			else
			{		
				//si no ha podido loguearse, se establecen valores de "error" para todas las salas
				for(VideoconferenceRoom room : roomList)
				{
					room.setName(I18nService.getInstance().getMessage("room_not_found"));
					room.setActive(false);
				}
				ret = false;
			}
		}
		return ret;			
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.ServiceConnector#accesssRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom, org.sakaiproject.user.api.User, boolean)
	 */
	public String accesssRoom(VideoconferenceRoom room, User user, boolean moderator)
	{
		final String KEY = "ConectaVideoPara";
		final String passwd = encrypt(user.getEid(), KEY);
		try
		{
			if(getSessionAndLogin())
			{
				boolean isNewUser = false;
				String ret = server_URL + adobeConnectService.getMeetingURL(session, room.getRoomId());
				//Comprobamos si el usuario está en AC
				if (!adobeConnectService.userInAdobe(session, user.getEid() )) {
					//Si el usuario no está en AC
					boolean userCreated = adobeConnectService.createUser(session, user, passwd);
					if (!adobeConnectService.groupInAdobe(session, GROUP_NAME)){
						//Comprobamos si el grupo de usuarios de PoliformaT está creado. Si no lo está, lo creamos.
						//El grupo no existe
						boolean groupCreated = adobeConnectService.createGroup(session, GROUP_NAME);
					}
					//Añadimos el usuario al grupo
					boolean userAdded = adobeConnectService.addUserToGroup(session, user.getEid(),GROUP_NAME );
				}
				
				//Si el usuario tiene permisos de moderador o edición de la sala, lo añadimos como anfitrioń
				boolean user_as_participant = false;
				if (moderator){
					user_as_participant = adobeConnectService.addHost(session, room.getRoomId(), user.getEid());
					
				}else{
				//Añadimos al usuario a la reunión
					user_as_participant = adobeConnectService.addParticipant(session, room.getRoomId(), user.getEid());
				}
//				return isNewUser?"new_"+ret:ret;
				return ret + "?login=" + user.getEid() + "&password=" + passwd;
			}			
		}catch(Exception e)
		{
			log.warn("accesssRoom -> "+e);
		}
		return "";
	}

	public List<VideoconferenceRoomType> getRoomTypes() 
	{
		try
		{
			if(getSessionAndLogin())
			{
				return adobeConnectService.getTemplates(session);
			}			
		}catch(Exception e)
		{
			log.warn("accesssRoom -> "+e);
		}
		return new ArrayList<VideoconferenceRoomType>();
	}
	
	/**
	 * 
	 * Metodo para obtener un hash
	 * 
	 * @param strToEncrypt
	 * @param key
	 * @return
	 */
	private String encrypt(String strToEncrypt, String key) {
		
		try {
	    	// Algoritmo hash MD5
			MessageDigest md5 = MessageDigest.getInstance("MD5");
	        
	        // Obtenemos el hash
			byte[] byteArrayEncrypt = md5.digest((key + strToEncrypt).getBytes());
	        
	        String encryptedString = Base64.encodeBase64URLSafeString(byteArrayEncrypt);
	        return encryptedString;

	    } catch (Exception ex) {
	        log.warn("Excepcion al encriptar: " + ex.getMessage());
	    }
	    return null;
	}
}
