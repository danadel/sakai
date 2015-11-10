package org.etudes.tool.melete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sakaiproject.jsf.util.JsfTool;
import org.sakaiproject.tool.api.ActiveTool;
import org.sakaiproject.tool.api.ToolException;
import org.sakaiproject.tool.cover.ActiveToolManager;

public class SearchLibraryServlet extends JsfTool {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5675378294820272336L;

	protected void dispatch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// build up the target that will be dispatched to
		String target = req.getPathInfo();

		// UPV: Esto es si viene de melete-->citations
		if ("/sakai.citation.editor.integration.helper".equals(target)) 
		{
			sendToHelper(req, res);
		}
		else {
			super.dispatch(req, res);
		}
	}
	
	protected boolean sendToHelper(HttpServletRequest req, HttpServletResponse res) throws ToolException {
		String path = req.getPathInfo();
		if (path == null) path = "/";
		
		// 0 parts means the path was just "/", otherwise parts[0] = "", parts[1] = item id, parts[2] 
		// if present is "edit"...
		String[] parts = path.split("/");
		
		String helperPath =null;
		String toolPath=null;
		
		// e.g. helper url in Samigo can be /jsf/author/item/sakai.filepicker.helper/tool
		//      or /sakai.filepicker.helper 
		if (parts.length > 2){
			helperPath = parts[parts.length - 2];
			toolPath = parts[parts.length - 1];
		}
		else if (parts.length == 2){
			helperPath = parts[1];
		}
		else return false;
		
		if (!helperPath.endsWith(".helper")) return false;
				
		// calc helper id
		int posEnd = helperPath.lastIndexOf(".");
		String helperId = helperPath.substring(0, posEnd);
		
		ActiveTool helperTool = ActiveToolManager.getActiveTool(helperId);
		
		String url = req.getContextPath() + req.getServletPath();
				
		String context = url + "/"+ helperPath;
		
		if (toolPath != null) 
			helperTool.help(req, res, context, "/"+toolPath);
		else
			helperTool.help(req, res, context, "");
		
		return true; // was handled as helper call
	}
}
