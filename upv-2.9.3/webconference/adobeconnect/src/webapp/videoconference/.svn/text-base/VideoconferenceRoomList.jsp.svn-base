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
		
		<script language="javascript">
			function selectAllRooms(elem)
			{				
				jQuery("input:checkbox").each(function(){ 
					if(this != elem && !this.disabled)
						this.checked = elem.checked;
				});
			}
			
			function checkDeleteButtonStatus()
			{
				var $elems = jQuery('input:checkbox:checked[id!=roomListForm:roomList:roomSelect_all]');
				jQuery('input:submit[id=roomListForm:deleteRooms]').attr('disabled',($elems.length == 0)); 
			}
		</script>
		
		<h:form id="addRoomForm">				
			<sakai:tool_bar>
				<sakai:tool_bar_item action="#{VideoconferenceBean.processNewRoom}" value="#{msgs.new_room}" rendered="#{VideoconferenceBean.canCreate}"/>
				<sakai:tool_bar_item action="#{VideoconferenceBean.processCheckStatus}" value="#{msgs.check_status}" rendered="#{VideoconferenceBean.canCheckConnectivity}"/>
			</sakai:tool_bar>
		</h:form>
				
		<sakai:view_content>	
			<h:form id="roomListForm">
				
				<sakai:messages />	
				
				<h:dataTable
			 		id="roomList"
			 		value="#{VideoconferenceBean.roomList}"
			 		var="entry"
					styleClass="listHier">
					
					<h:column rendered="#{VideoconferenceBean.canDelete}">
						<f:facet name="header">
							<h:selectBooleanCheckbox id="roomSelect_all" onclick="selectAllRooms(this)"/>
						</f:facet>
						<h:selectBooleanCheckbox id="roomSelect" value="#{entry.selected}" disabled="#{!VideoconferenceBean.checkLogin}"/>
					</h:column>				
					
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs.room_name}"/>
						</f:facet>
						<h:commandLink id="accessLink" action="#{VideoconferenceBean.processEditRoom}" rendered="#{VideoconferenceBean.checkLogin && VideoconferenceBean.canEdit}">							
							<h:outputText value="#{entry.room.name}"/>
						</h:commandLink>
						<h:outputText value="#{entry.room.name}" rendered="#{!VideoconferenceBean.checkLogin || !VideoconferenceBean.canEdit}"/>
					</h:column>
					
					<h:column rendered="#{VideoconferenceBean.canAccess || VideoconferenceBean.canModerate}">
						<f:facet name="header">
							<h:outputText value="#{msgs.room_url}"/>
						</f:facet>
						<h:commandLink id="urlLink" action="#{VideoconferenceBean.processViewURL}" title="#{msgs.view_url}" rendered="#{VideoconferenceBean.checkLogin && entry.room.active}">							
							<h:outputText value="#{entry.room.url}"/>
						</h:commandLink>
						<h:outputText value="#{entry.room.url}" rendered="#{!VideoconferenceBean.checkLogin || !entry.room.active}"/>
					</h:column>
										
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs.room_init_date}"/>
						</f:facet>						
						<h:outputText value="#{entry.startDate}">
							<f:convertDateTime pattern="#{msgs.date_pattern}" locale="#{VideoconferenceBean.locale}" timeZone="#{VideoconferenceBean.userTimeZone}"/>
						</h:outputText>						
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs.room_end_date}"/>
						</f:facet>						
						<h:outputText value="#{entry.endDate}">
							<f:convertDateTime pattern="#{msgs.date_pattern}" locale="#{VideoconferenceBean.locale}" timeZone="#{VideoconferenceBean.userTimeZone}"/>
						</h:outputText>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs.room_session_status}"/>
						</f:facet>						
						<h:outputText value="#{entry.dateStatus}" />
					</h:column>								
				</h:dataTable>
				
				<h:panelGroup rendered="#{!VideoconferenceBean.checkLogin}">
					<sakai:messages />
				</h:panelGroup>	
				
				<sakai:button_bar rendered="#{VideoconferenceBean.canDelete}">					
					<sakai:button_bar_item id="deleteRooms" action="#{VideoconferenceBean.processConfirmDeleteRooms}" value="#{msgs.delete}" />  
	            </sakai:button_bar>
			</h:form>

		<rich:jQuery selector="input:checkbox[id!=roomListForm:roomList:roomSelect_all]" query="click(function(){ if(!this.checked) jQuery('input:checkbox[id=roomListForm:roomList:roomSelect_all]').attr('checked',false)})"/>		
		<rich:jQuery selector="input:checkbox" query="click(function(){ 				
			checkDeleteButtonStatus();	
		})"/>

		<rich:jQuery selector="window" query="load(function(){checkDeleteButtonStatus();})"/>
			
  		</sakai:view_content>	
	</sakai:view_container>
</f:view> 
