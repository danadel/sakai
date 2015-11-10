<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@include file="accesscheck.jsp" %>
<%
final javax.faces.context.FacesContext facesContext = javax.faces.context.FacesContext.getCurrentInstance();
final org.sakaiproject.util.ResourceLoader msg = (org.sakaiproject.util.ResourceLoader)facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "msgs");
String windowName = "Melete - " + msg.getString("link_content_edit");
%>
<title><%=windowName%></title>

<link href="rtbc004.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="js/headscripts.js"></script>
<script type="text/javascript" >
function copyToClipboard(copytext)
{
	if( window.clipboardData && clipboardData.setData )
	{
		clipboardData.setData("Text", copytext);
	}
	else
	{
		// You have to sign the code to enable this or allow the action in about:config by changing
		//user_pref("signed.applets.codebase_principal_support", true);
		netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');

		var str = Components.classes["@mozilla.org/supports-string;1"].  
		createInstance(Components.interfaces.nsISupportsString);  
		if (!str) return false;  
		  
		str.data = copytext;  
		  
		var trans = Components.classes["@mozilla.org/widget/transferable;1"].  
		createInstance(Components.interfaces.nsITransferable);  
		if (!trans) return false;  
		  
		trans.addDataFlavor("text/unicode");  
		trans.setTransferData("text/unicode", str, copytext.length * 2);  
		  
		var clipid = Components.interfaces.nsIClipboard;  
		var clip = Components.classes["@mozilla.org/widget/clipboard;1"].getService(clipid);  
		if (!clip) return false;  
		  
		clip.setData(trans, null, clipid.kGlobalClipboard); 
	}
}

function copyToTextfield(copytext) 
{
	document.getElementById('url').value = copytext; 
	document.getElementById('url').focus();
	document.getElementById('url').select();
}
</script>

</head>
<f:view>
<body onLoad="setMainFrameHeight('<h:outputText value="#{meleteSiteAndUserInfo.winEncodeName}"/>');">
<table border="0" height="350" cellpadding="0" cellspacing="0" class ="table3">
	<tr>
		<td valign="top"> 		&nbsp;		</td>
		<td width="1962" valign="top">
		  <table width="100%" border="0" cellpadding="3" cellspacing="0" bordercolor="#EAEAEA" style="border-collapse: collapse">
			<tr>
				<td>
					<div class="meletePortletToolBarMessage"><img src="images/page_go.png" alt="" width="16" height="16" align="absbottom"><h:outputText id="main_title" value=" #{msgs.link_to_sections}" /> </div>
				</td>
			</tr>
			<tr>
				<td>
					<h:outputText value="#{msgs.link_url} " /><h:inputText size="90" id="url" readonly="true" value="" />
				</td>
			</tr>
			<tr>
				<td>
					<p><br/></p>
					<p><h:outputText value="#{msgs.link_instruc1}" /><br/>
					<h:outputText value="#{msgs.link_instruc2}" /></p>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h:outputLink onclick="window.close();" >
						<h:outputText value="#{msgs.link_close}" />
					</h:outputLink>
				</td>
			</tr>
			<tr>
				<td class="maintabledata3">
					<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#EAEAEA" width="100%" id="AutoNumber1" >
					<tr>
    	   				<td colspan="2" valign="top">
 							<h:dataTable id="table" 
           								value="#{listModulesPage.sections}"
                  						var="sBean"   
                  						rowClasses="row1,row2"  
              							columnClasses="ListTitleClass,ListDateClass" 
              							headerClass="tableheader"
                   						border="0" cellpadding="3" width="100%" 
                   						summary="#{msgs.list_modules_stud_summary}">
      							<h:column>   
	      							       
					              	<f:facet name="header">
						    	  		<h:outputText value="#{msgs.link_name_seccion}" />
						    		</f:facet>  
						    
					             	<h:outputText id="sectitleEditorTxt2" value="#{sBean.title}" />
					            </h:column>
							             
					            <h:column>
				           			<f:facet name="header">
						             	<h:panelGroup>
						             		<h:outputText value="#{msgs.link_copy_section}" />
						             	</h:panelGroup>
				           			</f:facet>  
						           	
									<h:outputText escape="false" value="#{sBean.instr}" />
			          			</h:column>
					        </h:dataTable>

	  					</td>
         		  	</tr>
         		    </table>       
         		</td>
         	</tr>
         	<tr>
				<td align="center">
					<h:outputLink onclick="window.close();" >
						<h:outputText value="#{msgs.link_close}" />
					</h:outputLink> 
				</td>
			</tr>
          </table>
      	</td>
     </tr>
</table>
</body>
</f:view> 
</html>
    		    		   