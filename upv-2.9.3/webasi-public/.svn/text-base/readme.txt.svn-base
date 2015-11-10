README.TXT
==========
Este fichero describe cómo configurar la herramienta link-tool cuyo objetivo es mostrar una url parametrizable. Esta URL y los parámetros
 se especifican en el fichero src/bundle/config.properties.
 
Supongamos que tenemos una URL con dos parámetros, llamados P_ASIUPV y P_EDICION_CACA que han sido definidos como propiedades de un site de Sakai con los nombres
 asiupv y term, respectivamente. En este caso, el fichero de configuración tendría el siguiente aspecto:
 
#URL parametrizada
sourceURL = http://www.upv.es?asi=[P_ASIUPV]&caca=[P_EDICION_CACA]

#Hay que especificar el número de parámetros en la URL. En este caso, 2.
param.count = 2

#Nombre de los parámetros en la URL y su correspondencia con la propiedad del site
#param.name.X -> nombre del parámetro en la URL
#param.property.X -> nombre de la propiedad del site correspondiente

param.name.1 = P_ASIUPV
param.property.1 = asiupv

param.name.2 = P_EDICION_CACA
param.property.2 = term

