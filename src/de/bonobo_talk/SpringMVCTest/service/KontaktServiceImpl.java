package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.KontaktDAOImpl;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;

@Service("KontaktService")
@Transactional
public class KontaktServiceImpl implements KontaktService {

	@Autowired
	private KontaktDAOImpl dao;
	
	@Override
	public Kontakt findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveKontakt(Kontakt kontakt) {
		// TODO Auto-generated method stub
		dao.saveKontakt(kontakt);
	}

	@Override
	public void deleteKontaktById(int id) {
		// TODO Auto-generated method stub
		dao.deleteKontaktById(id);
	}

	@Override
	public List<Kontakt> getAllKontakte() {
		// TODO Auto-generated method stub
		return dao.getAllKontakte();
	}

	@Override
	public Kontakt findKontaktByE_Mail(String e_mail) {
		// TODO Auto-generated method stub
		return dao.findKontaktByE_Mail(e_mail);
	}

}
