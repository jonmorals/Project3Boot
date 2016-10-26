package project3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import project3.dto.Person;
import project3.service.ServiceInterface;

@Controller
@SessionAttributes("person")
public class PicController {
	
	@Autowired
	ServiceInterface service;

	//Upload Item remotely
	@RequestMapping(value="/upload-remote", method=RequestMethod.POST,
			consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
	public void uploadRemote(@RequestParam("file") MultipartFile file,
			HttpServletRequest req, 
			HttpServletResponse resp,
			@ModelAttribute("person") Person person,
			ModelMap map) throws ServletException, IOException {
		map.addAttribute("person", service.updateProfilePic(person, file));
	}
}
