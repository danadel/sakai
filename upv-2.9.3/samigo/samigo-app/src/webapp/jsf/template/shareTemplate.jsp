<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://www.sakaiproject.org/samigo" prefix="samigo" %>
<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<!-- $Id: shareTemplate.jsp 22618 2013-06-14 19:58:35Z anueda@indra.es $
<%--
***********************************************************************************
*
* Copyright (c) 2006 The Sakai Foundation.
*
* Licensed under the Educational Community License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.osedu.org/licenses/ECL-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.s
* See the License for the specific language governing permissions and
* limitations under the License. 
*
**********************************************************************************/
--%>
-->
  <f:view>
    <html xmlns="http://www.w3.org/1999/xhtml">
      <head><%= request.getAttribute("html.head") %>
      <title><h:outputText value="#{templateMessages.p_mgr}"/></title>
<script language="javascript" type="text/JavaScript">
<!--
<%@ include file="/js/samigotree.js" %>

	function checkUpdate() {
	 	var tables= document.getElementsByTagName("INPUT");
	 	for (var i = 0; i < tables.length; i++) {
	    	if (tables[i].name.indexOf("revokeCheckbox") >= 0 ||
	    			tables[i].name.indexOf("grantCheckbox") >= 0) {

	         	if(tables[i].checked) {   
	            	abledButton();
	             	break;
	         	}
	         	else disabledButton();
	    	}
	 	}
	}

	function disabledButton() {
	  	var inputs= document.getElementsByTagName("INPUT");
	  	for (var i = 0; i < inputs.length; i++){
	    	if (inputs[i].name.indexOf("Submit") >=0) {
	      		inputs[i].disabled=true;
		  		inputs[i].className='disabled';
			}
	  	}
	}
	
	function abledButton() {
	  	var inputs= document.getElementsByTagName("INPUT");
	  	for (var i = 0; i < inputs.length; i++) {
	    	if (inputs[i].name.indexOf("Submit") >=0) {
	      		inputs[i].disabled=false;
		  		inputs[i].className='enabled';
			}
	  	}
	}

//-->
</script>
<%@ include file="/js/mathjax_header.js" %>
      </head>
<body onload="collapseAllRows();flagRows();disabledButton();<%= request.getAttribute("html.body.onload") %>">
 <%@ include file="/js/mathjax_config.js" %> 
 <div class="portletBody">
<!-- content... -->
<h:form id="shareTemplate">

<f:verbatim><ul class="navIntraTool actionToolbar" role="menu">
<li role="menuitem" class="firstToolBarItem"><span></f:verbatim>
   	<h:commandLink title="#{generalMessages.t_assessment}" action="author"  immediate="true">
   		<h:outputText value="#{generalMessages.assessment}"/>
       	<f:actionListener
         	type="org.sakaiproject.tool.assessment.ui.listener.author.AuthorActionListener" />
   	</h:commandLink>
       
<f:verbatim></span></li></f:verbatim>
<h:panelGroup rendered="#{authorization.adminTemplate and template.showAssessmentTypes}">
<f:verbatim><li role="menuitem"><span></f:verbatim>

	<h:outputText value="#{generalMessages.template}"/>
<f:verbatim></span></li></f:verbatim>
</h:panelGroup>
<f:verbatim><li role="menuitem"><span></f:verbatim>

   	<h:commandLink title="#{generalMessages.t_questionPool}" action="poolList" immediate="true">
      <h:outputText value="#{generalMessages.questionPool}" />
    </h:commandLink>
<f:verbatim></span></li>
</ul></f:verbatim>


 <h3><h:outputText value="#{templateMessages.share_template}"/></h3>

<h:messages infoClass="validation" warnClass="validation" errorClass="validation" fatalClass="validation"/>

<div class="tier1">
<h4><h:outputText value="#{templateMessages.members_with_access} #{templateShare.templateTitle}"/></h4>
</div>

