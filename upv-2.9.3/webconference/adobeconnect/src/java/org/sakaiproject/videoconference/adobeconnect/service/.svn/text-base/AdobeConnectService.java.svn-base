package org.sakaiproject.videoconference.adobeconnect.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.tool.api.ToolManager;
import org.sakaiproject.user.api.User;
import org.sakaiproject.videoconference.adobeconnect.exceptions.VideoconferenceExceptions;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;
import org.w3c.dom.NodeList;

public class AdobeConnectService 
{
	private String baseURL;
	
	//ModificaUMU
	private static final String ACTION_PRINCIPAL_UPDATE="principal-update";
	private static final String PARAMETER_FIRST_NAME="first-name";
	private static final String PARAMETER_LAST_NAME="last-name";
	private static final String PARAMETER_SEND_EMAIL="send-email";
	private static final String	PARAMETER_HAS_CHILDREN="has-children";
	private static final String PARAMETER_EMAIL="email";
	private static final String ATTRIBUTE_ACCOUNT_ID = "account-id";
	private static final String ACTION_GROUP_MEMBERSHIP_UPDATE="group-membership-update";
	private static final String PARAMETER_GROUP_ID="group-id";
	private static final String PARAMETER_IS_MEMBER="is-member";
	private static final String PARAMETER_FILTER_TYPE="filter-type";
	private static final String PARAMETER_FILTER_NAME="filter-name";	
	private static final String ACTION_SCO_EXPANDED_CONTENT="sco-expanded-contents";
	private static final String ACTION_SCO_SEARCH= "sco-search-by-field";
	private static final String PARAMETER_QUERY = "query";
	
	//carpeta raiz donde se almacenara todas las salas creadas desde nuestra AulaVirtual
	private static final String CARPETA_SALAS_AULAVIRTUAL = "PoliformaT";
	
	private static Log log = LogFactory.getLog(AdobeConnectService.class);
	
	protected ToolManager toolManager;
	//Fin MOdifica UMU
	
	private static final String ACTION_COMMONINFO = "common-info";
	private static final String ACTION_LOGIN = "login";
	private static final String ACTION_LIST_FOLDERS = "sco-shortcuts";
	private static final String ACTION_UPDATE_SCO = "sco-update";
	private static final String ACTION_UPDATE_PERMISSIONS = "permissions-update";
	private static final String ACTION_GET_PERMISSIONS = "permissions-info";
	private static final String ACTION_GET_SCO = "sco-info";
	private static final String ACTION_DELETE_SCO = "sco-delete";
	private static final String ACTION_PRINCIPAL_LIST = "principal-list";
	private static final String ACTION_FOLDER_CONTENT = "sco-contents";
	
	private static final String PARAMETER_SESSION = "session";
	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_TYPE = "type";
	private static final String PARAMETER_FOLDER = "folder-id";
	private static final String PARAMETER_DATE_BEGIN = "date-begin";
	private static final String PARAMETER_DATE_END = "date-end";
	private static final String PARAMETER_URL_PATH = "url-path";
	private static final String PARAMETER_ACL_ID = "acl-id";
	private static final String PARAMETER_PRINCIPAL_ID = "principal-id";
	private static final String PARAMETER_PERMISSION_ID = "permission-id";
	private static final String PARAMETER_SCO_ID = "sco-id";
	//Modifica UMU
	private static final String PARAMETER_FILTER_LOGIN = "filter-login";
	//Fin modifica UMU
	private static final String PARAMETER_SOURCE_SCO = "source-sco-id";
	
	private static final String ELEMENT_COOKIE = "cookie";
	private static final String ELEMENT_STATUS = "status";
	private static final String ELEMENT_SCO = "sco";
	private static final String ELEMENT_INVALID = "invalid";
	private static final String ELEMENT_NAME = "name";
	private static final String ELEMENT_URL = "url-path";
	private static final String ELEMENT_PRINCIPAL = "principal";
	
