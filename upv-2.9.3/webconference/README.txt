This is a product from Samoo.

To install this tool you should run the following command from within the root directory to download all the dependencies using maven and compile the code:
	MAVEN 1.0.2: maven bld
	MAVEN 2.x: mvn install
	
To configure properly this tool you must add the following lines to your sakai.properties:
	samoo.connect.url=host:port
	samoo.connect.username=username
	samoo.connect.password=password
	and/or
	samoo.openmeetings.url=host:port
	samoo.openmeetings.username=username
	samoo.openmeetings.password=password

You can administrate its permissions. They are:
- samoo.videoconference.connect.room.new: allows a user to create a new room
- samoo.videoconference.connect.room.access: allows a user to acces a room created by this tool
- samoo.videoconference.connect.room.delete: allows a user to delete a room  created by this tool
- samoo.videoconference.connect.room.edit: allows a user to edit a room created by this tool
- samoo.videoconference.connect.room.moderate: allows a user to moderate a room created by this tool
- samoo.videoconference.connect.room.see_all: allows a user to see all rooms created by this tool, even if the user is not in the list of allowed users, or not pertains to any of the allowed groups
and/or
- samoo.videoconference.openmeetings.room.new: allows a user to create a new room
- samoo.videoconference.openmeetings.room.access: allows a user to acces a room created by this tool
- samoo.videoconference.openmeetings.room.delete: allows a user to delete a room  created by this tool
- samoo.videoconference.openmeetings.room.edit: allows a user to edit a room created by this tool
- samoo.videoconference.openmeetings.room.moderate: allows a user to moderate a room created by this tool
- samoo.videoconference.openmeetings.room.see_all: allows a user to see all rooms created by this tool, even if the user is not in the list of allowed users, or not pertains to any of the allowed groups
	
To access to the Adobe Acrobat Connect Pro server, you could need to install a certificate into your Java virtual machine. To do that, download the certificate from the Web page, and install it with the following command:
keytool -import -keystore path_to_JRE\lib\security\cacerts -file path_to_certificate -storepass STOREPASS (by default: changeit)

Comments or questions about the tool should go to Francisco Saez (francisco.saez@samoo.es)