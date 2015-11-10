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
title="Prueba Webservices"
description = "Descripcion del site Prueba Webservices"
shortdesc = "Prueba Webservices"
infourl = "url"
skin = ""
tipo = "siteupv"
provider = ""
term = "2013"
asiupv = ""
propietario = ""
aluficticioid = ""
aluficticiopwd = ""
calendarId = ""

newSite = scriptsoap.addNewSiteWithProviderAndCalendar( sessionid, siteid, title, description, shortdesc, infourl, skin, tipo, provider, term, asiupv, propietario, aluficticioid, aluficticiopwd, calendarId)

print str(newSite)