<div class="tier2">
<h:dataTable cellpadding="0" cellspacing="0" id="withAccessTable" value="#{templateShare.agentsWithAccess}"
    var="agent" styleClass="listHier" >

    <h:column id="col1">

     	<f:facet name="header">
      		<h:panelGroup>
		       	<h:commandLink title="#{templateMessages.alt_sortName}" id="sortByDisplayName" immediate="true"  rendered="#{templateShare.sortPropertyWith !='displayName'}" action="#{templateShare.sortByColumnHeader}">
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="true"/>
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:outputText  value="#{templateMessages.name}"  rendered="#{templateShare.sortPropertyWith !='displayName'}" />
		       	</h:commandLink>
      
		       	<h:commandLink title="#{templateMessages.alt_sortName}" immediate="true" rendered="#{templateShare.sortPropertyWith =='displayName' && templateShare.sortAscendingWith }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.name}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWith =='displayName'}" />
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="false" />
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortNameDescending}" rendered="#{templateShare.sortAscendingWith}" url="/images/sortascending.gif"/>
		      	</h:commandLink>

		      	<h:commandLink title="#{templateMessages.alt_sortName}" immediate="true" rendered="#{templateShare.sortPropertyWith =='displayName' && !templateShare.sortAscendingWith }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.name}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWith =='displayName'}" />
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="true" />
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortNameAscending}" rendered="#{!templateShare.sortAscendingWith}" url="/images/sortdescending.gif"/>
		      	</h:commandLink>
     		</h:panelGroup>
     	</f:facet>

		<h:panelGroup id="firstcolumn">
  			<h:outputText value="#{agent.agentDisplayName}"/>
		</h:panelGroup>
	</h:column>

  
    <h:column id="col2">
     	<f:facet name="header">
     		<h:panelGroup>
       			<h:commandLink title="#{templateMessages.alt_sortRole}" id="sortByRole" immediate="true"  rendered="#{templateShare.sortPropertyWith !='role'}" action="#{templateShare.sortByColumnHeader}">
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="true"/>
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:outputText  value="#{templateMessages.role}"  rendered="#{templateShare.sortPropertyWith !='role'}" />
		       	</h:commandLink>
      
		       	<h:commandLink title="#{templateMessages.alt_sortRole}" immediate="true" rendered="#{templateShare.sortPropertyWith =='role' && templateShare.sortAscendingWith }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.role}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWith =='role'}" />
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="false" />
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortRoleDescending}" rendered="#{templateShare.sortAscendingWith}" url="/images/sortascending.gif"/>
		      	</h:commandLink>
		      	<h:commandLink title="#{templateMessages.alt_sortRole}" immediate="true" rendered="#{templateShare.sortPropertyWith =='role' && !templateShare.sortAscendingWith }"  action="#{templateShare.sortByColumnHeader}">
		          	<h:outputText  value="#{templateMessages.role}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWith =='role'}" />
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="true" />
					<f:param name="list" value="agentsWithAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortRoleAscending}" rendered="#{!templateShare.sortAscendingWith}" url="/images/sortdescending.gif"/>
		      	</h:commandLink>
     		</h:panelGroup>
     	</f:facet>
     	<h:panelGroup id="secondcolumn">
        	<h:outputText value="#{agent.role}" />
     	</h:panelGroup>
    </h:column>

    <h:column id="col3" >
     	<f:facet name="header">
       		<h:outputText value="#{templateMessages.revoke_access}"/>
     	</f:facet>
		<h:selectManyCheckbox id="revokeCheckbox" value ="#{templateShare.destTemplates}" onclick="checkUpdate();" onkeypress="checkUpdate();">
			<f:selectItem itemValue="#{agent.agentId}" itemDisabled="#{agent.agentId == templateShare.templateCreatedBy}" itemLabel=""/>
		</h:selectManyCheckbox>
	</h:column>

</h:dataTable>
</div>

<br/>

<div class="tier1">
<h4><h:outputText value="#{templateMessages.members_without_access} #{templateShare.templateTitle}"/></h4>
</div>

