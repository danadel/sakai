package org.sakaiproject.videoconference.api.external;

import java.util.List;

import org.sakaiproject.user.api.User;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;

public interface ServiceConnector {

	/**
	 * Comprueba si el servidor de videoconferencias es accesible
	 * 	
	 * @return - true si el servidor es accesible, false en caso contrario
	 */
	public abstract boolean pingServer();

	/**
	 * Abre una sesion en el servidor y loguea al usuario
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
	 */
	public abstract boolean getSessionAndLogin();

	/**
	 * Crea una nueva sala en el servidor de videoconferencias
	 * 
	 * @param room - la sala que queremos a�adir
	 * 
	 * @return - el identificador de la sala creada
	 * @throws Exception 
	 */
	public abstract String addRoom(VideoconferenceRoom room) throws Exception;

	/**
	 * Actualiza la sala indicada en el servidor de videoconferencias
	 * 
	 * @param room - la sala que queremos modificar
	 * 
	 * @return - el identificador de la sala
	 * @throws Exception 
	 */
	public abstract boolean updateRoom(VideoconferenceRoom room) throws Exception;

	/**
	 * Borra las salas indicadas en el servidor de videoconferencias
	 * 
	 * @param rooms - lista con las salas que queremos borrar
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
	 */
	public abstract boolean deleteRooms(List<VideoconferenceRoom> rooms);

	/**
	 * A partir de un listado de salas (normalmente extraidas de la BD) se obtiene la 
	 * informaci�n pertinente de la plataforma y se actualizan los datos de la lista
	 * 
	 * @param roomList - lista con las salas que queremos obtener (esta lista quedar� actualizada)
	 * 
	 * @return - true si todo ha ido bien, false en caso contrario
	 */
	public abstract boolean getRoomList(List<VideoconferenceRoom> roomList);

	/**
	 * Obtiene la url de acceso a la sala indicada
	 * 
	 * @param room - la sala a la que queremos acceder
	 * 
	 * @return - la url de acceso
	 */
	public abstract String accesssRoom(VideoconferenceRoom room, User user,	boolean moderator);
	
	public List<VideoconferenceRoomType> getRoomTypes();
	
	public abstract String getRoomURL(VideoconferenceRoom room);

}