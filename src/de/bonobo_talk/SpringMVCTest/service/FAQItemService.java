package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.FAQItem;

public interface FAQItemService {
	FAQItem findById(int id);
	void saveFAQItem(FAQItem faqItem);  
	void saveOrUpdateFAQItem(FAQItem faqItem);
	void deleteFAQItemById(int id);
	List<FAQItem> getAllFAQItems();
	List<FAQItem> findFAQItemByBetreff(String betreff);
	void addAntwort(FAQItem frage, FAQItem antwort);
}
