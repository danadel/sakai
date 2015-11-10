<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="msg" class="org.sakaiproject.util.ResourceLoader" scope="session">
	<jsp:setProperty name="msg" property="baseName" value="org.sakaiproject.tool.encuestas.bundle.Messages"/>
</jsp:useBean>

<f:view>
	<sakai:view toolCssHref="/sakai-upv-encuestas/css/encuesta.css">		                           
    	<h:form id="successForm">
			<h:outputText value="#{msg.success_msg}" styleClass="success"/><br>
			<h:commandButton value="#{msg.go_to_init}" action="encuestas"/>
       	</h:form>
		<sakai:view_title value="#{msg.texto}"   />
		<h:panelGrid columns="1" styleClass="listHier">				
			<h:outputText value="#{msg.texto1}"/>
			<h:outputText value="#{msg.texto2}"/>
			<h:outputText value="#{msg.texto3}"/>
			<h:outputText value="#{msg.texto4}"/>
			<h:outputText value="#{msg.texto5}"/>
			<h:outputText value="#{msg.texto6}"/>
			<h:outputText value="#{msg.texto7}"/>
			<h:outputText value="#{msg.texto8}"/>
			<h:outputText value="#{msg.texto9}"/>
			<h:outputText value="#{msg.texto10}"/>
			<h:outputText value="#{msg.texto11}"/>
		</h:panelGrid>			
                       
	</sakai:view>
</f:view>