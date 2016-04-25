package de.bonobo_talk.SpringMVCTest.container;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;

public class ContactFaqContainer 
{
	private String name;
	private String firstname;
	private String email;
	
	
	private String subject;
	private String message;
	
	public Kontakt getContact()
	{
		Kontakt contact = new Kontakt();
		contact.setName(name);
		contact.setVorname(firstname);
		contact.setE_mail(email);

		return contact;
	}
	
	public FAQItem getFAQItem()
	{
		FAQItem faqItem = new FAQItem();
		
		faqItem.setBetreff(subject);
		faqItem.setInhalt(message);

		return faqItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
