package project3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Different Roles for the RevPages
 */
@Entity
@Table(name="Role")
public class Role {
	
	/**
	 * The primary ID of the role
	 */
	@Id
	@Column(name="r_id")
	@SequenceGenerator(name="roleSeq", sequenceName="role_Seq", allocationSize=1)
	@GeneratedValue(generator="roleSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The name of the role
	 */
	@Column(name="r_roleName")
	private String roleName;
	
	/**
	 * An empty constructor for initialize the role object.
	 */
	public Role() {
		// Do nothing because of Hibernate to create the object
	}

	/**
	 * A constructor for initialize the role object.
	 * @param id The primary id of the role
	 * @param roleName The name of the role
	 */
	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	/**
	 * Getting the id of the role
	 * @return The id of the role
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the role
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the name of the role
	 * @return The name of the role
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Setting a new role name
	 * @param roleName A new role name to be set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

}
