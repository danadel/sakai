package org.sakaiproject.videoconference.openmeetings.external;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.videoconference.api.external.DataModel;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.external.ServiceConnector;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;
import org.sakaiproject.videoconference.common.external.I18nService;
//import org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.AddRoomWithModeration;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.DeleteRoom;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.GetRoomById;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.LoginUser;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.LoginUserResponse;

//import org.sakaiproject.videoconference.openmeetings.service.axis.services.SetUserObjectAndGenerateRoomHash;
//import org.sakaiproject.videoconference.openmeetings.service.axis.services.UpdateRoomWithModeration;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.UserServiceStub;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub.AddRoomWithModeration;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub.DeleteRoom;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub.GetRoomById;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub.Rooms;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.RoomServiceStub.UpdateRoomWithModeration;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.UserServiceStub.LoginUser;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.UserServiceStub.LoginUserResponse;
import org.sakaiproject.videoconference.openmeetings.service.axis.services.UserServiceStub.SetUserObjectAndGenerateRoomHash;
import org.sakaiproject.user.api.User;

public class ServiceConnectorImpl implements ServiceConnector{

	private UserServiceStub userService;
	private RoomServiceStub roomService;
	
	private static final String OM_EXTERNAL_ID = "om_externalId";
	
	private String session;
	
	private static final String userService_path = "/openmeetings/services/UserService";
	private static final String roomService_path = "/openmeetings/services/RoomService";
	private static final String ACCESS_URL = "/openmeetings/main.swf8.swf?";
	
	private String server_URL;	
	private String server_user;
	private String server_pass;
	
	private static Log log = LogFactory.getLog(ServiceConnectorImpl.class);	
	
	private ExternalLogic externalLogic;
	public void setExternalLogic(ExternalLogic externalLogic) {
		this.externalLogic = externalLogic;
	}
	
	private DataModel dataModel;
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void init()
	{		
		server_URL = externalLogic.getSakaiProperty(ExternalLogic.VC_OM_ADDRESS);
		server_user = externalLogic.getSakaiProperty(ExternalLogic.VC_OM_USER);
		server_pass = externalLogic.getSakaiProperty(ExternalLogic.VC_OM_PASS);
				
		
		if (!server_URL.toLowerCase().startsWith("http"))
			server_URL = "http://" + server_URL;	
		
		try
		{
			userService = new UserServiceStub(server_URL+userService_path);
			roomService = new RoomServiceStub(server_URL+roomService_path);
		}
		catch(Exception e)
		{
			userService = null;
			roomService = null;
			log.warn("Constructor -> "+e);
		}		
	}
	
	/**
	 * Comprueba si el servidor de videoconferencias es accesible
	 * 	
	 * @return - true si el servidor es accesible, false en caso contrario
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
			ret = userService.getSession().get_return().getSession_id();
		}
		catch(Exception e)
		{
			log.warn("getSession -> "+e);
			ret = "";
		}
		return ret;
	}
	
	/**
	 * Abre una sesion en el servidor y loguea al usuario
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
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
				LoginUser lu = new LoginUser();
				lu.setSID(session);
				lu.setUsername(server_user);
				lu.setUserpass(server_pass);
				
				LoginUserResponse lur = userService.loginUser(lu);				
				
				log.debug("ServiceConnector: getSessionAndLogin: login user ("+session+"): -> "+lur.get_return());	
				ret = (lur.get_return() == 1);
			}
		}
		catch(Exception e)
		{
			log.warn("getSessionAndLogin -> "+e);
			ret = false;
		}
		return ret;
	}	
	
	/**
	 * Crea una nueva sala en el servidor de videoconferencias
	 * 
	 * @param room - la sala que queremos a�adir
	 * 
	 * @return - el identificador de la sala creada
	 * @throws Exception 
	 */
	public String addRoom(VideoconferenceRoom room)
	{
		DateFormat df = DateFormat.getDateInstance();
		String comentario = I18nService.getInstance().getMessage("openmeetings_description_create", new String[] {df.format(new Date())});
		
		String roomId = "";
		try
		{
			if(getSessionAndLogin())
			{
				AddRoomWithModeration arm = new AddRoomWithModeration();
				arm.setSID(session);
				arm.setName(room.getName());
				arm.setRoomtypes_id(Long.valueOf(room.getType()));
				arm.setComment(comentario);
				arm.setNumberOfPartizipants(room.getCapacity());
				arm.setIspublic(true);
				arm.setAppointment(false);
				arm.setIsDemoRoom(false);
				arm.setDemoTime(0);
				arm.setIsModeratedRoom(true);
				
				roomId = String.valueOf(roomService.addRoomWithModeration(arm).get_return());
								
			}			
		}
		catch(Exception e)
		{
			log.warn("addRoom -> "+e);
			roomId = "";
		}
		return roomId;
	}
	
