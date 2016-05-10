package de.bonobo_talk.SpringMVCTest.chat;

import java.util.Date;

/*
 * Class used to send messages from the server to the clients
 * 
 * extends chatMessage and adds a timestamp
 */
public class OutputChatMessage extends ChatMessage
{
	/*
	 * timestamp
	 */
	private Date time;
	
	/*
	 * initializes a OutputChatMessage with the given parameters
	 */
	public OutputChatMessage(ChatMessage original, Date time)
	{
		super(original.getId(), original.getMessage(), original.getAuthor());
		this.time = time;		
	}

	/*
	 * returns the timestamp
	 */
	public Date getTime() {
		return time;
	}

	/*
	 * set the timestamp
	 */
	public void setTime(Date time) {
		this.time = time;
	}
}
