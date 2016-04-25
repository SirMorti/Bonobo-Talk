package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Kontakt;

public interface KontaktService {
	Kontakt findById(int id);
    void saveKontakt(Kontakt kontakt);  
    void deleteKontaktById(int id);
    List<Kontakt> getAllKontakte();
    Kontakt findKontaktByE_Mail(String e_Mail);
}
