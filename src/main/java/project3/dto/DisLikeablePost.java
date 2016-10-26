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
 * All the dislikes for the post
 */
@Entity
@Table(name="DisLikeablePost")
public class DisLikeablePost {

	/**
	 * The primary ID of the DisLikeablePost
	 */
	@Id
	@Column(name="dislikepost_id")
	@SequenceGenerator(name="dislikeablepostSeq", sequenceName="disLikeablepost_Seq", allocationSize=1)
	@GeneratedValue(generator="dislikeablepostSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author that dislikes the post
	 */
	@OneToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="u_id")
	private Person author;
	
	/**
	 * The post that the dislike associated to
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fp_id")
	private ForumPost post;
	
	/**
	 * An empty constructor for initialize the DisLikeablePost object.
	 */
	public DisLikeablePost() {
		// Do nothing because of Hibernate to create the object
	}

	/**
	 * A constructor for initialize the DisLikeablePost object
	 * @param author The author that dislikes the post
	 * @param post The post that the dislike associated to
	 */
	public DisLikeablePost(Person author, ForumPost post) {
		super();
		this.author = author;
		this.post = post;
	}

	/**
	 * A constructor for initialize the DisLikeablePost object
	 * @param id The primary ID of the DisLikeablePost
	 * @param author The author that dislikes the post
	 * @param post The post that the dislike associated to
	 */
	public DisLikeablePost(int id, Person author, ForumPost post) {
		super();
		this.id = id;
		this.author = author;
		this.post = post;
	}

	/**
	 * Getting the id of the DisLikeablePost
	 * @return The id of the DisLikeablePost
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the DisLikeablePost
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the DisLikeablePost
	 * @return The author of the DisLikeablePost
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set a new author for the DisLikeablePost
	 * @param author The author of the DisLikeablePost
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the post of the DisLikeablePost
	 * @return The post of the DisLikeablePost
	 */
	public ForumPost getPost() {
		return post;
	}

	/**
	 * Set a new post for the DisLikeablePost
	 * @param author The post of the DisLikeablePost
	 */
	public void setPost(ForumPost post) {
		this.post = post;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "DisLikeablePost [id=" + id + ", author=" + author + ", post=" + post 
				+ "]";
	}
}
