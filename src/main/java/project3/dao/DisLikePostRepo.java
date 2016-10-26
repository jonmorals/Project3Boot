package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project3.dto.DisLikeablePost;

public interface DisLikePostRepo extends JpaRepository<DisLikeablePost, Integer> {
	
}
