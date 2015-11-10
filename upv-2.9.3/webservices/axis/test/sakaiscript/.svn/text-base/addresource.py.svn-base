import os
import sys
from SOAPpy import WSDL

username = "profesor"
password = "xxx"
collectionId = "/group-user/TEST/alumno/"

server_url = "http://158.42.8.32:8080"

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/ContentHosting.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

folder="/home/annuelo/Documentos/"
filename = "CURSOMELETE2.pdf"
description = "Descripcion del fichero"
mimetype = "application/pdf"
binary = True # True=Es binario; False=Es texto
pdffile = open(folder + filename, "rb").read().encode("base64")

newItem = scriptsoap.createContentItem(sessionid, filename, collectionId, pdffile, description, mimetype, binary )

print str(newItem)
