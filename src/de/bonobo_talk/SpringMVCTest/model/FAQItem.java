package de.bonobo_talk.SpringMVCTest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FAQITEM")
public class FAQItem 
{
	@Id
    @Column(name = "FAQITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "BETREFF")
	private String betreff;
	
	@Column(name = "INHALT")
	private String inhalt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Kontakt kontakt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FAQItem frage;
	
	@OneToMany(mappedBy = "frage", cascade = CascadeType.ALL)
	private Set<FAQItem> antworten;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBetreff() {
		return betreff;
	}

	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Kontakt getKontakt() {
		return kontakt;
	}

	public void setKontakt(Kontakt kontakt) {
		this.kontakt = kontakt;
	}

	public FAQItem getFrage() {
		return frage;
	}

	public void setFrage(FAQItem frage) {
		this.frage = frage;
	}

	public Set<FAQItem> getAntworten() {
		return antworten;
	}

	public void setAntworten(Set<FAQItem> antworten) {
		this.antworten = antworten;
	}
	
	public String toString()
	{
		return "FAQItem [id=" + id + ", betreff=" + betreff + ", inhalt="
                + inhalt + ", kontaktId=" + kontakt.getId() + ", frageId=" + frage.getId() +"]";
	}
}
