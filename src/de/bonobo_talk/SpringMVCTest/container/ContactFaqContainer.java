package de.bonobo_talk.SpringMVCTest.container;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;

/*
 * Kontainer Klasse um eine FAQ-Anfrage zu erstellen
 */
public class ContactFaqContainer 
{
	/*
	 * Attribute für die Kontakt Klasse
	 */
	private String name;
	private String firstname;
	private String email;
	
	/*
	 * Attribute für die FAQItem Klasse
	 */
	private String subject;
	private String message;
	
	/*
	 * Erstellt einen neuen Kontakt auf Basis der Attribute und gibt diesen zurück
	 */
	public Kontakt getContact()
	{
		Kontakt contact = new Kontakt();
		contact.setName(name);
		contact.setVorname(firstname);
		contact.setE_mail(email);

		return contact;
	}
	
	/*
	 * Erstellt ein neues FAQItem auf Basis der Attribute und gibt dieses zurück
	 */
	public FAQItem getFAQItem()
	{
		FAQItem faqItem = new FAQItem();
		
		faqItem.setBetreff(subject);
		faqItem.setInhalt(message);

		return faqItem;
	}
	
	/*
	 * Getter und Setter Methoden
	 */

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
