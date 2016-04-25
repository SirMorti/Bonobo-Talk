package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;

public interface FAQItemDAO {
	FAQItem findById(int id);
	void saveFAQItem(FAQItem faqItem);
	void updateFAQItem(FAQItem faqItem);
	void deleteFAQItemById(int id);
	List<FAQItem> getAllFAQItems();
	List<FAQItem> findFAQItemByBetreff(String betreff);
}