	/**
	 * Actualiza la sala indicada en el servidor de videoconferencias
	 * 
	 * @param room - la sala que queremos modificar
	 * 
	 * @return - el identificador de la sala
	 * @throws Exception 
	 */
	public boolean updateRoom(VideoconferenceRoom room)
	{
		DateFormat df = DateFormat.getDateInstance();
		String comentario = I18nService.getInstance().getMessage("openmeetings_description_update", new String[] {df.format(new Date())});
		
		boolean ret = false;
		try
		{
			if(getSessionAndLogin())
			{
				UpdateRoomWithModeration urm = new UpdateRoomWithModeration();
				urm.setSID(session);
				urm.setRoom_id(Long.parseLong(room.getRoomId()));
				urm.setName(room.getName());
				urm.setRoomtypes_id(Long.valueOf(room.getType()));
				urm.setComment(comentario);
				urm.setNumberOfPartizipants(room.getCapacity());
				urm.setIspublic(true);
				urm.setAppointment(false);
				urm.setIsDemoRoom(false);
				urm.setDemoTime(0);
				urm.setIsModeratedRoom(true);
				
				roomService.updateRoomWithModeration(urm);
				ret = true;
			}			
		}
		catch(Exception e)
		{
			log.warn("updateRoom -> "+e);
			ret = false;
		}
		return ret;
	}
	
	/**
	 * Borra las salas indicadas en el servidor de videoconferencias
	 * 
	 * @param rooms - lista con las salas que queremos borrar
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
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
					DeleteRoom dr = new DeleteRoom();
					dr.setSID(session);
					dr.setRooms_id(Long.parseLong(room.getRoomId()));
					
					roomService.deleteRoom(dr);
					
					room.setActive(false);
				}
				catch(Exception e)
				{
					log.warn("deleteRooms -> "+e);
					ret = false;
				}
			}
		}
		else
			ret = false;

		return ret;
	}
	
	
	/**
	 * A partir de un listado de salas (normalmente extraidas de la BD) se obtiene la 
	 * informaci�n pertinente de la plataforma y se actualizan los datos de la lista
	 * 
	 * @param roomList - lista con las salas que queremos obtener (esta lista quedar� actualizada)
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
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
						//rellenamos los parametros para la llamada
						GetRoomById gri = new GetRoomById();
						gri.setSID(session);
						gri.setRooms_id(Long.parseLong(room.getRoomId()));
						
						//hacemos la llamada al stub
						Rooms grir = roomService.getRoomById(gri).get_return();					
						
						//rellenamos los campos correspondientes
						room.setName(grir.getName());
						room.setCapacity(grir.getNumberOfPartizipants());
						room.setType(String.valueOf(grir.getRoomtype().getRoomtypes_id()));
						
						room.setActive(true);
					}
					catch(Exception e)
					{
						log.warn("getRoomList -> "+e);
						//en caso de fallo al obtener los datos de la sala del servidor de videoconferencias, se establecen valores de "error"
						room.setName(I18nService.getInstance().getMessage("room_not_found"));
						room.setCapacity(0);
						room.setType("1");
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
					room.setCapacity(0);
					room.setType("1");
					room.setActive(false);
				}
				ret = false;
			}
		}
		return ret;			
	}
	
	/**
	 * Obtiene la url de acceso a la sala indicada
	 * 
	 * @param room - la sala a la que queremos acceder
	 * 
	 * @return - la url de acceso
	 */
	public String accesssRoom(VideoconferenceRoom room, User user, boolean moderator)
	{
		try
		{
			if(getSessionAndLogin())
			{
				//comprobamos si el usuario ha accedido alguna vez a openmeetings
				String aux = externalLogic.getUserProperty(user.getId(), OM_EXTERNAL_ID);
				int externalUserId = 0;				
				//si es la primera vez
				if(aux == null || aux.equals("") || aux.equals("-1"))
				{
					//obtenemos un identificador para el
					externalUserId = dataModel.getAndUpdateSequence();
					//guardamos el identificador en la propiedades del usuario
					externalLogic.setUserProperty(user.getId(), OM_EXTERNAL_ID, String.valueOf(externalUserId));
				}
				else
					externalUserId = Integer.parseInt(aux);
					
				SetUserObjectAndGenerateRoomHash suo = new SetUserObjectAndGenerateRoomHash();
				suo.setSID(session);
				suo.setUsername(user.getDisplayName());
				suo.setFirstname(user.getFirstName());
				suo.setLastname(user.getLastName());
				suo.setProfilePictureUrl("");
				suo.setEmail(user.getEmail());
				suo.setExternalUserId(externalUserId);
				suo.setExternalUserType("sakai");
				suo.setRoom_id(Long.parseLong(room.getRoomId()));
				suo.setBecomeModeratorAsInt((moderator) ? 1 : 0);
				suo.setShowAudioVideoTestAsInt(0);
				
				String ret = userService.setUserObjectAndGenerateRoomHash(suo).get_return();			
				
				return server_URL + ACCESS_URL + "secureHash="+ret+"&lzproxied=solo";
			}
		}catch(Exception e)
		{
			log.warn("accesssRoom -> "+e);
		}
		return "";
	}

	public List<VideoconferenceRoomType> getRoomTypes() {
		return null;
	}
	public String getRoomURL(VideoconferenceRoom room){return null;}

}
