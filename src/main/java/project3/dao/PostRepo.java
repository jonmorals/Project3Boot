package project3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project3.dto.ForumPost;

public interface PostRepo extends JpaRepository<ForumPost, Integer> {

}
