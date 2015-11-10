
package org.sakaiproject.videoconference.adobeconnect.external;

import org.sakaiproject.videoconference.common.external.ExternalLogicBaseImpl;

public class ExternalLogicImpl extends ExternalLogicBaseImpl
{
	public void init()
	{		
		if(functionManager.getRegisteredFunctions(PER_CNN_CREATE_ROOM).isEmpty())
			functionManager.registerFunction(PER_CNN_CREATE_ROOM);
		if(functionManager.getRegisteredFunctions(PER_CNN_EDIT_ROOM).isEmpty())
			functionManager.registerFunction(PER_CNN_EDIT_ROOM);
		if(functionManager.getRegisteredFunctions(PER_CNN_DELETE_ROOMS).isEmpty())
			functionManager.registerFunction(PER_CNN_DELETE_ROOMS);
		if(functionManager.getRegisteredFunctions(PER_CNN_ACCESS_ROOM).isEmpty())
			functionManager.registerFunction(PER_CNN_ACCESS_ROOM);
		if(functionManager.getRegisteredFunctions(PER_CNN_MODERATE_ROOM).isEmpty())
			functionManager.registerFunction(PER_CNN_MODERATE_ROOM);
		if(functionManager.getRegisteredFunctions(PER_CNN_SEE_ALL_ROOMS).isEmpty())
			functionManager.registerFunction(PER_CNN_SEE_ALL_ROOMS);
		if(functionManager.getRegisteredFunctions(PER_CNN_CHECK_CONNECTIVITY).isEmpty())
			functionManager.registerFunction(PER_CNN_CHECK_CONNECTIVITY);		 
	}
}
