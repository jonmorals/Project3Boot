package project3.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The category of each post
 */
@Entity
@Table(name="ForumCategory")
public class ForumCategory {
	
	/**
	 * The primary ID of the ForumCategory
	 */
	@Id
	@Column(name="fc_id")
	@SequenceGenerator(name="forumCatSeq", sequenceName="forumCat_Seq", allocationSize=1)
	@GeneratedValue(generator="forumCatSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The name of the category
	 */
	@Column(name="fc_categoryName")
	private String categoryName;
	
	/**
	 * A list of the post associate with the category
	 */
	@ManyToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ForumPost> forumPost;
	
	/**
	 * A constructor for initialize the ForumCategory object.
	 */
	public ForumCategory() {
		forumPost = new ArrayList<>();
	}
	
	/**
	 * A constructor for initialize the ForumCategory object.
	 * @param categoryName The name of the category
	 */
	public ForumCategory(String categoryName) {
		this();
		this.categoryName = categoryName;
	}

	/**
	 * A constructor for initialize the ForumCategory object.
	 * @param id The primary ID of the ForumCategory
	 * @param categoryName The name of the category
	 */
	public ForumCategory(int id, String categoryName) {
		this();
		this.id = id;
		this.categoryName = categoryName;
	}

	/**
	 * Getting the id of the ForumCategory
	 * @return The id of the ForumCategory
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the ForumCategory
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the name of the ForumCategory
	 * @return The name of the ForumCategory
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Set a new name for the ForumCategory
	 * @param categoryName The new name to be set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Getting the list of post of the ForumCategory
	 * @return The list of post of the ForumCategory
	 */
	public List<ForumPost> getForumPost() {
		return forumPost;
	}

	/**
	 * Set a new list of post for the ForumCategory
	 * @param forumPost A list of post to be set
	 */
	public void setForumPost(List<ForumPost> forumPost) {
		this.forumPost = forumPost;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "ForumCategory [id=" + id + ", categoryName=" + categoryName 
				+ ", forumPost=" + forumPost + "]";
	}

}
