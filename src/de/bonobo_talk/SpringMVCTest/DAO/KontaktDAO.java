package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Kontakt;


public interface KontaktDAO 
{
	/*
	 * returns Kontakt by id if no Kontakt could be found returns null
	 */
	Kontakt findById(int id);
	/*
	 * saves a Kontakt
	 */
    void saveKontakt(Kontakt kontakt); 
    /*
     * deletes a Kontakt
     */
    void deleteKontaktById(int id);
    /*
     * returns a lkst of all Kontakts
     */
    List<Kontakt> getAllKontakte();
    /*
     * returns Kontakt by e_mail if no Kontakt could be found returns null
     */
    Kontakt findKontaktByE_Mail(String e_mail);
}
