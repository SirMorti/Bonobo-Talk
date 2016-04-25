package de.bonobo_talk.SpringMVCTest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Templates/")
public class TemplateController 
{
    @RequestMapping(value = { "/footer" })
    public String addFooter() {
 
        return "../static/Templates/footer";
    }
    
    @RequestMapping(value = { "/navigation" })
    public String addNavigation() {
 
        return "../static/Templates/navigation";
    }
    
    @RequestMapping(value = { "/settings" })
    public String addSettings() {
 
        return "../static/Templates/settings";
    }
}
