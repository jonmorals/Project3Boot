package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project3.dto.Complex;

public interface ComplexRepo extends JpaRepository<Complex, Integer> {
	
	public Complex findByComplexName(String complexName);
}