	private static final String ATTRIBUTE_CODE = "code";
	private static final String ATTRIBUTE_SUBCODE = "subcode";
	private static final String ATTRIBUTE_TYPE = "type";
	private static final String ATTRIBUTE_SCO_ID = "sco-id";
	private static final String ATTRIBUTE_FIELD = "field";
	private static final String ATTRIBUTE_PRINCIPAL_ID = "principal-id";
	private static final String ATTRIBUTE_PERMISSION_ID = "permission-id";
	private static final String ATTRIBUTE_SOURCE_SCO = "source-sco-id";
	
	private static final String VALUE_PUBLIC_MEETING = "view-hidden";
	private static final String VALUE_PROTECTED_MEETING = "remove";
	
	private static final String ENCODING = "UTF-8";
	
	private String cache_query;
	private Parser cache_parser;
	
	public AdobeConnectService(String baseURL)
	{
		this.baseURL = baseURL;
	}
	
	protected Parser breezeUrl(String action, String queryString) throws Exception 
	{
		if(cache_query != null && cache_query.equals(queryString))
			return cache_parser;
		
		cache_query = queryString;
		URL url = new URL(baseURL + "/api/xml?" + "action=" + action + (queryString != null ? ('&' + queryString) : ""));
		URLConnection conn = url.openConnection();
		conn.connect();
		InputStream resultStream = conn.getInputStream();
		cache_parser = new Parser(resultStream);
		return cache_parser;
	}
	
	public String getSession() throws Exception
	{
		Parser parser = breezeUrl(ACTION_COMMONINFO, null);

		return parser.getNodeValue(ELEMENT_COOKIE);
	}
	
	public boolean loginUser(String sid, String user, String pass) throws Exception
	{
		Parser parser = breezeUrl(ACTION_LOGIN, PARAMETER_LOGIN+"="+user+"&"+PARAMETER_PASSWORD+"="+pass+"&"+PARAMETER_SESSION+"="+sid);
		
		String res = parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE);
		return res.equals("ok");
	}

//Modifica UMU
	private String createFolderStructure(String sid, String path, String parentFolder) throws Exception{
		
		String[] arrayFolders = path.split("/");
		String pathToEnd = path.substring(path.indexOf("/")+1);
		 
		
		if (arrayFolders[0]!=""){
			
			
			Parser parser = breezeUrl(ACTION_SCO_EXPANDED_CONTENT, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+parentFolder);
			String ret = parser.getNodeByXPath("//"+ELEMENT_SCO+"[name='"+arrayFolders[0]+"']/@"+ATTRIBUTE_SCO_ID);
		
			//No ha encontrado la carpeta -> la creamos
			if (ret.equals("")){
				//CREACION
				Parser parser2 = breezeUrl(ACTION_UPDATE_SCO, 
							PARAMETER_SESSION+"="+ URLEncoder.encode(sid, ENCODING)+"&"+
							PARAMETER_FOLDER+"="+ URLEncoder.encode(parentFolder, ENCODING)+"&"+
							PARAMETER_NAME+"="+ URLEncoder.encode(arrayFolders[0], ENCODING)+"&"+
							PARAMETER_TYPE+"=folder");
				//LISTAMOS LAS CARPETAS PARA SACAR EL ID DE LA NUEVA CREADA
				Parser parser3 = breezeUrl(ACTION_SCO_EXPANDED_CONTENT, 
							PARAMETER_SESSION+"="+URLEncoder.encode(sid, ENCODING)+"&"+
							PARAMETER_SCO_ID+"="+ URLEncoder.encode(parentFolder, ENCODING));
				//SACAMOS EL ID
				ret = parser3.getNodeByXPath("//"+ELEMENT_SCO+"[name='"+arrayFolders[0]+"']/@"+ATTRIBUTE_SCO_ID);
				
			}
			
			//ultima carpeta?
			if (arrayFolders.length==1)
				pathToEnd="";
			
			return (createFolderStructure(sid, pathToEnd, ret));
			
		}else{
			return parentFolder;
		}
		
	}
	
	private String getMyMeetingsFolder(String sid, String siteType, String siteTerm, String idSitio) throws Exception
	{
		String path;
		//BUSCAMOS LA CARPETA RAIZ DE LOS MEETINGS
		Parser parser2 = breezeUrl(ACTION_LIST_FOLDERS, PARAMETER_SESSION+"="+URLEncoder.encode(sid,ENCODING));
		String meetingScoId = parser2.getNodeByXPath("//"+ELEMENT_SCO+"[@"+ATTRIBUTE_TYPE+"='meetings']/@"+ATTRIBUTE_SCO_ID);
			
		//Diferenciamos entre sitios con la propiedad Term y los que no la tienen
		if (siteTerm!=null){
			path=CARPETA_SALAS_AULAVIRTUAL+"/"+siteType+"/"+siteTerm+"/"+idSitio;
		}else{
			path=CARPETA_SALAS_AULAVIRTUAL+"/"+siteType+"/"+idSitio;
		}

		String ret = createFolderStructure(sid, path, meetingScoId);
				
		return ret; 
	}
