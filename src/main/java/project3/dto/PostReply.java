package project3.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The reply to the post
 */
@Entity
@Table(name="PostReply")
public class PostReply {

	/**
	 * The id of the PostReply
	 */
	@Id
	@Column(name="pr_id")
	@SequenceGenerator(name="postReplySeq", sequenceName="postReply_Seq", 
		allocationSize=1)
	@GeneratedValue(generator="postReplySeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author of the reply
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_id")
	private Person author;

	/**
	 * The post that the reply associate with
	 */
	@ManyToOne
	@JoinColumn(name="fp_id")
	private ForumPost post;
	
	/**
	 * A list of likes for the reply
	 */
	@OneToMany(mappedBy="reply", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<LikeableReply> likes;
	
	/**
	 * A list of dislikes for the reply
	 */
	@OneToMany(mappedBy="reply", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<DisLikeableReply> dislikes;
	
	/**
	 * Whether the reply had been approve by a moderator
	 */
	@Column(name="pr_approval")
	private boolean approval;
	
	/**
	 * The content of the reply
	 */
	@Column(name="pr_content")
	private String content;
	
	/**
	 * The time that the reply was made
	 */
	@Column(name="pr_timestamp")
	private Timestamp timestamp;
	
	/**
	 * An empty constructor for initialize the PostReply object.
	 */
	public PostReply() {
		// Do nothing because of Hibernate to create the object
	}
	
	/**
	 * A constructor for initialize the PostReply object.
	 * @param post The post that the reply associate with
	 * @param author The author of the reply
	 * @param likes A list of likes for the reply
	 * @param dislikes A list of dislikes for the reply
	 * @param approval Whether the reply had been approve by a moderator
	 * @param content The content of the reply
	 * @param timestamp The time that the reply was made
	 */
	public PostReply(ForumPost post, Person author, List<LikeableReply> likes, 
			List<DisLikeableReply> dislikes, boolean approval, String content,
			Timestamp timestamp) {
		super();
		this.author = author;
		this.post = post;
		this.likes = likes;
		this.dislikes = dislikes;
		this.approval = approval;
		this.content = content;
		this.timestamp = timestamp;
	}

	/**
	 * A constructor for initialize the PostReply object.
	 * @param id The id of the PostReply
	 * @param author The author of the reply
	 * @param post The post that the reply associate with
	 * @param likes A list of likes for the reply
	 * @param dislikes A list of dislikes for the reply
	 * @param approval Whether the reply had been approve by a moderator
	 * @param content The content of the reply
	 * @param timestamp The time that the reply was made
	 */
	public PostReply(int id, Person author, ForumPost post, List<LikeableReply> likes, 
			List<DisLikeableReply> dislikes, boolean approval, String content, 
			Timestamp timestamp) {
		super();
		this.id = id;
		this.author = author;
		this.post = post;
		this.likes = likes;
		this.dislikes = dislikes;
		this.approval = approval;
		this.content = content;
		this.timestamp = timestamp;
	}

	/**
	 * Getting the id of the PostReply
	 * @return The id of the PostReply
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the PostReply
	 * @param id The id of the PostReply
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the PostReply
	 * @return The author of the PostReply
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set another author for the PostReply
	 * @param author Another author for the PostReply
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the post of the PostReply
	 * @return The post of the PostReply
	 */
	public ForumPost getPost() {
		return post;
	}

	/**
	 * Associate a new Post for the PostReply
	 * @param post A Post for the PostReply
	 */
	public void setPost(ForumPost post) {
		this.post = post;
	}
	
	/**
	 * Getting the list of likes of the PostReply
	 * @return The list of likes of the PostReply
	 */
	public List<LikeableReply> getLikes() {
		return likes;
	}

	/**
	 * Getting the list of dislikes of the PostReply
	 * @return The list of dislikes of the PostReply
	 */
	public List<DisLikeableReply> getDislikes() {
		return dislikes;
	}

	/**
	 * Set a new list of likes for the PostReply
	 * @param likes A list of likes for the PostReply
	 */
	public void setLikes(List<LikeableReply> likes) {
		this.likes = likes;
	}

	/**
	 * Set a new list dislikes for the PostReply
	 * @param dislikes A list of dislikes for the PostReply
	 */
	public void setDislikes(List<DisLikeableReply> dislikes) {
		this.dislikes = dislikes;
	}

	/**
	 * Check to see if the reply had been approve
	 * @return If the reply had been approve
	 */
	public boolean isApproval() {
		return approval;
	}

	/**
	 * Set approval of the reply
	 * @param approval Approval of the reply
	 */
	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	/**
	 * Getting the content of the PostReply
	 * @return The content of the PostReply
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set a new content for the PostReply
	 * @param content The content for the PostReply
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getting the time of the PostReply
	 * @return The time of the PostReply
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Set a new time for the PostReply
	 * @param timestamp The time of the PostReply
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "PostReply [id=" + id + ", author=" + author + ", post=" + post 
				+ ", likes=" + likes + ", dislikes=" + dislikes + ", approval=" 
				+ approval + ", content=" + content + ", timestamp=" + timestamp + "]";
	}
}
