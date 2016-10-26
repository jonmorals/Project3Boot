package project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import project3.dto.Person;
import project3.service.BusinessLogic;
import project3.service.ServiceInterface;

@RestController
@SessionAttributes("person")
public class UpdateUserController {
	  
	@Autowired
	BusinessLogic logic;
	
	@Autowired
	ServiceInterface service;
	
	/**
	 * URL mapping for updating a user that has just been made
	 * @param usernamePass - array containing the currently logged in user's username, 
	 * the temporary password, new password and new username
	 * @param map
	 * @return response entity of the string representation of the status of the update
	 */
	@RequestMapping(value="/updateTemp", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateTempUser(@RequestBody String[] usernamePass, ModelMap map){
		String CurrentUsername = usernamePass[3];
		String  temporaryPassword = usernamePass[1];
		String newPassword = usernamePass[0];
		String newUsername = usernamePass[2];
		
		String updatedStatus = logic.updateTempPerson(CurrentUsername, temporaryPassword, newPassword, newUsername);
		if(updatedStatus.equals("Updated")){
			Person updatedPerson = logic.getPersonByUsername(usernamePass[2]);
			map.addAttribute("person", updatedPerson);
		}
		return new ResponseEntity<String>(updatedStatus, HttpStatus.OK);
	}
	
	/**
	 * @param information - array containing the old password, new password, 
	 * new username, new email, new phone number, new univeristy, new linkedIn link, and new complex
	 * @param person - the currently logged in user
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/updateInfo", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateUserInfo(@RequestBody String[] information, 
			@ModelAttribute("person") Person person, ModelMap map){
		String oldPassword = information[0];
		String newPassword = information[1];
		String newUsername = information[2];
		String newEmail = information[3];
		String newPhone = information[4];
		String newUniversity = information[5];
		String newLinkedIn = information[6]; 
		String complex = information[7];
		
		String updatedStatus = logic.updateUserInfo(person, oldPassword, newPassword, newUsername, newEmail, 
				newPhone, complex, newUniversity, newLinkedIn);
		
		if(updatedStatus.equals("Updated")){
			Person updatedPerson = logic.getPersonById(person.getId());
			map.addAttribute("person", updatedPerson);
		}
		return new ResponseEntity<String>(updatedStatus, HttpStatus.OK);
	}
}
