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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.cdse.domain.Person;
import com.cdse.domain.Role;
import com.cdse.service.CdseService;

@Controller
public class PersonController {
	
	@Autowired
	CdseService<Person> cdseService;

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
	
	@RequestMapping(value="/createPerson.html", method = RequestMethod.POST)
	public ModelAndView submitPersonForm(@ModelAttribute("person") Person person, @RequestParam("roleName") String roleName) {
	
		ModelAndView model1 = null;
		try {
			Role role = new Role();
			role.setRoleName(roleName);
			person.setRole(role);
			
			cdseService.insert(person);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/updatePerson.html", method = RequestMethod.POST)
	public ModelAndView updatePersonForm(@ModelAttribute("person") Person person) {
	
		ModelAndView model1 = null;
		try {
			Person updatedPerson = cdseService.update("matchLastName", person);
			person.copy(updatedPerson);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/getPerson.html", method = RequestMethod.POST)
	public ModelAndView getPersonForm(@ModelAttribute("person") Person person) {
	
		ModelAndView model1 = null;
		Person retrievedPerson = cdseService.get("matchLastName", person);
		person.copy(retrievedPerson);
		model1 = new ModelAndView("DownloadSuccess");
		
		return model1;
	}
	
}

