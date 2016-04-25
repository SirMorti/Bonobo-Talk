package de.bonobo_talk.SpringMVCTest.chat;

import java.util.Date;


public class OutputChatMessage extends ChatMessage
{
	private Date time;
	
	public OutputChatMessage(ChatMessage original, Date time)
	{
		super(original.getId(), original.getMessage(), original.getAuthor());
		this.time = time;		
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
