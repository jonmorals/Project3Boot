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
 * All the dislikes for the reply
 */
@Entity
@Table(name="DisLikeableReply")
public class DisLikeableReply {

	/**
	 * The primary ID of the DisLikeableReply
	 */
	@Id
	@Column(name="dislikereply_id")
	@SequenceGenerator(name="dislikeablereplySeq", sequenceName="disLikeablereply_Seq", 
		allocationSize=1)
	@GeneratedValue(generator="dislikeablereplySeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The author that dislikes the reply
	 */
	@OneToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="u_id")
	private Person author;
	
	/**
	 * The reply that the dislike associated to
	 */
	@ManyToOne
	@JoinColumn(name="pr_id")
	private PostReply reply;
	
	/**
	 * An empty constructor for initialize the DisLikeableReply object.
	 */
	public DisLikeableReply() {
		// Do nothing because of Hibernate to create the object
	}

	/**
	 * A constructor for initialize the DisLikeableReply object.
	 * @param author The author that dislikes the reply
	 * @param reply The reply that the dislike associated to
	 */
	public DisLikeableReply(Person author, PostReply reply) {
		super();
		this.author = author;
		this.reply = reply;
	}

	/**
	 * A constructor for initialize the DisLikeableReply object.
	 * @param id The primary ID of the DisLikeableReply
	 * @param author The author that dislikes the reply
	 * @param reply The reply that the dislike associated to
	 */
	public DisLikeableReply(int id, Person author, PostReply reply) {
		super();
		this.id = id;
		this.author = author;
		this.reply = reply;
	}

	/**
	 * Getting the id of the DisLikeableReply
	 * @return The id of the DisLikeableReply
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the DisLikeableReply
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the author of the DisLikeableReply
	 * @return The author of the DisLikeableReply
	 */
	public Person getAuthor() {
		return author;
	}

	/**
	 * Set a new author for the DisLikeableReply
	 * @param author The author of the DisLikeableReply
	 */
	public void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * Getting the reply of the DisLikeableReply
	 * @return The reply of the DisLikeableReply
	 */
	public PostReply getReply() {
		return reply;
	}

	/**
	 * Set a new reply for the DisLikeableReply
	 * @param author The reply of the DisLikeableReply
	 */
	public void setReply(PostReply reply) {
		this.reply = reply;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "DisLikeableReply [id=" + id + ", author=" + author + ", reply=" 
				+ reply + "]";
	}
}
