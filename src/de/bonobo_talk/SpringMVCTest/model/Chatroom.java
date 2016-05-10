package de.bonobo_talk.SpringMVCTest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/*
 *	Modell Klasse für den Chatraum 
 */
@Entity
@Table(name="CHATROOM")
public class Chatroom 
{
	@Id
	@Column(name = "CHATROOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=3, max=50)
	@Column(name = "CHATROOMNAME", nullable = false)
	private String chatroomname;
	
	@Column(name = "MAXUSER", nullable = false)
	private int maxUser;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
    
	/*
	 * Binding zwischen Chatraum und User. wird vom User verwaltet
	 */
    @ManyToMany(mappedBy = "joinedChatrooms", fetch=FetchType.EAGER)
    private Set<User> activeUser;
    
    public Chatroom()
    {
    	
    }

    /*
     * Getter und Setter Methoden
     */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatroomname() {
		return chatroomname;
	}

	public void setChatroomname(String chatroomname) {
		this.chatroomname = chatroomname;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}

	public Set<User> getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Set<User> activeUser) {
		this.activeUser = activeUser;
	}
	
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
 
    @Override
    public String toString() {
        return "Chatroom [id=" + id + ", chatroomname=" + chatroomname + ", maxUser="
                + maxUser + "]";
    }
}
