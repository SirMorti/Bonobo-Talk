package de.bonobo_talk.SpringMVCTest.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.bonobo_talk.SpringMVCTest.container.ContactFaqContainer;
import de.bonobo_talk.SpringMVCTest.container.SearchContainer;
import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;
import de.bonobo_talk.SpringMVCTest.service.FAQItemService;
import de.bonobo_talk.SpringMVCTest.service.KontaktService;

@Controller
@RequestMapping("/")
public class FAQController {
	
	@Autowired
	private FAQItemService faqService;
	
	@Autowired
	private KontaktService kontaktService;
	
	@RequestMapping(value = { "/testFAQ" }, method = RequestMethod.GET)
    public String testFAQ(ModelMap model) {
 
		FAQItem item1 = new FAQItem();
		item1.setBetreff("Test FAQ");
		item1.setInhalt("Dies ist eine Testfrage");
		
		FAQItem item2 = new FAQItem();
		item2.setBetreff("Luzifer");
		item2.setInhalt("Testantwort Yea Yea");
		item2.setFrage(item1);
		
		FAQItem item3 = new FAQItem();
		item3.setBetreff("Beelzebub");
		item3.setInhalt("LOLOLOLO wir sind so toll");
		item3.setFrage(item1);
		
		Kontakt kontakt1 = new Kontakt();
		kontakt1.setE_mail("somemail@mail.de");
		kontakt1.setName("Max");
		kontakt1.setVorname("Mustermann");
		
		Kontakt kontakt2 = new Kontakt();
		kontakt2.setE_mail("othermaill@mail.de");
		kontakt2.setName("Karl");
		kontakt2.setVorname("Muster");
		
		Kontakt kontakt3 = new Kontakt();
		kontakt3.setE_mail("trial@extrem.de");
		kontakt3.setName("Lisa");
		kontakt3.setVorname("Kaluch");
		
		
		//kontaktService.saveKontakt(kontakt1);
		//kontaktService.saveKontakt(kontakt2);
		//kontaktService.saveKontakt(kontakt3);
		
		item1.setKontakt(kontakt1);
		item2.setKontakt(kontakt2);
		item3.setKontakt(kontakt3);
		
		faqService.saveOrUpdateFAQItem(item1);
		faqService.saveOrUpdateFAQItem(item2);		
		faqService.saveOrUpdateFAQItem(item3);
		
		faqService.addAntwort(item1, item2);
		faqService.addAntwort(item1, item3);
		
		//faqService.deleteFAQItemById(item3.getId());
		//kontaktService.deleteKontaktById(kontakt1.getId());
		
		List<FAQItem> test = (List<FAQItem>) faqService.findFAQItemByBetreff("Luzifer");
		for (FAQItem faqItem : test) 
		{
			faqItem.debug();
		}
		
		return "redirect:faq";
    }
	
    @RequestMapping(value = { "/contact" },method = RequestMethod.GET)
    public String addContact(ModelMap model) {
    	Kontakt contact = new Kontakt();
    	FAQItem faqItem = new FAQItem();
    	
    	model.addAttribute("contact", contact);
    	model.addAttribute("faqItem", faqItem);
    	
        return "contact";
    }
	
    @RequestMapping(value = { "/contact" },method = RequestMethod.POST)
    public String newContactFAQ( ContactFaqContainer container,
            ModelMap model)
    {
    	FAQItem tmpItem = container.getFAQItem();
    	tmpItem.setKontakt(container.getContact());
    	faqService.saveOrUpdateFAQItem(tmpItem);
    	
    	/*
    	String mail;
    	String eol = System.getProperty("line.separator");
    	mail = "Hallo " + tmpItem.getKontakt().getName() + "," + eol + eol +
    			"Ihr Ticket mit dem Inhalt:" + eol +
    			tmpItem.getInhalt() + eol + eol + 
    			"ist bei uns eingegangen und wird schnellstmöglich von uns Bearbeitet." + eol + eol +
    			"Mit freundlichen Grüßen" + eol + "Ihr Bonobo Team";
    	
    	SimpleMailMessage confirmMail = new SimpleMailMessage();
    	confirmMail.setFrom("ms.stelter@web.de");
    	confirmMail.setTo(tmpItem.getKontakt().getE_mail());
    	confirmMail.setSubject(tmpItem.getBetreff());
    	confirmMail.setText(mail);
    	*/
    	
        return "redirect:/faq";
    }
/*    
    @RequestMapping(value = {"/faq"}, method = RequestMethod.GET)
    public String showFAQ(ModelMap model)
    {
    	return "faq";
    }
*/    
    @RequestMapping(value = {"/showTicket"}, method = RequestMethod.GET)
    public String showTicket(ModelMap model)
    {
    	return "showTicket";
    }
    
    @RequestMapping(value = { "/showTicket" },method = RequestMethod.POST)
    public String searchFAQ( SearchContainer container,
            ModelMap model)
    {
    	model.clear();
    	List<FAQItem> tmpItems = (List<FAQItem>) faqService.findFAQItemByBetreff(container.getBetreff());
    	model.addAttribute("faqItems", tmpItems);
        return "faq";
    }
	
}
