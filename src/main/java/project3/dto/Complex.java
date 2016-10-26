package project3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The place where the person lives
 */
@Entity
@Table(name="Complex")
public class Complex {
	
	/**
	 * The primary ID of the Complex
	 */
	@Id
	@Column(name="c_id")
	@SequenceGenerator(name="complexSeq", sequenceName="complex_Seq", allocationSize=1)
	@GeneratedValue(generator="complexSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The name of the Complex
	 */
	@Column(name="c_name")
	private String complexName;
	
	/**
	 * An empty constructor for initialize the Complex object.
	 */
	public Complex() {
		// Do nothing because of Hibernate to create the object
	}
	
	/**
	 * A constructor for initialize the Complex object.
	 * @param complexName The name of the Complex
	 */
	public Complex(String complexName) {
		super();
		this.complexName = complexName;
	}

	/**
	 * A constructor for initialize the Complex object.
	 * @param id The primary ID of the Complex
	 * @param complexName The name of the Complex
	 */
	public Complex(int id, String complexName) {
		super();
		this.id = id;
		this.complexName = complexName;
	}

	/**
	 * Getting the id of the Complex
	 * @return The id of the Complex
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the Complex
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the name of the Complex
	 * @return The name of the Complex
	 */
	public String getComplexName() {
		return complexName;
	}

	/**
	 * Set a new name for the Complex
	 * @param complexName The new name to be set
	 */
	public void setComplexName(String complexName) {
		this.complexName = complexName;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "Complex [id=" + id + ", complexName=" + complexName + "]";
	}

}
