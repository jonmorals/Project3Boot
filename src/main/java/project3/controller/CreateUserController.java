package project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project3.dto.Person;
import project3.dto.Role;
import project3.service.ServiceInterface;

@RestController
public class CreateUserController {

	@Autowired 	
	ServiceInterface service; 
	
	/**
	 * URL mapping for creating a new user
	 * @param person - the new person to be created
	 * @return response entity pertaining to the string representation of the status of the create user
	 */
	@RequestMapping(value="/createUser", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody Person person) {
		String status = service.createUser(person);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	/**
	 * URL mapping to get all the roles that a user can be
	 * @return
	 */
	@RequestMapping(value="/getRoles", method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Role>> getTeam() {
		List<Role> roles = service.getRoles();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
}
