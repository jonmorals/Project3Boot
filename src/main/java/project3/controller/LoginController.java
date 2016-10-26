package project3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import project3.dto.Person;
import project3.service.ServiceInterface;

@RestController
@SessionAttributes("person")
public class LoginController {
	
	@Autowired 	
	ServiceInterface service; 
	
	/**
	 * URL mapping for logging in
	 * @param person - the user that is logging in
	 * @param map
	 * @return returns the user that is logging in
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person  checkLogin(@RequestBody Person person, ModelMap map) {
		Person persons = service.loginUser(person.getUsername(), person.getPassword());
		if(persons == null) {
			persons = new Person();
		}
		map.addAttribute("person", persons);
		return persons;
	}
	
	/**
	 * URL to the user of the logged in user
	 * @param person - takes in the user that is aqcuired from the session
	 * @param map
	 * @return response entity of the logged in user
	 */
	@RequestMapping(value = "/user",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getUser(@ModelAttribute("person") Person person, ModelMap map){
		if(person == null) {
			person = new Person();
		} else {
			person = service.getPersonByUsername(person.getUsername());
			if(person != null) {
				map.addAttribute("person", person);
			} else {
				person = new Person();
			}
		}
		
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for logging out
	 * @param request
	 * @param session
	 * @param status
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/logout")
	@ResponseBody
	public Person logout(WebRequest request, HttpSession session, SessionStatus status, ModelMap map){
		status.setComplete();
		Person person = new Person();
		map.addAttribute("user", person);
        session.removeAttribute("user");

		map.addAttribute("person", person);
		return person;
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public ResponseEntity<Person> handleException() {

		Person person = new Person();
		return new ResponseEntity<Person>(person, HttpStatus.OK);

	}

}
