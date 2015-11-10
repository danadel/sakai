<%

String userid = (String)request.getAttribute("userid");
String astype = (String)request.getParameter("astype");
String exid = (String)request.getParameter("exid");

%>

<applet code="CodeMarker.CMMain.class" width=800 height=600 codebase="lib" archive="CMarkerApplet.jar, mysql-connector-java-3.1.14-bin.jar"
		    alt="Your browser understands the &lt;APPLET&gt; tag but isn't running the applet, for some reason.">
	<PARAM NAME = "USERID" VALUE = "<%=userid%>">
	<PARAM NAME = "ASTYPE" VALUE ="<%=astype%>">
	<PARAM NAME = "EXID" VALUE="<%=exid%>">
	Your browser is ignoring the &lt;APPLET&gt; tag!
</applet>
	

