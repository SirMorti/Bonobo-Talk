package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Kontakt;


public interface KontaktDAO 
{
	Kontakt findById(int id);
    void saveKontakt(Kontakt kontakt);  
    void deleteKontaktById(int id);
    List<Kontakt> getAllKontakte();
    Kontakt findKontaktByE_Mail(String e_mail);
}