//Fin Modifica UMU
	
	private String generateRandomString(int length)
	{
		String ret = "U";
		Random rand = new Random(); 
		for(int i=0; i < length-1; i++)
		{
			int c = rand.nextInt(Character.MAX_RADIX);
			//ret += Integer.toHexString(c);
			ret += Integer.toString(c, Character.MAX_RADIX);
		}
		return ret;
	}
	
	private String updateSCO_add(String sid, String idSitio, String folder, String name, String type, Date init_date, Date end_date) throws Exception
	{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String init_date_string = sdf.format(init_date).toString();
		String end_date_string = sdf.format(end_date).toString();
		String type_aux = type.equals("") ? "" : "&"+PARAMETER_SOURCE_SCO+"="+type;
		
		//Modifica UMU
		Parser parser = breezeUrl(ACTION_UPDATE_SCO, PARAMETER_SESSION+"="+sid+"&"+
												PARAMETER_TYPE+"=meeting&"+
												PARAMETER_NAME+"="+URLEncoder.encode("AV-"+name,ENCODING)+"&"+
												PARAMETER_FOLDER+"="+folder+"&"+
												PARAMETER_DATE_BEGIN+"="+init_date_string+"&"+
												PARAMETER_DATE_END+"="+end_date_string+"&"+
												PARAMETER_URL_PATH+"="+URLEncoder.encode("AV-"+idSitio+"-"+generateRandomString(10),ENCODING)+type_aux
		);
		//parser.printDocument(parser.getDocument().getDocumentElement());
		//FinModifica UMU
				
		String res = parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE);
		if(res.equals("ok"))
			return parser.getNodeAttribute(ELEMENT_SCO, ATTRIBUTE_SCO_ID);
		else if(res.equals("invalid") && parser.getNodeAttribute(ELEMENT_INVALID, ATTRIBUTE_SUBCODE).equals("duplicate"))
		{
			//si el campo duplicado es la URL -> generamos otra
			if(parser.getNodeAttribute(ELEMENT_INVALID, ATTRIBUTE_FIELD).equals("url-path"))
				return updateSCO_add(sid, idSitio, folder, name, type, init_date, end_date);
			else if(parser.getNodeAttribute(ELEMENT_INVALID, ATTRIBUTE_FIELD).equals("name")) //si es el nombre, mostramos un error
				throw new VideoconferenceExceptions.DuplicatedNameException(name);
		}
	
		return "";
	}
	
	private boolean updateSCO_update(String sid, String scoId, String name, String type, Date init_date, Date end_date) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String init_date_string = sdf.format(init_date).toString();
		String end_date_string = sdf.format(end_date).toString();
		String type_aux = type.equals("") ? "" : "&"+PARAMETER_SOURCE_SCO+"="+type;
		
		Parser parser = breezeUrl(ACTION_UPDATE_SCO, PARAMETER_SESSION+"="+URLEncoder.encode(sid,ENCODING)+"&"+
												PARAMETER_TYPE+"=meeting&"+
												PARAMETER_NAME+"="+URLEncoder.encode(name,ENCODING)+"&"+
												PARAMETER_SCO_ID+"="+scoId+"&"+
												PARAMETER_DATE_BEGIN+"="+init_date_string+"&"+
												PARAMETER_DATE_END+"="+end_date_string+type_aux
			);
		parser.printDocument(parser.getDocument().getDocumentElement());
		String res = parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE);
		if(res.equals("ok"))
			return true;
		else if(res.equals("invalid") && parser.getNodeAttribute(ELEMENT_INVALID, ATTRIBUTE_SUBCODE).equals("duplicate"))
		{
			//si el campo duplicado es el nombre, mostramos un error
			if(parser.getNodeAttribute(ELEMENT_INVALID, ATTRIBUTE_FIELD).equals("name"))
				throw new VideoconferenceExceptions.DuplicatedNameException(name);
		}
	
		return false;
	}
	
	private boolean updatePermissions(String sid, String acl_id, String principal, String permission) throws Exception
	{
		Parser parser = breezeUrl(ACTION_UPDATE_PERMISSIONS, PARAMETER_SESSION+"="+sid+"&"+
				PARAMETER_ACL_ID+"="+acl_id+"&"+
				PARAMETER_PRINCIPAL_ID+"="+principal+"&"+
				PARAMETER_PERMISSION_ID+"="+permission
			);
		
		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");
	}

