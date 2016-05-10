package de.bonobo_talk.SpringMVCTest.chat;


/*
 * Class that is used to send Messages from the clients to the Server
 */
public class ChatMessage 
{
	/*
	 * actual message
	 */
	private String message;
	/*
	 * the author
	 */
	private String author;
	/*
	 * some id
	 */
	private int id;
	
	/*
	 * standard constructor 
	 */
	public ChatMessage()
	{
		
	}
	
	/*
	 * initializes the object with the given parameters
	 */
	public ChatMessage(int id, String message, String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
	}

	/*
	 * Getter and Setter
	 */
	/*
	 * returns the message
	 */
	public String getMessage() {
		return message;
	}

	/*
	 * set the value of the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * returns the id
	 */
	public int getId() {
		return id;
	}

	/*
	 * set the value of the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * returns the aouthor
	 */
	public String getAuthor() {
		return author;
	}
	
	/*
	 * get the author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
}
