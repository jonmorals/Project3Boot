package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project3.dto.Person;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<Person, Integer>{
	
	public Person findByUsernameAndPassword(String username, String password);
	
	public Person findByEmail(String email);
	
	public Person findByUsername(String username);
}