//Modifica UMU

	public boolean createUser(String sid, User user, String passwd) throws Exception
	{
		String password = generateRandomString(8);


		Parser parser = breezeUrl(ACTION_PRINCIPAL_UPDATE,
				PARAMETER_SESSION+"="+sid+"&" +
				PARAMETER_FIRST_NAME+"="+URLEncoder.encode(user.getFirstName(),ENCODING)+"&" +
				PARAMETER_LAST_NAME+"="+URLEncoder.encode(user.getLastName(),ENCODING)+"&"+
				PARAMETER_LOGIN+"="+user.getEid()+"&"+
				PARAMETER_PASSWORD+"="+passwd+"&"+
				PARAMETER_TYPE+"="+"user"+"&"+
				PARAMETER_SEND_EMAIL+"="+"true"+"&"+
				PARAMETER_HAS_CHILDREN+"="+"0"+"&"+
				PARAMETER_EMAIL+"="+ user.getEmail()
		);
		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");
	}
	
	public boolean createUser(String sid,String first_name, String last_name, String login, String passwd) throws Exception
	{
		String password = generateRandomString(8);


		Parser parser = breezeUrl(ACTION_PRINCIPAL_UPDATE,
				PARAMETER_SESSION+"="+sid+"&"+
				PARAMETER_FIRST_NAME+"="+URLEncoder.encode(first_name,ENCODING)+"&"+
				PARAMETER_LAST_NAME+"="+URLEncoder.encode(last_name,ENCODING)+"&"+
				PARAMETER_LOGIN+"="+login+"&"+
				PARAMETER_PASSWORD+"="+passwd+"&"+
				PARAMETER_TYPE+"="+"user"+"&"+
				PARAMETER_SEND_EMAIL+"="+"true"+"&"+
				PARAMETER_HAS_CHILDREN+"="+"0"+"&"+
				PARAMETER_EMAIL+"="+login				
			);
		
		
		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");
	}
	
	
	public boolean addUserToGroup(String sid,String login, String groupName) throws Exception
	{

		//	https://example.com/api/xml?action=group-membership-update
		//	&group-id=4930296&principal-id=2006258745&is-member=true
		String principalId = getPrincipalId(sid, login);
		String groupId = getPrincipalIdGroup(sid, groupName);
		
		
		//https://example.com/api/xml?action=principal-list&filter-type=group
		Parser parser = breezeUrl(ACTION_GROUP_MEMBERSHIP_UPDATE, PARAMETER_SESSION+"="+sid+"&"+
				PARAMETER_GROUP_ID+"="+groupId+"&"+
				PARAMETER_PRINCIPAL_ID+"="+principalId+"&"+
				PARAMETER_IS_MEMBER+"="+"true"				
			);

		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");
	}
	
	
	//true si est� en adobe y false si no
	public Boolean userInAdobe(String sid, String login) throws Exception
	{
		Parser parser = breezeUrl(ACTION_PRINCIPAL_LIST, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_FILTER_LOGIN+"="+login);
		
		if (parser.getDocument()!=null)	parser.printDocument(parser.getDocument().getDocumentElement());
		
		return (parser.getNodeListByXPath("/results/principal-list/principal").getLength()!=0);
	}
	
	//true si est� en adobe y false si no
	public Boolean groupInAdobe(String sid, String groupName) throws Exception
	{
		Parser parser = breezeUrl(ACTION_PRINCIPAL_LIST, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_FILTER_TYPE+"="+"group"+"&"+PARAMETER_FILTER_NAME+"="+URLEncoder.encode(groupName,ENCODING));
		
		return (parser.getNodeListByXPath("/results/principal-list/principal").getLength()!=0);
	}
	
	
	//get principal group id
	private String getPrincipalIdGroup(String sid, String groupName) throws Exception
	{
		Parser parser = breezeUrl(ACTION_PRINCIPAL_LIST, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_FILTER_TYPE+"="+"group"+"&"+PARAMETER_FILTER_NAME+"="+URLEncoder.encode(groupName,ENCODING));
		
		return parser.getNodeAttribute(ELEMENT_PRINCIPAL, ATTRIBUTE_PRINCIPAL_ID);
	}
	
	
	//https://example.com/api/xml?action=principal-update&type=group
	//&has-children=1&name=developersc5
	public boolean createGroup(String sid, String groupName) throws Exception
	{
		Parser parser = breezeUrl(ACTION_PRINCIPAL_UPDATE, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_TYPE+"="+"group"+"&"+
				PARAMETER_HAS_CHILDREN+"="+"1"+"&"+PARAMETER_NAME+"="+URLEncoder.encode(groupName,ENCODING)
			);
		
		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");
	}
	
