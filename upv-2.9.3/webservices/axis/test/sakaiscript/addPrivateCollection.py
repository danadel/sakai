import os
import sys
from SOAPpy import WSDL

username = "admin"
password = "changeit" ##### change it for the real password #####
folder = "private"       ##### the folder to create as private collection ##### 
siteId = "ALU_0_1" 		### the new site
server_url = "http://localhost:8080" ##### put the server url #####

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/SakaiScriptUPV.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

result = scriptsoap.createPrivateCollection(sessionid, folder, siteId)
print str(result)
