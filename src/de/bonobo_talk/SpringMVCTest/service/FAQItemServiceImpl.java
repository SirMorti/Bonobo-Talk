package de.bonobo_talk.SpringMVCTest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.FAQItemDAO;
import de.bonobo_talk.SpringMVCTest.model.FAQItem;

@Service("FAQItemService")
@Transactional
public class FAQItemServiceImpl implements FAQItemService {

	@Autowired
	private FAQItemDAO dao;
	
	@Override
	public FAQItem findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		dao.saveFAQItem(faqItem);
	}

	@Override
	public void deleteFAQItemById(int id) {
		// TODO Auto-generated method stub
		dao.deleteFAQItemById(id);
	}

	@Override
	public List<FAQItem> getAllFAQItems() {
		// TODO Auto-generated method stub
		return dao.getAllFAQItems();
	}

	@Override
	public List<FAQItem> findFAQItemByBetreff(String betreff) {
		// TODO Auto-generated method stub
		return dao.findFAQItemByBetreff("%" + betreff + "%");
	}

	@Override
	public void saveOrUpdateFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		dao.updateFAQItem(faqItem);
	}

	@Override
	public void addAntwort(FAQItem frage, FAQItem antwort) 
	{
		// TODO Auto-generated method stub
		FAQItem tmpItem = dao.findById(frage.getId());
		if(tmpItem != null)
		{
			Set<FAQItem>tmpList = tmpItem.getAntworten();
			tmpList.add(antwort);
			tmpItem.setAntworten(tmpList);
		}
	}

}