//Fin modifica UMU
	
	
	private String getPrincipalId(String sid, String login) throws Exception
	{
		Parser parser = breezeUrl(ACTION_PRINCIPAL_LIST, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_FILTER_LOGIN+"="+login);
		
		return parser.getNodeAttribute(ELEMENT_PRINCIPAL, ATTRIBUTE_PRINCIPAL_ID);
	}
	
	public String createMeeting(String sid, String idSitio, String siteType, String siteTerm, String name, String type, Date init_date, Date end_date, boolean isPublic) throws Exception
	{

		String folder = getMyMeetingsFolder(sid, siteType, siteTerm, idSitio);

		String scoId = "";
		
		if(!folder.equals(""))
		{
			scoId = updateSCO_add(sid, idSitio ,folder, name, type, init_date, end_date);
			
			if(scoId.equals("") || !updatePermissions(sid, scoId, "public-access", (isPublic) ? VALUE_PUBLIC_MEETING : VALUE_PROTECTED_MEETING)) 
				scoId = "";
		}
		return scoId;
		
	}
	
	public boolean updateMeeting(String sid, String scoId, String name, String type, Date init_date, Date end_date, boolean isPublic) throws Exception
	{		

		if(updateSCO_update(sid, scoId, name, type, init_date, end_date))	
			return updatePermissions(sid, scoId, "public-access", (isPublic) ? VALUE_PUBLIC_MEETING : VALUE_PROTECTED_MEETING);
		return false;
	}
	
	public String getMeetingName(String sid, String scoId) throws Exception
	{
		Parser parser = breezeUrl(ACTION_GET_SCO, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+scoId);
		
		if(parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok"))
		{
			return  parser.getNodeValue(ELEMENT_NAME);
		}
		
		return "";
	}
	
	public String getMeetingTemplate(String sid, String scoId) throws Exception
	{
		Parser parser = breezeUrl(ACTION_GET_SCO, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+scoId);
		
		if(parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok"))
		{
			return  parser.getNodeAttribute(ELEMENT_SCO, ATTRIBUTE_SOURCE_SCO);
		}
		
		return "";
	}
	
	public String getMeetingURL(String sid, String scoId) throws Exception
	{
		Parser parser = breezeUrl(ACTION_GET_SCO, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+scoId);
		
		if(parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok"))
		{
			return  parser.getNodeValue(ELEMENT_URL);
		}
		
		return "";
	}
	
	public boolean deleteMeeting(String sid, String scoId) throws Exception
	{
		Parser parser = breezeUrl(ACTION_DELETE_SCO, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+scoId);
		
		return parser.getNodeAttribute(ELEMENT_STATUS, ATTRIBUTE_CODE).equals("ok");		
	}
	
	public boolean addHost(String sid, String scoId, String login) throws Exception
	{

		String principalId = getPrincipalId(sid, login);
		
		return updatePermissions(sid, scoId, principalId, "host");
	}
	
//Modifica UMU
	public boolean addPresenter(String sid, String scoId, String login) throws Exception
	{
		String principalId = getPrincipalId(sid, login);
		//permiso de mini-host porque The principal is presenter of a meeting and can present content, share a screen, send text messages, moderate questions, create text notes, broadcast audio and video, and push content from web links.
		return updatePermissions(sid, scoId, principalId, "mini-host");
	}
	
	public boolean addParticipant(String sid, String scoId, String login) throws Exception
	{
		
		String principalId = getPrincipalId(sid, login);

		//permiso de view porque The principal can view, but cannot modify, the SCO. The principal can take a course, attend a meeting as participant, or view a folder�s content
		return updatePermissions(sid, scoId, principalId, "view");
	}
//Fin modifica UMU
	
	public boolean isPublicMeeting(String sid, String aclId) throws Exception
	{
		Parser parser = breezeUrl(ACTION_GET_PERMISSIONS, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_ACL_ID+"="+aclId+"&filter-"+PARAMETER_PRINCIPAL_ID+"=public-access");
		
		//return parser.getNodeByXPath("//"+ELEMENT_PRINCIPAL+"[@"+ATTRIBUTE_PRINCIPAL_ID+"='public-access']/@"+ATTRIBUTE_PERMISSION_ID).equals(VALUE_PUBLIC_MEETING);
		return  parser.getNodeAttribute(ELEMENT_PRINCIPAL, ATTRIBUTE_PERMISSION_ID).equals(VALUE_PUBLIC_MEETING);
	}
	
	public List<VideoconferenceRoomType> getTemplates(String sid) throws Exception
	{
		List<VideoconferenceRoomType> ret = new ArrayList<VideoconferenceRoomType>();
		
		//obtenemos listado de directorios
		Parser parser = breezeUrl(ACTION_LIST_FOLDERS, PARAMETER_SESSION+"="+sid);
		
		//primero buscamos las plantillas en "shared-meeting-templates"
		String folder = parser.getNodeByXPath("//"+ELEMENT_SCO+"[@"+ATTRIBUTE_TYPE+"='my-meeting-templates']/@"+ATTRIBUTE_SCO_ID);
		
		Parser parser2 = breezeUrl(ACTION_FOLDER_CONTENT, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+folder);
		NodeList list = parser2.getNodeListByXPath("//"+ELEMENT_SCO);
		if(list != null)
		{
			for(int i = 0; i < list.getLength(); i++)
			{
				String id = parser2.getNodeAttribute(ELEMENT_SCO, ATTRIBUTE_SCO_ID, list.item(i));
				String name = parser2.getNodeValue(ELEMENT_NAME, list.item(i));
				
				ret.add(new VideoconferenceRoomType(id, name));
			}
		}
		
		//ahora buscamos las plantillas en "my-meeting-templates"
		folder = parser.getNodeByXPath("//"+ELEMENT_SCO+"[@"+ATTRIBUTE_TYPE+"='shared-meeting-templates']/@"+ATTRIBUTE_SCO_ID);
		
		parser2 = breezeUrl(ACTION_FOLDER_CONTENT, PARAMETER_SESSION+"="+sid+"&"+PARAMETER_SCO_ID+"="+folder);
		list = parser2.getNodeListByXPath("//"+ELEMENT_SCO);
		if(list != null)
		{
			for(int i = 0; i < list.getLength(); i++)
			{
				String id = parser2.getNodeAttribute(ELEMENT_SCO, ATTRIBUTE_SCO_ID, list.item(i));
				String name = parser2.getNodeValue(ELEMENT_NAME, list.item(i));				
				
				ret.add(new VideoconferenceRoomType(id, name));
			}
		}
		
		return ret;
	}

}
