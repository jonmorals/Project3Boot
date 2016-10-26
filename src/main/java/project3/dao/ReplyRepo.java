package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project3.dto.PostReply;

public interface ReplyRepo extends JpaRepository<PostReply, Integer> {
	
	

}
