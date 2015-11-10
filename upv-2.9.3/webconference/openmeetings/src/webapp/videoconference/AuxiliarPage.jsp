<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:view>	
	<h:form id="auxiliar">
		<h:commandButton action="#{VideoconferenceBean.processBypass}" id="submitButton" style="display:none;"/>
	</h:form>
	
	<rich:jQuery timing="onload" selector="#submitButton" query="click()"/>
</f:view>