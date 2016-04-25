package de.bonobo_talk.SpringMVCTest.chat;

public class ChatMessage 
{
	private String message;
	private String author;
	private int id;
	
	public ChatMessage()
	{
		
	}
	
	public ChatMessage(int id, String message, String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
