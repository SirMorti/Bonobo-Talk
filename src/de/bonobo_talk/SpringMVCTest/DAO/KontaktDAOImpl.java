package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;

@Repository("KontaktDAO")
public class KontaktDAOImpl extends AbstractDao<Integer, Kontakt> implements KontaktDAO {

	@Override
	public Kontakt findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveKontakt(Kontakt kontakt) {
		// TODO Auto-generated method stub
		persist(kontakt);
	}

	@Override
	public void deleteKontaktById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from KONTAKTE where id = :id");
        query.setString("id", Integer.toString(id));
        query.executeUpdate();
	}

	@Override
	public List<Kontakt> getAllKontakte() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        return (List<Kontakt>) criteria.list();
	}

	@Override
	public Kontakt findKontaktByE_Mail(String e_mail) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("E_MAIL", e_mail));
		return (Kontakt) criteria.uniqueResult();
	}



}
