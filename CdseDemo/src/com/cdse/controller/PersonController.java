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

import com.cdse.dto.PersonDto;
import com.cdse.service.CdseService;

@Controller
public class PersonController {
	
	@Autowired
	CdseService<PersonDto, PersonDto> personService;

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
	public ModelAndView submitPersonForm(@ModelAttribute("person") PersonDto personDto) {
	
		ModelAndView model1 = null;
		try {
			personService.insert(personDto);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/updatePerson.html", method = RequestMethod.POST)
	public ModelAndView updatePersonForm(@ModelAttribute("person") PersonDto personDto) {
	
		ModelAndView model1 = null;
		try {
			personDto.setPersonId("97");
			personService.update(personDto);
			model1 = new ModelAndView("UploadSuccess");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model1;
	}
	
	@RequestMapping(value="/getUsingId.html", method = RequestMethod.POST)
	public ModelAndView getPersonForm(@ModelAttribute("person") PersonDto personDto) throws IOException {
		ModelAndView model1 = null;
		PersonDto outDto = personService.get("getUsingId", personDto);
		model1 = new ModelAndView("DownloadSuccess");
		model1.addObject("outPerson", outDto);
		
		return model1;
	}
	
}

