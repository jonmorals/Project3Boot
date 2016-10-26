package project3.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project3.dto.DisLikeablePost;
import project3.dto.ForumCategory;
import project3.dto.DisLikeableReply;
import project3.dto.ForumPost;
import project3.dto.LikeablePost;
import project3.dto.LikeableReply;
import project3.dto.Person;
import project3.dto.PostReply;
import project3.objectcontainer.PostContainer;
import project3.service.BusinessLogic;

@RestController
public class PostsController {

	@Autowired
	BusinessLogic service;
	
	/**
	 * URL mapping for when a post is created
	 * @param Array of information about the posts such as the title, content, author, and category of the post
	 */
	@RequestMapping(value="/createPost", method=RequestMethod.POST)
	public ResponseEntity<Integer> createPost(@RequestBody String[] postInfo){
		String title = postInfo[0];
		String content = postInfo[1];
		String username = postInfo[2];
		String category = postInfo[3];
		List<ForumCategory> catList = new ArrayList<>();
		catList.add(service.getCategoryByName(category));
		Person author = service.getPersonByUsername(username);
		int postId = service.createForumPost(content, title, author, catList);
		return new ResponseEntity<Integer>(postId, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for to get all of the posts
	 */
	@RequestMapping(value="/getPosts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostContainer>> getPosts(){
		List<ForumPost> posts = service.getMorePosts(0);
		List<PostContainer> allPosts = new ArrayList<>();
		
		for(ForumPost post: posts){
			List<List<String>> postContent = new ArrayList<>();
			List<PostReply> replys = service.getRepliesByPost(post);
			for(PostReply reply: replys) {
				List<String> replies = new ArrayList<>();
				replies.add(reply.getContent());
				replies.add(reply.getAuthor().getUsername());
				replies.add(reply.getTimestamp().toString());
				postContent.add(replies);
			}
			PostContainer p = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), post.getContent(), post.getId(), post.getAuthor().getProfilePic(), postContent);
			allPosts.add(p);
		}
		return new ResponseEntity<List<PostContainer>>(allPosts, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for getting all the posts pertaining to a specific user
	 * @param takes in the username of the user
	 */
	@RequestMapping(value="/getPostsByUsername", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostContainer>> getPostsByUsername(@RequestBody String username){
		List<ForumPost> posts = service.getPostsByUsername(0, username);
		List<PostContainer> allPosts = new ArrayList<>();
		for(ForumPost post: posts){
			List<PostReply> replys = service.getRepliesByPost(post);
			List<List<String>> postContent = new ArrayList<>();
			for(PostReply reply: replys){
				List<String> replies = new ArrayList<>();
				replies.add(reply.getContent());
				replies.add(reply.getAuthor().getUsername());
				Date day = new Date(reply.getTimestamp().getTime());
				replies.add(day.toString());
				postContent.add(replies);
			}
			PostContainer p = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), 
					post.getContent(), post.getId(), post.getAuthor().getProfilePic(), postContent);
			allPosts.add(p);
		}
		return new ResponseEntity<List<PostContainer>>(allPosts, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for loading more posts onto the page
	 * Not implemented yet. Meant to be integrated for infinite scrolling
	 * @param Takes in an array containing where to start loading the posts
	 */
	@RequestMapping(value="/getMorePosts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostContainer>> getMorePosts(@RequestBody String[] getPostResult){
		int firstResult = Integer.parseInt(getPostResult[0]);
		List<ForumPost> posts = service.getMorePosts(firstResult);
		List<PostContainer> allPosts = new ArrayList<>();
		
		for(ForumPost post: posts){
			List<List<String>> postContent = new ArrayList<>();
			for(PostReply reply: post.getReplys()) {
				List<String> replies = new ArrayList<>();
				replies.add(reply.getContent());
				replies.add(reply.getAuthor().getUsername());
				replies.add(reply.getTimestamp().toString());
				postContent.add(replies);
			}
			PostContainer p = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), 
					post.getContent(), post.getId(), post.getAuthor().getProfilePic(),  postContent);
			allPosts.add(p);
		}
		return new ResponseEntity<List<PostContainer>>(allPosts, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for when a reply is created
	 * @param takes in an array containing the content of the reply, author of the reply 
	 * and id of the post that it belongs to
	 */
	@RequestMapping(value="/createReply", method=RequestMethod.POST)
	public void createReply(@RequestBody String[] postInfo){
		String replyContent = postInfo[0];
		String username = postInfo[2];
		int postId = Integer.parseInt(postInfo[1]);
		service.createReply(replyContent, postId, username);
	}

	/**
	 * URL mapping for getting a specific post by its id
	 * @param takes in the id of the post needed
	 */
	@RequestMapping(value="/getPostById", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostContainer> getPost(@RequestParam("id") int id){
		ForumPost post = service.getPostById(id);
		List<List<String>> content = new ArrayList<>();
		
		List<PostReply> replys = service.getRepliesByPost(post);
		for(PostReply reply: replys) {
			List<String> replies = new ArrayList<>();
			replies.add(reply.getContent());
			replies.add(reply.getAuthor().getUsername());
			Date day = new Date(reply.getTimestamp().getTime());
			replies.add(day.toString());
			replies.add(reply.getId() + "");
			replies.add(reply.getAuthor().getProfilePic());
			content.add(replies);
		}
		Date day = new Date(post.getTimestamp().getTime());
		PostContainer pos = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), 
				post.getContent(), post.getId(), post.getAuthor().getProfilePic(),  content, day.toString());
		return new ResponseEntity<PostContainer>(pos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dislike", method=RequestMethod.POST)
	@ResponseBody
	public String dislikePost(@RequestParam("username") String username, @RequestParam("id") int id) {
		ForumPost post = service.getPostForDislike(id);
		Person person = service.getPersonByUsername(username);
		ForumPost postLike = service.getPostForLike(id);
		service.addDislike(post, person);
		service.checkForLike(postLike, person);
		List<DisLikeablePost> dislikes = service.getAllDislikebyPost(post);
		
		return Integer.toString(dislikes.size());
	}
	
	@RequestMapping(value="/dislikeReply", method=RequestMethod.POST)
	@ResponseBody
	public String dislikeReply(@RequestParam("username") String username, @RequestParam("id") int id) {
		PostReply reply = service.getReplyForDislike(id);
		Person person = service.getPersonByUsername(username);
		PostReply replyLike = service.getReplyForLike(id);
		service.addDislikeReply(reply, person);
		service.checkReplyLike(replyLike, person);
		List<DisLikeableReply> dislikes = service.getAllDislikebyReply(reply);
		
		return Integer.toString(dislikes.size());
	}
	
	@RequestMapping(value="/likeReply", method=RequestMethod.POST)
	@ResponseBody
	public String likeReply(@RequestParam("username") String username, @RequestParam("id") int id) {
		PostReply reply = service.getReplyForLike(id);
		Person person = service.getPersonByUsername(username);
		PostReply disLikeReply = service.getReplyForDislike(id);
		service.addlikeReply(reply, person);
		service.checkReplyDislike(disLikeReply, person);
		List<LikeableReply> likes = service.getAllLikebyReply(reply);
		
		return Integer.toString(likes.size());
	}
	
	@RequestMapping(value="/like", method=RequestMethod.POST)
	@ResponseBody
	public String likePost(@RequestParam("username") String username, @RequestParam("id") int id) {
		ForumPost post = service.getPostForLike(id);
		Person person = service.getPersonByUsername(username);
		service.addLike(post, person);
		ForumPost postDislikes = service.getPostForDislike(id);
		service.checkForDislike(postDislikes, person);
		List<LikeablePost> likes = service.getAllLikesbyPost(post);
		
		return Integer.toString(likes.size());
	}
	
	@RequestMapping(value="/getDislike", method=RequestMethod.POST)
	@ResponseBody
	public String getAllDislikes(@RequestParam("id") int id) {
		ForumPost post = service.getPostForDislike(id);
		List<DisLikeablePost> dislikes = service.getAllDislikebyPost(post);
		return Integer.toString(dislikes.size());
	}
	
	@RequestMapping(value="/getDislikes", method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> getAllDislikesReply(@RequestParam("id") int id) {
		ForumPost post = service.getPostForDislike(id);
		List<PostReply> replys = service.getRepliesByPost(post);
		List<Integer> dislikes = new ArrayList<>();
		
		for(PostReply item: replys) {
			PostReply reply = service.getReplyForDislike(item.getId());
			List<DisLikeableReply> dislikeReplyList = service.getAllDislikebyReply(reply);
			dislikes.add(dislikeReplyList.size());
		}
		
		return dislikes;
	}
	
	@RequestMapping(value="/getLikes", method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> getAllLikesReply(@RequestParam("id") int id) {
		ForumPost post = service.getPostForLike(id);
		List<PostReply> replys = service.getRepliesByPost(post);
		List<Integer> likes = new ArrayList<>();
		
		for(PostReply item: replys) {
			PostReply reply = service.getReplyForLike(item.getId());
			List<LikeableReply> likeReplyList = service.getAllLikebyReply(reply);
			likes.add(likeReplyList.size());
		}
		
		return likes;
	}
	
	
	@RequestMapping(value="/getLike", method=RequestMethod.POST)
	@ResponseBody
	public String getAllLikes(@RequestParam("id") int id) {
		ForumPost post = service.getPostForLike(id);
		List<LikeablePost> likes = service.getAllLikesbyPost(post);
		return Integer.toString(likes.size());
	}
	
	/**
	 * URL mapping for deleting a post
	 * @param takes in the id of the post that is to be deleted
	 */
	@RequestMapping(value="/deletePost")
	public void deletePost(@RequestBody String postIdStr){
		int postId = Integer.parseInt(postIdStr);
		service.deletePost(postId);
	}
	
	/**
	 * URL mapping to get all posts by a particular category
	 * @param takes in the name of the category
	 */
	@RequestMapping(value="/getPostsCat")
	public ResponseEntity<List<PostContainer>> getPostsByCategory(@RequestBody String catName){
		List<ForumPost> posts = service.getPostsByCategory(catName);
		List<PostContainer> allPosts = new ArrayList<>();
		
		for(ForumPost post: posts){
			List<List<String>> postContent = new ArrayList<>();
			for(PostReply reply: service.getRepliesByPost(post)) {
				List<String> replies = new ArrayList<>();
				replies.add(reply.getContent());
				replies.add(reply.getAuthor().getUsername());
				replies.add(reply.getTimestamp().toString());
				postContent.add(replies);
			}
			
			PostContainer p = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), 
					post.getContent(), post.getId(),post.getAuthor().getProfilePic() , postContent);
			allPosts.add(p);
		}
		return new ResponseEntity<List<PostContainer>>(allPosts, HttpStatus.OK);
	}
	
	/**
	 * URL mapping to get posts of by a category and user 
	 * @param Takes in an array containing the category name an username of the user
	 */
	@RequestMapping(value="/getPostsCatProf")
	public ResponseEntity<List<PostContainer>> getPostsByCategoryInProf(@RequestBody String[] info){
		String catName = info[0];
		String username = info[1];
		List<ForumPost> posts = service.getPostsByCategoryProf(catName, username);
		List<PostContainer> allPosts = new ArrayList<>();
		
		for(ForumPost post: posts){
			List<List<String>> postContent = new ArrayList<>();
			for(PostReply reply: service.getRepliesByPost(post)) {
				List<String> replies = new ArrayList<>();
				replies.add(reply.getContent());
				replies.add(reply.getAuthor().getUsername());
				replies.add(reply.getTimestamp().toString());
				postContent.add(replies);
			}
			PostContainer p = new PostContainer(post.getAuthor().getUsername(), post.getTitle(), 
					post.getContent(), post.getId(),post.getAuthor().getProfilePic() , postContent);
			allPosts.add(p);
		}
		return new ResponseEntity<List<PostContainer>>(allPosts, HttpStatus.OK);
	}
	
	/**
	 * URL mapping for getting all the categories
	 */
	@RequestMapping(value="/getAllCat")
	public ResponseEntity<List<String>> getAllCategories(){
		List<ForumCategory> categories = service.getAllCategories();
		List<String> catNames = new ArrayList<>();
		for(ForumCategory cat: categories){
			catNames.add(cat.getCategoryName());
		}
		return new ResponseEntity<List<String>>(catNames, HttpStatus.OK);
	}
}
