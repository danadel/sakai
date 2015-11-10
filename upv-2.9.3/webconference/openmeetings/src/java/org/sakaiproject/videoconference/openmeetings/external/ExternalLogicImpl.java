
package org.sakaiproject.videoconference.openmeetings.external;

import org.sakaiproject.videoconference.common.external.ExternalLogicBaseImpl;

public class ExternalLogicImpl extends ExternalLogicBaseImpl
{
	public void init()
	{		
		if(functionManager.getRegisteredFunctions(PER_OM_CREATE_ROOM).isEmpty())
			functionManager.registerFunction(PER_OM_CREATE_ROOM);
		if(functionManager.getRegisteredFunctions(PER_OM_EDIT_ROOM).isEmpty())
			functionManager.registerFunction(PER_OM_EDIT_ROOM);
		if(functionManager.getRegisteredFunctions(PER_OM_DELETE_ROOMS).isEmpty())
			functionManager.registerFunction(PER_OM_DELETE_ROOMS);
		if(functionManager.getRegisteredFunctions(PER_OM_ACCESS_ROOM).isEmpty())
			functionManager.registerFunction(PER_OM_ACCESS_ROOM);
		if(functionManager.getRegisteredFunctions(PER_OM_MODERATE_ROOM).isEmpty())
			functionManager.registerFunction(PER_OM_MODERATE_ROOM);
		if(functionManager.getRegisteredFunctions(PER_OM_SEE_ALL_ROOMS).isEmpty())
			functionManager.registerFunction(PER_OM_SEE_ALL_ROOMS);
		if(functionManager.getRegisteredFunctions(PER_OM_CHECK_CONNECTIVITY).isEmpty())
			functionManager.registerFunction(PER_OM_CHECK_CONNECTIVITY);		 
	}	
}
