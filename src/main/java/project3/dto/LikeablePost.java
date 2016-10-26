package project3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * All the likes for the post
 */
@Entity
@Table(name="LikeablePost")
public class LikeablePost {

	/**
	 * The primary ID of the LikeablePost
	 */
	@Id
	@Column(name="likepost_id")
	@SequenceGenerator(name="likeablepostSeq", sequenceName="Likeablepost_Seq", 
		allocationSize=1)
	@GeneratedValue(generator="likeablepostSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author that likes the post
	 */
	@OneToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="u_id")
	private Person author;
	
	/**
	 * The post that the like associated to
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fp_id")
	private ForumPost post;
	
	/**
	 * An empty constructor for initialize the LikeablePost object.
	 */
	public LikeablePost() {
		// Do nothing because of Hibernate to create the object
	}
	
	/**
	 * A constructor for initialize the LikeablePost object.
	 * @param author The author that likes the post
	 * @param post The post that the like associated to
	 */
	public LikeablePost(Person author, ForumPost post) {
		this.author = author;
		this.post = post;
	}
	
	/**
	 * A constructor for initialize the LikeablePost object.
	 * @param id The primary ID of the LikeablePost
	 * @param author The author that likes the post
	 * @param post The post that the like associated to
	 */
	public LikeablePost(int id, Person author, ForumPost post) {
		super();
		this.id = id;
		this.author = author;
		this.post = post;
	}

	/**
	 * Getting the id of the LikeablePost
	 * @return The id of the LikeablePost
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the LikeablePost
	 * @param id id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the LikeablePost
	 * @return The author of the LikeablePost
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set a new author for the LikeablePost
	 * @param author The author of the LikeablePost
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the post of the LikeablePost
	 * @return The post of the LikeablePost
	 */
	public ForumPost getPost() {
		return post;
	}

	/**
	 * Set a new post for the LikeablePost
	 * @param post The post of the LikeablePost
	 */
	public void setPost(ForumPost post) {
		this.post = post;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "LikeablePost [id=" + id + ", author=" + author + ", post=" + post + "]";
	}
}
