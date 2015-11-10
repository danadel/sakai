<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.videoconference.messages"/>
</jsp:useBean>

<f:view>
	<sakai:view_container title="#{msgs.title_videoconferenceRoomList}">
		<style type="text/css">
			@import url("/adobeconnect-tool/css/Videoconference.css");
		</style>	
		
		<h:form id="listRooms">
			<sakai:tool_bar>
				<sakai:tool_bar_item action="#{VideoconferenceBean.processRoomList}" value="#{msgs.room_list}" />
			</sakai:tool_bar>
		</h:form>
				
		<sakai:view_content>			
			<h:form id="checkStatusForm">				
				<sakai:messages />		
				
				<h:panelGroup styleClass="checkPanel">
					<a4j:region>
						<h:commandLink action="#{VideoconferenceBean.processCheckStatus}">	
							<a4j:support event="onclick" reRender="checkPanel" />
							<h:graphicImage url="/images/refresh.png" title="#{msgs.status_refresh}"/>
						</h:commandLink>
						<h:outputText value="#{msgs.check_status}" styleClass="h3" style="padding-left:10px;"/>
					</a4j:region>
				</h:panelGroup>
				
				<h:panelGrid id="checkPanel" columns="3" styleClass="checkPanel">									
					<h:outputText value="#{msgs.server_status}:" styleClass="text_bold" style="float:right"/>
					<h:outputText value="#{msgs.status_ok}" rendered="#{VideoconferenceBean.pingServer}"/>
					<h:outputText value="#{msgs.status_wrong}" rendered="#{!VideoconferenceBean.pingServer}"/>
					<h:graphicImage url="/images/ok.png" title="#{msgs.status_ok}" rendered="#{VideoconferenceBean.pingServer}"/>
					<h:graphicImage url="/images/wrong.png" title="#{msgs.status_wrong}" rendered="#{!VideoconferenceBean.pingServer}"/>
					 
					<h:outputText value="#{msgs.login_status}:" styleClass="text_bold" style="float:right"/>
					<h:outputText value="#{msgs.status_ok}" rendered="#{VideoconferenceBean.checkLogin}"/>
					<h:outputText value="#{msgs.status_wrong}" rendered="#{!VideoconferenceBean.checkLogin}"/>
					<h:graphicImage url="/images/ok.png" title="#{msgs.status_ok}" rendered="#{VideoconferenceBean.checkLogin}"/>
					<h:graphicImage url="/images/wrong.png" title="#{msgs.status_wrong}" rendered="#{!VideoconferenceBean.checkLogin}"/>
				</h:panelGrid>
			</h:form>
		</sakai:view_content>
	</sakai:view_container>
</f:view>