<div class="tier2">
<h:dataTable cellpadding="0" cellspacing="0" id="withoutAccessTable" value="#{templateShare.agentsWithoutAccess}"
    binding="#{templateShare.dataTable}" var="agent" styleClass="listHier" >

    <h:column id="col1" >

     	<f:facet name="header">
      		<h:panelGroup>
		       	<h:commandLink title="#{templateMessages.alt_sortName}" id="sortByDisplayName" immediate="true"  rendered="#{templateShare.sortPropertyWithout !='displayName'}" action="#{templateShare.sortByColumnHeader}">
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="true"/>
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:outputText  value="#{templateMessages.name}" rendered="#{templateShare.sortPropertyWithout !='displayName'}" />
		       	</h:commandLink>
      
		       	<h:commandLink title="#{templateMessages.alt_sortName}" immediate="true" rendered="#{templateShare.sortPropertyWithout =='displayName' && templateShare.sortAscendingWithout }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.name}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWithout =='displayName'}" />
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="false" />
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortNameDescending}" rendered="#{templateShare.sortAscendingWithout}" url="/images/sortascending.gif"/>
		      	</h:commandLink>

		      	<h:commandLink title="#{templateMessages.alt_sortName}" immediate="true" rendered="#{templateShare.sortPropertyWithout =='displayName' && !templateShare.sortAscendingWithout }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.name}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWithout =='displayName'}" />
		          	<f:param name="orderBy" value="displayName"/>
		          	<f:param name="ascending" value="true" />
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortNameAscending}" rendered="#{!templateShare.sortAscendingWithout}" url="/images/sortdescending.gif"/>
		      	</h:commandLink>
     		</h:panelGroup>
     	</f:facet>

		<h:panelGroup id="firstcolumn">
  			<h:outputText value="#{agent.agentDisplayName}"/>
		</h:panelGroup>
	</h:column>

  
    <h:column id="col2">
     	<f:facet name="header">
     		<h:panelGroup>
       			<h:commandLink title="#{templateMessages.alt_sortRole}" id="sortByRole" immediate="true"  rendered="#{templateShare.sortPropertyWithout !='role'}" action="#{templateShare.sortByColumnHeader}">
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="true"/>
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:outputText  value="#{templateMessages.role}" rendered="#{templateShare.sortPropertyWithout !='role'}" />
		       	</h:commandLink>
      
		       	<h:commandLink title="#{templateMessages.alt_sortRole}" immediate="true" rendered="#{templateShare.sortPropertyWithout =='role' && templateShare.sortAscendingWithout }"  action="#{templateShare.sortByColumnHeader}">
		           	<h:outputText  value="#{templateMessages.role}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWithout =='role'}" />
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="false" />
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortRoleDescending}" rendered="#{templateShare.sortAscendingWithout}" url="/images/sortascending.gif"/>
		      	</h:commandLink>
		      	<h:commandLink title="#{templateMessages.alt_sortRole}" immediate="true" rendered="#{templateShare.sortPropertyWithout =='role' && !templateShare.sortAscendingWithout }"  action="#{templateShare.sortByColumnHeader}">
		          	<h:outputText  value="#{templateMessages.role}" styleClass="currentSort" rendered="#{templateShare.sortPropertyWithout =='role'}" />
		          	<f:param name="orderBy" value="role"/>
		          	<f:param name="ascending" value="true" />
					<f:param name="list" value="agentsWithoutAccess"/>
		          	<h:graphicImage alt="#{templateMessages.alt_sortRoleAscending}" rendered="#{!templateShare.sortAscendingWithout}" url="/images/sortdescending.gif"/>
		      	</h:commandLink>
     		</h:panelGroup>
     	</f:facet>
     	<h:panelGroup id="secondcolumn">
        	<h:outputText value="#{agent.role}"/>
     	</h:panelGroup>
    </h:column>
    
    <h:column id="col3" >
     	<f:facet name="header">
       		<h:outputText value="#{templateMessages.grant_access}"/>
     	</f:facet>
		<h:selectManyCheckbox id="grantCheckbox" value ="#{templateShare.destTemplates}" onclick="checkUpdate();" onkeypress="checkUpdate();">
			<f:selectItem itemValue="#{agent.agentId}" itemLabel=""/>
		</h:selectManyCheckbox>
	</h:column>

</h:dataTable>
</div>

<p class="act">
 
  <h:commandButton type="submit" immediate="true" id="Submit" value="#{templateMessages.save}" action="#{templateShare.shareTemplate}" >
  </h:commandButton>

  <h:commandButton type="submit" immediate="true" id="cancel" value="#{commonMessages.cancel_action}" action="template"  >
  </h:commandButton>
</p>

</h:form>
</div>
      </body>
    </html>
  </f:view>
