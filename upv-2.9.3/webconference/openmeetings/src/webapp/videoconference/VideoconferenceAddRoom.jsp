<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<!-- RichFaces tag library declaration -->
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:view>
	<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
	   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.videoconference.messages"/>
	</jsp:useBean>
	
	<sakai:view_container title="#{msgs.title_videoconferenceAddRoom}">
		<style type="text/css">
			@import url("/openmeetings-tool/css/Videoconference.css");
		</style>

		<script type="text/javascript" src="/openmeetings-tool/js/jquery.picklist.js"></script>
		
		<script type="text/javascript">
			function submitPage(button)
			{
				button.disabled='disabled'; 

				getListValue('addUpdateRoom:groupList_selected','addUpdateRoom:hidden_groupList');
				getListValue('addUpdateRoom:userList_selected','addUpdateRoom:hidden_userList');

				unselectListValues();

				clickAcceptButton();
			}

			function orderAll()
			{
				sortOptions("select[name='addUpdateRoom:groupList_selected']");
				sortOptions("select[name='addUpdateRoom:groupList_available']");
				sortOptions("select[name='addUpdateRoom:userList_selected']");
				sortOptions("select[name='addUpdateRoom:userList_available']");
			}
			
			function refreshHeight()
			{
				jQuery("iframe[name^=Main]", parent.document.body).each(function(){					
					var elem = jQuery(this);
					var innerDoc = (elem.get(0).contentDocument) ? elem.get(0).contentDocument : elem.get(0).contentWindow.document;
					elem.height(innerDoc.body.scrollHeight + 35);
				});
			}
		</script>

		<h:form id="listRooms">
			<sakai:tool_bar>
				<sakai:tool_bar_item action="#{VideoconferenceBean.processRoomList}" value="#{msgs.room_list}" />
			</sakai:tool_bar>
		</h:form>

		<sakai:view_content>
			<h:form id="addUpdateRoom">

				<sakai:messages />

			 	<sakai:panel_edit>
				 	<h:outputText value="#{msgs.room_name}" styleClass="panelCell"/>
			 		<h:inputText id="videoconferenceRoom_name" value="#{VideoconferenceBean.currentRoom.room.name}" size="70" />
			 		
			 		<h:outputText value="#{msgs.room_type}" styleClass="panelCell"/>
			 		<h:selectOneMenu id="chooseType" value="#{VideoconferenceBean.currentRoom.room.type}" >
						<f:selectItems value="#{VideoconferenceBean.typeOptions}"/>
					</h:selectOneMenu>
			 		
			 		<h:outputText value="#{msgs.room_capacity}" styleClass="panelCell"/>
			 		<rich:inputNumberSpinner value="#{VideoconferenceBean.currentRoom.room.capacity}" styleClass="panelCell"/>

				 	<h:outputText value="#{msgs.room_init_date}" styleClass="panelCell"/>	
					<h:panelGroup styleClass="panelCell">					
						<rich:calendar value="#{VideoconferenceBean.currentRoom.room.startDate}"
							popup="true"
							locale="#{VideoconferenceBean.locale}"
							datePattern="#{msgs.date_pattern}"
							showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"/>
					</h:panelGroup>

				 	<h:outputText value="#{msgs.room_end_date}" styleClass="panelCell"/>
					<h:panelGroup styleClass="panelCell">
						<rich:calendar value="#{VideoconferenceBean.currentRoom.room.endDate}"
							popup="true"
							locale="#{VideoconferenceBean.locale}"
							datePattern="#{msgs.date_pattern}"
							showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"/>
					</h:panelGroup>
			 	</sakai:panel_edit>
			 	
			 	<rich:jQuery timing="onload" selector="#videoconferenceRoom_name" query="focus()"/>
			 	
			 	<fieldset class="recurrencePanel">
					<legend style="margin-left:10px; padding-right:5px;">						
						<h:selectBooleanCheckbox id="cb_recurrence" value="#{VideoconferenceBean.currentRoom.recurrence}" onclick="togglePanel_recurrence();"/>
						<h:outputText value="#{msgs.room_recurrence}"/>							
					</legend>
					<h:panelGroup id="recurrence_panel">
						<sakai:panel_edit>
							<h:outputText value="#{msgs.recurrence_type}" styleClass="panelCell"/>
							<h:selectOneMenu id="chooseRecurrenceType" value="#{VideoconferenceBean.currentRoom.room.recurrenceType}" >
								<f:selectItem itemValue="day" itemLabel="#{msgs.recurrence_day}"/>
								<f:selectItem itemValue="week" itemLabel="#{msgs.recurrence_week}"/>
								<f:selectItem itemValue="month" itemLabel="#{msgs.recurrence_month}"/>
								<f:selectItem itemValue="year" itemLabel="#{msgs.recurrence_year}"/>
							</h:selectOneMenu> 
							
							<h:outputText value="#{msgs.recurrence_count}" styleClass="panelCell"/>
							<rich:inputNumberSpinner value="#{VideoconferenceBean.currentRoom.room.recurrenceCount}" minValue="1" styleClass="panelCell"/>
						</sakai:panel_edit>
					</h:panelGroup>
				</fieldset>
				
				<rich:jQuery name="togglePanel_recurrence" timing="onJScall" selector="#recurrence_panel" query="slideToggle('slow',function(){refreshHeight()})"/>
				<rich:jQuery timing="onload" selector="#recurrence_panel" query="addClass('#{VideoconferenceBean.currentRoom.recurrenceStyleClass}')"/>
				
				<fieldset class="recurrencePanel">
					<legend style="margin-left:10px; padding:0px 5px;">												
						<h:outputText value="#{msgs.access_options}"/>						
					</legend>
					<h:panelGroup style="margin-bottom: 5px; display:block;">
						<h:selectOneRadio value="#{VideoconferenceBean.currentRoom.room.accessBySite}" layout="pageDirection" onchange="togglePanel_groups()">
							<f:selectItems value="#{VideoconferenceBean.accessOptions}" />
						</h:selectOneRadio>
						<h:panelGroup id="groups_panel" style="margin-left:50px;">
							<h:panelGrid columns="3" style="margin-bottom:20px;" rendered="#{VideoconferenceBean.hasAvailableGroups}">
								<h:outputText value="#{msgs.selected_groups}" style="font-weight: bold; "/>
								<h:outputText value="" styleClass="panelCell"/>
								<h:outputText value="#{msgs.available_groups}" style="font-weight: bold; "/>
							
								<h:selectManyListbox style="width: 250px; height:200px;" id="groupList_selected" ondblclick="move('addUpdateRoom:groupList_selected','addUpdateRoom:groupList_available', false);">
									<f:selectItems  value="#{VideoconferenceBean.currentRoom.groupList_selected}"/>  
								</h:selectManyListbox>
								
								<h:panelGrid columns="1" style="text-align:center;">
									<h:commandButton value="<" title="#{msgs.add_group}" onclick="move('addUpdateRoom:groupList_available','addUpdateRoom:groupList_selected', false); return false;" />
									<h:commandButton value=">" title="#{msgs.remove_group}" onclick="move('addUpdateRoom:groupList_selected','addUpdateRoom:groupList_available', false); return false;" />
									<h:commandButton value="<<" title="#{msgs.add_all_groups}" onclick="move('addUpdateRoom:groupList_available','addUpdateRoom:groupList_selected', true); return false;" />
									<h:commandButton value=">>" title="#{msgs.remove_all_groups}" onclick="move('addUpdateRoom:groupList_selected','addUpdateRoom:groupList_available', true); return false;" />
								</h:panelGrid>
													
								<h:selectManyListbox style="width: 250px; height:200px;" id="groupList_available" ondblclick="move('addUpdateRoom:groupList_available','addUpdateRoom:groupList_selected', false);">  
									<f:selectItems  value="#{VideoconferenceBean.currentRoom.groupList_available}"/>
								</h:selectManyListbox>										
							</h:panelGrid>
							<h:inputHidden id="hidden_groupList" value="#{VideoconferenceBean.currentRoom.serialized_groupList}" />
							 
							<h:panelGrid columns="3">
								<h:outputText value="#{msgs.selected_users}" style="font-weight: bold; "/>
								<h:outputText value="" styleClass="panelCell"/>
								<h:outputText value="#{msgs.available_users}" style="font-weight: bold; "/>
												
								<h:selectManyListbox style="width: 250px; height:200px;" id="userList_selected" ondblclick="move('addUpdateRoom:userList_selected','addUpdateRoom:userList_available', false);">
									<f:selectItems  value="#{VideoconferenceBean.currentRoom.userList_selected}"/>  
								</h:selectManyListbox>
								
								<h:panelGrid columns="1" style="text-align:center;">
									<h:commandButton value="<" title="#{msgs.add_user}" onclick="move('addUpdateRoom:userList_available','addUpdateRoom:userList_selected', false); return false;" />
									<h:commandButton value=">" title="#{msgs.remove_user}" onclick="move('addUpdateRoom:userList_selected','addUpdateRoom:userList_available', false); return false;" />
									<h:commandButton value="<<" title="#{msgs.add_all_users}" onclick="move('addUpdateRoom:userList_available','addUpdateRoom:userList_selected', true); return false;" />
									<h:commandButton value=">>" title="#{msgs.remove_all_users}" onclick="move('addUpdateRoom:userList_selected','addUpdateRoom:userList_available', true); return false;" />
								</h:panelGrid>
													
								<h:selectManyListbox style="width: 250px; height:200px;" id="userList_available" ondblclick="move('addUpdateRoom:userList_available','addUpdateRoom:userList_selected', false);">  
									<f:selectItems  value="#{VideoconferenceBean.currentRoom.userList_available}"/>  
								</h:selectManyListbox>
							</h:panelGrid>
							<h:inputHidden id="hidden_userList" value="#{VideoconferenceBean.currentRoom.serialized_userList}" />
							
							<rich:jQuery selector="window" query="load(function(){orderAll();})"/>													
							<rich:jQuery name="unselectListValues" timing="onJScall" selector="select[name!=addUpdateRoom:chooseRecurrenceType][name!=addUpdateRoom:chooseType] option:selected" query="attr('selected', false)"/>
						</h:panelGroup>
					</h:panelGroup>
				</fieldset>

				<rich:jQuery name="togglePanel_groups" timing="onJScall" selector="#groups_panel" query="slideToggle('slow', function(){refreshHeight();})"/>
				<rich:jQuery timing="onload" selector="#groups_panel" query="addClass('#{VideoconferenceBean.currentRoom.groupsStyleClass}')"/>
				
				<sakai:panel_edit>
				 	<h:outputText value="#{msgs.in_calendar}" styleClass="panelCell" rendered="#{VideoconferenceBean.hasCalendar}"/>
			 		<h:selectBooleanCheckbox value="#{VideoconferenceBean.currentRoom.room.inCalendar}" rendered="#{VideoconferenceBean.hasCalendar}"/>
			 		
			 		<h:outputText value="#{msgs.in_announcement}" styleClass="panelCell" rendered="#{VideoconferenceBean.hasAnnouncement}"/>
			 		<h:selectBooleanCheckbox value="#{VideoconferenceBean.currentRoom.room.inAnnouncements}" rendered="#{VideoconferenceBean.hasAnnouncement}"/>
			 		
			 		<h:outputText value="#{msgs.send_email}" styleClass="panelCell" />
			 		<h:selectBooleanCheckbox value="#{VideoconferenceBean.currentRoom.room.sendEmail}" />
			 	</sakai:panel_edit>

				<sakai:button_bar>
					<h:commandButton id="acceptButton" action="#{VideoconferenceBean.processActionUpdate}" style="display:none"/>
					<h:commandButton value="#{msgs.accept}" onclick="submitPage(this); return false;"/>
					<h:commandButton value="#{msgs.cancel}" action="#{VideoconferenceBean.processActionCancel}" immediate="true" />

					<rich:jQuery name="clickAcceptButton" timing="onJScall" selector="#acceptButton" query="click()"/>
                </sakai:button_bar>
			 </h:form>
  		</sakai:view_content>	
	</sakai:view_container>
</f:view> 
