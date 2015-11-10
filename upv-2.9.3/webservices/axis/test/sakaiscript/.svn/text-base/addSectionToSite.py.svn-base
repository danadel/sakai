import os
import sys
from SOAPpy import WSDL

username = "admin"
password = "changeit"

server_url = "http://158.42.8.32:8080"

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/SakaiScriptUPV.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

siteid = "PRUEBAWS"
section = "GRUPO_1"

section = scriptsoap.addSectionToSite( sessionid, siteid, section)

print str(section)
