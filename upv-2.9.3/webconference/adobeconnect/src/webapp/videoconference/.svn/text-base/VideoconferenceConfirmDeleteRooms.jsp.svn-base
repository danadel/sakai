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
		
		<sakai:view_content>
			<h:outputText value="#{msgs.title_videoconferenceConfirmDeleteRoom}" styleClass="h3" style="margin:5px 0px"/>

			<h:panelGroup styleClass="alertMessage">
				<h:outputText value="#{msgs.confirm_delete_rooms}" />
			</h:panelGroup>
			
			<h:dataTable value="#{VideoconferenceBean.confirmRoomList}"	var="entry" styleClass="listHier" style="margin-bottom:20px;">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs.room_name}"/>
					</f:facet>
					<h:outputText value="#{entry.name}"/>
				</h:column>
			</h:dataTable>
			<h:form>
				<h:commandButton id="acceptButton" action="#{VideoconferenceBean.processDeleteRooms}" style="display:none"/>
				<h:commandButton value="#{msgs.accept}" onclick="this.disabled='disabled'; clickAcceptButton(); return false;"/>
				<h:commandButton action="#{VideoconferenceBean.processActionCancel}" id="cancelButton" value="#{msgs.cancel}" />
			</h:form>
			
			<rich:jQuery name="clickAcceptButton" timing="onJScall" selector="#acceptButton" query="click()"/>
		</sakai:view_content>	
	</sakai:view_container>
</f:view>