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
	
	@Column(name = "CATEGORY")
	private String category;

	@NotEmpty
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "joinedChatrooms",cascade = CascadeType.ALL)
    private Set<User> activeUser;
    
    public Chatroom()
    {
    	
    }

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
	
	public String getSsn() {
		return ssn;
	}

	public Set<User> getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Set<User> activeUser) {
		this.activeUser = activeUser;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Chatroom))
        {
        	return false;
        }
        Chatroom other = (Chatroom) obj;
        if (id != other.id)
        {
        	return false;
        }
        if (ssn == null) 
        {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
        {
        	return false;
        }
        return true;
    }
 
    @Override
    public String toString() {
        return "Chatroom [id=" + id + ", chatroomname=" + chatroomname + ", maxUser="
                + maxUser + "]";
    }
}
