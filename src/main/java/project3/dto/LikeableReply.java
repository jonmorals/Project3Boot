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
 * All the likes for the reply
 */
@Entity
@Table(name="LikeableReply")
public class LikeableReply {

	/**
	 * The primary ID of the LikeableReply
	 */
	@Id
	@Column(name="likereply_id")
	@SequenceGenerator(name="likeablereplySeq", sequenceName="Likeablereply_Seq", 
		allocationSize=1)
	@GeneratedValue(generator="likeablereplySeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author that likes the reply
	 */
	@OneToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="u_id")
	private Person author;
	
	/**
	 * The reply that the like associated to
	 */
	@ManyToOne
	@JoinColumn(name="pr_id")
	private PostReply reply;
	
	/**
	 * An empty constructor for initialize the LikeableReply object.
	 */
	public LikeableReply() {
		// Do nothing because of Hibernate to create the object
	}
	
	/**
	 * A constructor for initialize the LikeableReply object.
	 * @param author The author that likes the reply
	 * @param reply The reply that the like associated to
	 */
	public LikeableReply(Person author, PostReply reply) {
		super();
		this.author = author;
		this.reply = reply;
	}

	/**
	 * A constructor for initialize the LikeableReply object.
	 * @param id The primary ID of the LikeableReply
	 * @param author The author that likes the reply
	 * @param reply The reply that the like associated to
	 */
	public LikeableReply(int id, Person author, PostReply reply) {
		super();
		this.id = id;
		this.author = author;
		this.reply = reply;
	}

	/**
	 * Getting the id of the LikeableReply
	 * @return The id of the LikeableReply
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the LikeableReply
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the LikeableReply
	 * @return The author of the LikeableReply
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set a new author for the LikeableReply
	 * @param author The author of the LikeableReply
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the reply of the LikeableReply
	 * @return The reply of the LikeableReply
	 */
	public PostReply getReply() {
		return reply;
	}

	/**
	 * Set a new reply for the LikeableReply
	 * @param reply The reply of the LikeableReply
	 */
	public void setReply(PostReply reply) {
		this.reply = reply;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "LikeableReply [id=" + id + ", author=" + author + ", reply=" + reply 
				+ "]";
	}
}
