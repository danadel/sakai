<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.videoconference.messages"/>
</jsp:useBean>

<f:view>	
	<sakai:view_container title="erererer">
		<style type="text/css">
			@import url("/adobeconnect-tool/css/Videoconference.css");
		</style>
		
		<h:form id="listRooms">
			<sakai:tool_bar>
				<sakai:tool_bar_item action="#{VideoconferenceBean.processRoomList}" value="#{msgs.room_list}" />
			</sakai:tool_bar>
		</h:form>
		
		<sakai:view_content>				
			<h:outputText value="URL: #{VideoconferenceBean.url}" styleClass="h3" style="margin:10px; display:block;" escape="false"/>						
		</sakai:view_content>	
	</sakai:view_container>
</f:view>