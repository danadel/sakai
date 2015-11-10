package org.sakaiproject.tool.messageforums.jsf;

import java.util.Map;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.el.ValueBinding;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.sakaiproject.tool.messageforums.DiscussionForumTool;
import org.sakaiproject.api.app.messageforums.Message;

public class AjaxPhaseListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{ForumTool}");
		DiscussionForumTool forumTool = (DiscussionForumTool) binding
				.getValue(context);
		Map requestParams = context.getExternalContext()
				.getRequestParameterMap();

		String action = (String) requestParams.get("action");
		String messageId = (String) requestParams.get("messageId");
		String topicId = (String) requestParams.get("topicId");
		String ajax = (String) requestParams.get("ajax");

		HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
		if ("true".equals(ajax)) {
			try {
				ServletOutputStream out = response.getOutputStream();
				response.setHeader("Pragma", "No-Cache");
				response.setHeader("Cache-Control",
						"no-cache,no-store,max-age=0");
				response.setDateHeader("Expires", 1);
				if (action == null) {
					out.println("FAIL");
				} else if (action.equals("markMessageAsRead") && !"all".equals(messageId)) {
					// Ajax call to mark messages as read for user
					if (messageId != null && topicId != null) {
						if (!forumTool.isMessageReadForUser(Long.valueOf(topicId),
								Long.valueOf(messageId))) {
							forumTool.markMessageReadForUser(Long.valueOf(topicId),
									Long.valueOf(messageId), true);
							out.println("SUCCESS");
						} else {
							// also output success in case message is read, but
							// page rendered mail icon (old state)
							out.println("SUCCESS");
						}
					}
				} else if (action.equals("markMessageAsRead") && "all".equals(messageId)) {
					// Ajax call to mark _all_ messages as read for user
					if (topicId != null) {
						List<Message> messages = forumTool.getMessagesByTopicId(new Long (topicId));						
						for(Message message : messages) {
							if (!forumTool.isMessageReadForUser(new Long(topicId), message.getId())) {
								forumTool.markMessageReadForUser(new Long(topicId),message.getId(), true);			
							} 												
						}
						out.println("SUCCESS");
					}
				}
				out.flush();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			context.responseComplete();
		}
		;
	}

	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
