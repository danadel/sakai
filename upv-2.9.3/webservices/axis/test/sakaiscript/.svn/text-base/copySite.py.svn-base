import os
import sys
from SOAPpy import WSDL

username = "admin"
password = "changeit"

server_url = "http://158.42.8.32:8080"

login_url = server_url + "/sakai-axis/SakaiLogin.jws?wsdl"
script_url = server_url + "/sakai-axis/SakaiScript.jws?wsdl"

login_proxy = WSDL.SOAPProxy(login_url)
script_proxy = WSDL.SOAPProxy(script_url)

loginsoap = WSDL.SOAPProxy(login_url)
sessionid = loginsoap.login(username, password)

scriptsoap = WSDL.SOAPProxy(script_url)

siteidtocopy = "PRUEBAWS"
newsiteid = "PRUEBASWSCOPY"
title="Prueba Webservices"
description = "Descripcion del site Prueba Webservices"
shortdesc = "Prueba Webservices"
iconurl = "url"
infourl = "url"
skin = ""
tipo = "siteupv"
joinable = False
joinerrole = "profesor"
published = True
publicview = False
aluficticioid = ""
aluficticiopwd = ""

newSite = scriptsoap.copySite( sessionid, siteidtocopy, newsiteid, title, description, shortdesc, iconurl, infourl, joinable, joinerrole, published, publicview, skin, tipo)

print str(newSite)
