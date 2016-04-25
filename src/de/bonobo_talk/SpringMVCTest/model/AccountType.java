package de.bonobo_talk.SpringMVCTest.model;

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
