package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;

public interface FAQItemDAO {
	/*
	 * returns FAQItem by id or null if no FAQItem could be found
	 */
	FAQItem findById(int id);
	/*
	 * saves the FAQItem
	 */
	void saveFAQItem(FAQItem faqItem);
	/*
	 * update the FAQItem
	 */
	void updateFAQItem(FAQItem faqItem);
	/*
	 * delete the FAQItem by id
	 */
	void deleteFAQItemById(int id);
	/*
	 * returns a list of all FAQItems
	 */
	List<FAQItem> getAllFAQItems();
	/*
	 * returns all FAQItems with a with a betreff thats like the parameter
	 */
	List<FAQItem> findFAQItemByBetreff(String betreff);
}
