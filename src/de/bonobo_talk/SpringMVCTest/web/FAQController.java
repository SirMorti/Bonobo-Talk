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
