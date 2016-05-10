package de.bonobo_talk.SpringMVCTest.model;

/*
 * Klasse zur Defnition der einzelnen Rollen eines Accounts
 */
public enum AccountType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
     
    String accountType;
     
    private AccountType(String accountType){
        this.accountType = accountType;
    }
     
    public String getAccountTypes(){
        return accountType;
    }

}
