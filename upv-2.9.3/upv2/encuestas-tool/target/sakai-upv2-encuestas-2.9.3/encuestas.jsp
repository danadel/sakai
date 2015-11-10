<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="msg" class="org.sakaiproject.util.ResourceLoader" scope="session">
	<jsp:setProperty name="msg" property="baseName" value="org.sakaiproject.tool.encuestas.bundle.Messages"/>
</jsp:useBean>

<f:view>
	<sakai:view toolCssHref="/sakai-upv-encuestas/css/encuesta.css"> 

		<h:form id="encuestasForm">			
			<sakai:tool_bar rendered="#{encuestas.isInstructorUser}">
				<sakai:tool_bar_item action="#{encuestas.nuevaEncuesta}" value="#{msg.nueva}" />
			</sakai:tool_bar>
			
			<sakai:view_title rendered="#{!(encuestas.hayEncuestasAlumno) && !(encuestas.hayEncuestasProf)}" value="#{msg.mensaje}"/>
			
			<sakai:view_title rendered="#{encuestas.hayEncuestasAlumno}" value="#{msg.titulo}"   />
			 
			<h:dataTable id="encuestas" value="#{encuestas.encuestasXML}" var="pase" 
				cellpadding="0" cellspacing="0" styleClass="listHier lines" 
				rendered="#{encuestas.hayEncuestasAlumno}" 
				columnClasses="left,center,center,center,center">					
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.desc}" />
					</f:facet>
					<h:outputText value="#{pase.descripcion}" />
				</h:column>	
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.fini}" />
					</f:facet>
					<h:outputText value="#{pase.fechaInicio}"/>
				</h:column>
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.ffin}" />
					</f:facet>
					<h:outputText value="#{pase.fechaFin}" />
				</h:column>	
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.contestado}"/>
					</f:facet>
					<h:graphicImage rendered="#{!pase.contestado}" value="images/ico_cru.gif" height="22" width="20" />
					<h:graphicImage rendered="#{pase.contestado}" value="images/ico_ok.gif" height="22" width="20" />
				</h:column>		
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.links}" />
					</f:facet>
					<h:dataTable styleClass="listHier" id="links" value="#{pase.links.link}" var="link">
						<h:column>
							<h:outputLink target="_new#{link.etiqueta}" value="#{link.url}"><h:outputText value="#{link.etiqueta}" /></h:outputLink>								  
						</h:column>	
					</h:dataTable>									
				</h:column>
			</h:dataTable>
			
			<sakai:view_title rendered="#{encuestas.hayEncuestasProf}" value="#{msg.tituloProf}"   />

			<sakai:doc_section_title><h:outputText rendered="#{encuestas.yaHayNuevaEncuesta && encuestas.isInstructorUser}" value="#{msg.mensNuevaEnc}" /></sakai:doc_section_title>	
			
			<h:dataTable id="encuestasProf" value="#{encuestas.encuestasProfXML}" 
				var="paseProf" cellpadding="0" cellspacing="0"
				styleClass="listHier lines" rendered="#{encuestas.hayEncuestasProf}"
				columnClasses="rightpadded,left,center,center,left,center,center">
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.idPase}" />
					</f:facet>
					<h:outputText value="#{paseProf.idPase}" />
				</h:column>
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.desc}" />
					</f:facet>
					<h:outputText value="#{paseProf.descripcion}" />
				</h:column>	
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.fini}" />
					</f:facet>
					<h:outputText value="#{paseProf.fechaInicio}" />
				</h:column>
				<h:column>
					<f:facet name="header">
			                <h:outputText value="#{msg.ffin}" />
					</f:facet>
					<h:outputText value="#{paseProf.fechaFin}" />
				</h:column>	
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.tipo}" />
					</f:facet>
					<h:outputText value="#{paseProf.tipo}" />
				</h:column>	
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.numResp}" />
					</f:facet>
					<h:outputText value="#{paseProf.numRespuestas}" />
				</h:column>			
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.links}" />
					</f:facet>
					<h:dataTable id="linksProf" styleClass="listHier" value="#{paseProf.links.link}" var="linkProf">
						<h:column>
							<h:outputLink target="_new#{linkProf.etiqueta}" value="#{linkProf.url}">
								<h:outputText value="#{linkProf.etiqueta}" />
							</h:outputLink>								  
						</h:column>	
					</h:dataTable>									
				</h:column>
			</h:dataTable>

		</h:form>
		<sakai:view_title rendered="#{encuestas.hayEncuestasProf}" value="#{msg.texto}"   />
		<h:panelGrid columns="1" rendered="#{encuestas.hayEncuestasProf}" styleClass="listHier">				
			<h:outputText value="#{msg.texto0}"/>
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
