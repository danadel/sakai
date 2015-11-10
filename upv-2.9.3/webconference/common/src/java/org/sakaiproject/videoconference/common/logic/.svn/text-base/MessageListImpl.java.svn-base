package org.sakaiproject.videoconference.common.logic;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.sakaiproject.videoconference.api.logic.MessageList;
import org.sakaiproject.videoconference.common.external.I18nService;

public class MessageListImpl implements MessageList {
	
	private List<FacesMessage> messageList;	
	
	public MessageListImpl() {
		this.messageList = new ArrayList<FacesMessage>();
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#hasMessages()
	 */
	public boolean hasMessages()
	{
		return !messageList.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#addMessageError(java.lang.String)
	 */
	public void addMessageError(String msg)
	{
		String message = I18nService.getInstance().getMessage(msg);
		messageList.add(new FacesMessage(FacesMessage.SEVERITY_WARN, msg, message));
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#addMessageInfo(java.lang.String)
	 */
	public void addMessageInfo(String msg)
	{
		String message = I18nService.getInstance().getMessage(msg);
		messageList.add(new FacesMessage(FacesMessage.SEVERITY_INFO, msg, message));
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#addMessageInfo(java.lang.String, java.lang.String[])
	 */
	public void addMessageInfo(String msg, String[] args)
	{
		String message = I18nService.getInstance().getMessage(msg,args);
		messageList.add(new FacesMessage(FacesMessage.SEVERITY_INFO, msg, message));
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#cleanMessageList()
	 */
	public void cleanMessageList()
	{
		messageList = new ArrayList<FacesMessage>();
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.MessageList#getMessageList()
	 */
	public List<FacesMessage> getMessageList() {
		return messageList;
	}
}
