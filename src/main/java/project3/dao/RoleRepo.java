package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project3.dto.Role;

@RepositoryRestResource
public interface RoleRepo extends JpaRepository<Role, Integer>{
	
}
