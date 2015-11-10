<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.videoconference.messages"/>
</jsp:useBean>


<f:view>	
	<h:graphicImage url="/images/loading.gif"/>
		
	<h:form id="loadingRoom">
		<h:commandButton action="#{VideoconferenceBean.processLoadingReturn}" id="submitButton" style="display:none;"/>
		<h:inputHidden id="popupBlocked" value="false" binding="#{VideoconferenceBean.popupBlocked}" />
	</h:form>
	
	<script language="javascript">
		var w = window.open("<h:outputText value="#{VideoconferenceBean.url}" escape="false"/>",'Videoconference','resizable=yes,toolbar=no,scrollbars=yes, width=800,height=600');
		var is_chrome = (navigator.userAgent.toLowerCase().indexOf('chrome') >  -1);
		
		if(w)
		{
			if (is_chrome) {w.parent.blur();}
		w.focus();
		}
		else
			document.getElementById("loadingRoom:popupBlocked").value="true";
		
		
		/*function hasPopupBlocker(win)
		{
			var ret = false;
			var is_IE = (navigator.userAgent.indexOf('MSIE') > -1);
	
			if(win)
			{	
				try {			
					if(typeof win == 'undefined' || win.closed || (!is_IE && !win.innerWidth))
						ret = true;			
				}catch(ex){}
			}
			else
				ret = true;
	
			return ret;
		}*/
	</script>
	
	<rich:jQuery timing="onload" selector="#submitButton" query="click()"/>
</f:view>