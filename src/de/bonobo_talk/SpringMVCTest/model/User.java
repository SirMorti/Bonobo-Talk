package de.bonobo_talk.SpringMVCTest.model;

import java.math.BigDecimal;
 
import java.util.HashSet;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 








import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="USER")
public class User {
 
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min=3, max=50)
    @Column(name = "USERNAME", nullable = false)
    private String username;
 
    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @Size(min=3, max=50)
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Size(min=3, max=50)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;
    
    @Size(min=3, max=50)
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;
    
    @Size(min=3, max=50)
    @Column(name = "DATEOFBIRTH", nullable = false)
    private String dateOfBirth;
    
    
    @Column(name = "GENDER", nullable = false)
    private String gender;

    @NotNull
    @Size(min=3, max=50)
    @Column(name = "USERPICTURE", nullable = false)
    private String userpicture;
    
    @NotEmpty
    @Column(name = "STATE", nullable = false)
    private String state=State.ACTIVE.getState();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ACCOUNT_ACCOUNTROLE", 
             joinColumns = { @JoinColumn(name = "Account_Id") }, 
             inverseJoinColumns = { @JoinColumn(name = "AccountRole_Id") })
    private Set<AccountRole> accountRoles = new HashSet<AccountRole>();    
    
    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
   	@JoinTable(name = "JOINEDCHATROOMS", joinColumns = { 
   			@JoinColumn(name = "USER_ID", nullable = false, updatable = true) }, 
   			inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID", nullable = false, updatable = true) }
   	)
    private Set<Chatroom> joinedChatrooms;
       
    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinTable(name = "FAVOURITECHATROOMS", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID", nullable = false, updatable = true) }
	)
    private Set<Chatroom> favouriteChatrooms;
    
    public User()
    {
    	
    }
     
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

 
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserpicture() {
		return userpicture;
	}

	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}

 
    public Set<Chatroom> getJoinedChatrooms() {
		return joinedChatrooms;
	}


	public void setJoinedChatrooms(Set<Chatroom> joinedChatrooms) {
		this.joinedChatrooms = joinedChatrooms;
	}


	public Set<Chatroom> getFavouriteChatrooms() {
		return favouriteChatrooms;
	}


	public void setFavouriteChatrooms(Set<Chatroom> favouriteChatrooms) {
		this.favouriteChatrooms = favouriteChatrooms;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Set<AccountRole> getAccountRoles() {
		return accountRoles;
	}


	public void setAccountRoles(Set<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

     
}

