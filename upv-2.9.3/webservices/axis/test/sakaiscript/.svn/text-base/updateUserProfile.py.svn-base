import os
import sys
from SOAPpy import WSDL

username = "admin"
password = "changeit"

server_url = "http://158.42.8.32:8080"

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/WSProfile.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

userid = "alumno"
firstName = "Alumno"
lastName = "De pruebas"
email = "alumno@depruebas.es"
dept = "" 
type = "alumno" 
photo = ""

result = scriptsoap.updateUserProfile( sessionid, userid, firstName, lastName, email, dept, type, photo)

print str(result)
