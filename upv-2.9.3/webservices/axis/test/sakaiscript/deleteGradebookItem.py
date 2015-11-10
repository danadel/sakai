import os
import sys
from SOAPpy import WSDL

username = "professor"
password = "x"
siteId = "ALU_0_1"
gradebookName = "Examen Febrero" 

server_url = "http://158.42.8.32:8080"

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/SakaiGradebook.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

result = scriptsoap.removeAssignment(sessionid, siteId, gradebookName)

print str(result)
