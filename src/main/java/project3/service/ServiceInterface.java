package project3.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project3.dto.Complex;
import project3.dto.Person;
import project3.dto.Role;

/**
 * A Service method for person information
 */
public interface ServiceInterface {
	
	/**
	 * Get all the roles
	 * @return A list of roles
	 */
	public List<Role> getRoles();
	
	/**
	 * Update profile picture
	 * @param person The person that the picture is associate with
	 * @param picture The picture to be uploaded to S3
	 * @return A person with new profile picture link
	 */
	public Person updateProfilePic(Person person, MultipartFile picture);
	
	/**
	 * Get A person by user name
	 * @param username The user name to found the person 
	 * @return The person
	 */
	public Person getPersonByUsername(String username);
	
	/**
	 * Get a list of complex
	 * @return A list of complex
	 */
	public List<Complex> getComplex();
	
	/**
	 * Login the user by checking if the user have input the right information
	 * @param username The user name user had input
	 * @param password The password user had input
	 * @return A person if login true else null if false
	 */
	public Person loginUser(String username, String password);
	
	/**
	 * Creating a new person
	 * @param person A person to be created
	 * @return A message on whether the person had created
	 */
	public String createUser(Person person);

}
