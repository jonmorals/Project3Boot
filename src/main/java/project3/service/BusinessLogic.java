package project3.service;

import java.util.List;

import project3.dto.DisLikeablePost;
import project3.dto.DisLikeableReply;
import project3.dto.ForumCategory;
import project3.dto.ForumPost;
import project3.dto.LikeablePost;
import project3.dto.LikeableReply;
import project3.dto.Person;
import project3.dto.PostReply;

public interface BusinessLogic {
	
	public boolean checkUserPassword(String username, String password, String curpassword);
	
	public Person getPersonById(int id);
	
	public Person getPersonByUsername(String username);
	
	public String updateTempPerson(String username, String pass, String oldPass, String newUsername);
	
	public String updateUserInfo(Person person, String oldPassword, String newPassword, String username, String newEmail, 
			String newPhone, String complex, String newUniversity, String newLinkedIn);
	
	public int createForumPost(String content, String title, Person author, List<ForumCategory> categories);
	
	public List<ForumPost> getAllPosts();
	
	public void createReply(String replyContent, int postId, String username);
	
	public ForumPost getPostById(int id);
	
	public List<ForumPost> getMorePosts(int firstResult);
	
	public void addDislike(ForumPost post, Person person);
	
	public List<DisLikeablePost> getAllDislikebyPost(ForumPost post);

	public void addLike(ForumPost post, Person person);
	
	public void checkForLike(ForumPost post, Person person);

	public ForumPost getPostForDislike(int id);

	public ForumPost getPostForLike(int id);

	public List<LikeablePost> getAllLikesbyPost(ForumPost post);
	
	public List<ForumPost> getPostsByUsername(int firstResult, String username);
	
	public void deletePost(int postId);

	void checkForDislike(ForumPost post, Person person);
	
	public List<PostReply> getRepliesByPost(ForumPost post);
	
	public void createForumCategory(String categoryName);
	
	public List<ForumPost> getPostsByCategory(String catName);
	
	public List<ForumPost> getPostsByCategoryProf(String catName, String username);
	
	public List<ForumCategory> getAllCategories();
	
	public ForumCategory getCategoryByName(String catName);

	public PostReply getReplyForDislike(int id);
	
	public PostReply getReplyForLike(int id);

	public void addDislikeReply(PostReply reply, Person person);

	public void checkReplyLike(PostReply replyLike, Person person);

	public List<DisLikeableReply> getAllDislikebyReply(PostReply reply);

	List<LikeableReply> getAllLikebyReply(PostReply reply);

	public void addlikeReply(PostReply reply, Person person);

	public void checkReplyDislike(PostReply disLikeReply, Person person);
}
