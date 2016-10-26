package project3.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The post of the RevPages
 */
@Entity
@Table(name="ForumPost")
public class ForumPost {

	/**
	 * The primary ID of the ForumPost
	 */
	@Id
	@Column(name="fp_id")
	@SequenceGenerator(name="ForumPostSeq", sequenceName="ForumPost_Seq", 
		allocationSize=1)
	@GeneratedValue(generator="ForumPostSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author of the post
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_id")
	private Person author;
	
	/**
	 * The title of the post
	 */
	@Column(name="fp_title")
	private String title;
	
	/**
	 * The content of the post
	 */
	@Column(name="fp_content")
	private String content;
	
	/**
	 * The time of the post
	 */
	@Column(name="fp_timestamp")
	private Timestamp timestamp;
	
	/**
	 * The likes that associate with the post
	 */
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LikeablePost> likes;

	/**
	 * The dislikes that associate with the post
	 */
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DisLikeablePost> dislikes;
	
	/**
	 * Whether the post had been answered
	 */
	@Column(name="fp_resolved")
	private boolean resolved;
	
	/**
	 * The list of reply that associate with the post
	 */
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PostReply> replys;
	
	/**
	 * The list of category that associate with the post
	 */
	@ManyToMany
	private List<ForumCategory> category;
	
	/**
	 * A constructor for initialize the ForumPost object.
	 */
	public ForumPost() {
		replys = new ArrayList<>();
		category = new ArrayList<>();
	}
	
	/**
	 * A constructor for initialize the ForumPost object.
	 * @param author The author of the post
	 * @param title The title of the post
	 * @param content The content of the post
	 * @param timestamp The time of the post
	 * @param resolved Whether the post had been answered
	 */
	public ForumPost(Person author, String title, String content, Timestamp timestamp, 
			boolean resolved) {
		this();
		this.author = author;
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
		this.resolved = resolved;
	}

	/**
	 * A constructor for initialize the ForumPost object.
	 * @param id The primary ID of the ForumPost
	 * @param author The author of the post
	 * @param title The title of the post
	 * @param content The content of the post
	 * @param timestamp The time of the post
	 * @param likes The likes that associate with the post
	 * @param dislikes The dislikes that associate with the post
	 * @param resolved Whether the post had been answered
	 * @param replys The list of reply that associate with the post
	 * @param category The list of category that associate with the post
	 */
	public ForumPost(int id, Person author, String title, String content, 
			Timestamp timestamp, List<LikeablePost> likes, List<DisLikeablePost> dislikes,
			boolean resolved, List<PostReply> replys, List<ForumCategory> category) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
		this.likes = likes;
		this.dislikes = dislikes;
		this.resolved = resolved;
		this.replys = replys;
		this.category = category;
	}

	/**
	 * Getting the id of the ForumPost
	 * @return The id of the ForumPost
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the ForumPost
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the ForumPost
	 * @return The author of the ForumPost
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set a new author for the ForumPost
	 * @param author The author of the ForumPost
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the title of the ForumPost
	 * @return The title of the ForumPost
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set a new title for the ForumPost
	 * @param title a title for the ForumPost
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getting the content of the ForumPost
	 * @return The content of the ForumPost
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set a new content for the ForumPost
	 * @param content a content for the ForumPost
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getting the time of the ForumPost
	 * @return The time of the ForumPost
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Set a new time for the ForumPost
	 * @param timestamp a time for the ForumPost
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Whether the post had been resolved
	 * @return Whether the post had been resolved
	 */
	public boolean isResolved() {
		return resolved;
	}

	/**
	 * Set whether the post had been resolved
	 * @param resolved Whether the post had been resolved
	 */
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	/**
	 * Getting the list of reply of the ForumPost
	 * @return The list of reply of the ForumPost
	 */
	public List<PostReply> getReplys() {
		return replys;
	}

	/**
	 * Set a new list of reply for the ForumPost
	 * @param replys a list of reply for the ForumPost
	 */
	public void setReplys(List<PostReply> replys) {
		this.replys = replys;
	}

	/**
	 * Getting the list of category of the ForumPost
	 * @return The list of category of the ForumPost
	 */
	public List<ForumCategory> getCategory() {
		return category;
	}

	/**
	 * Set a new list of category for the ForumPost
	 * @param category a list of category for the ForumPost
	 */
	public void setCategory(List<ForumCategory> category) {
		this.category = category;
	}

	/**
	 * Getting the list of likes of the ForumPost
	 * @return The list of likes of the ForumPost
	 */
	public List<LikeablePost> getLikes() {
		return likes;
	}

	/**
	 * Set a new list of likes for the ForumPost
	 * @param likes a list of likes for the ForumPost
	 */
	public void setLikes(List<LikeablePost> likes) {
		this.likes = likes;
	}

	/**
	 * Getting the list of dislikes of the ForumPost
	 * @return The list of dislikes of the ForumPost
	 */
	public List<DisLikeablePost> getDislikes() {
		return dislikes;
	}

	/**
	 * Set a new list of dislikes for the ForumPost
	 * @param dislikes a new list of dislikes for the ForumPost
	 */
	public void setDislikes(List<DisLikeablePost> dislikes) {
		this.dislikes = dislikes;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "ForumPost [id=" + id + ", author=" + author + ", title=" + title 
				+ ", content=" + content + ", timestamp=" + timestamp + ", likes=" 
				+ likes + ", dislikes=" + dislikes + ", resolved=" + resolved
				+ ", replys=" + replys + ", category=" + category + "]";
	}

	
}
