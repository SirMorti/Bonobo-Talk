package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;

@Repository("FAQItemDAO")
public class FAQItemDAOImpl extends AbstractDao<Integer, FAQItem> implements FAQItemDAO{

	@Override
	public FAQItem findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		persist(faqItem);
	}

	@Override
	public void deleteFAQItemById(int id) {
		// TODO Auto-generated method stub
		/*
		 * query to search for an entry with a specific id
		 */
		Query query = getSession().createSQLQuery("delete from FAQITEM where FAQITEM_ID = :id");
        query.setString("id", Integer.toString(id));
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FAQItem> getAllFAQItems() {
		// TODO Auto-generated method stub
		/*
		 * creates a criteria to get all entities of the type faqItem
		 */
		Criteria criteria = createEntityCriteria();
        return (List<FAQItem>) criteria.list();
	}

	@Override
	public List<FAQItem> findFAQItemByBetreff(String betreff) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		/*
		 * restricts the criteria to only return those criterias that have a betreff values which contains the value of betreff
		 */
        criteria.add(Restrictions.like("betreff", betreff));
		return (List<FAQItem>) criteria.list();
	}

	@Override
	public void updateFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		saveOrUpdate(faqItem);
	}

}
