package com.cdse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.cdse.domain.Contacts;
import com.cdse.service.CdseService;

@Controller
public class ContactController {
	
	@Autowired
	CdseService<Contacts> cdseService;

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "SharpE CDSE Demo");
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
		ServletRequestDataBinder binder) throws ServletException {
			binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(value="/createContact.html", method = RequestMethod.POST)
	public ModelAndView submitContactForm(@ModelAttribute("contact") Contacts contact) {
	
		ModelAndView model1 = null;
		try {
			cdseService.insert(contact);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/updateContact.html", method = RequestMethod.POST)
	public ModelAndView updateContactForm(@ModelAttribute("contact") Contacts contact) {
	
		ModelAndView model1 = null;
		try {
			Contacts updatedContact = cdseService.update("matchLastName", contact);
			contact.copy(updatedContact);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/getContact.html", method = RequestMethod.POST)
	public ModelAndView getContactForm(@ModelAttribute("contact") Contacts contact) {
	
		ModelAndView model1 = null;
		Contacts retrievedContact = cdseService.get("matchLastName", contact);
		contact.copy(retrievedContact);
		model1 = new ModelAndView("DownloadSuccess");
		
		return model1;
	}
	
}

