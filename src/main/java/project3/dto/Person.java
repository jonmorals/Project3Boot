package project3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The user of the RevPages
 */
@Entity
@Table(name="Person")
public class Person {
	
	/**
	 * The primary ID of the Person
	 */
	@Id
	@Column(name="u_id")
	@SequenceGenerator(name="personSeq", sequenceName="person_Seq", allocationSize=1)
	@GeneratedValue(generator="personSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * The first name of the person
	 */
	@Column(name="u_firstName", nullable=false)
	private String firstName;
	
	/**
	 * The last name of the person
	 */
	@Column(name="u_lastName", nullable=false)
	private String lastName;

	/**
	 * The user name of the person
	 */
	@Column(name="u_username", nullable=false, unique=true)
	private String username;
	
	/**
	 * The password of the person
	 */
	@Column(name="u_password", nullable=false)
	@Size(min=6)
	private String password;
	
	/**
	 * The email of the person
	 */
	@Column(name="u_email", nullable= false, unique=true)
	private String email;
	
	/**
	 * The role of the person
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="r_id")
	private Role role;
	
	/**
	 * The URL of the profile picture 
	 */
	@Column(name="u_picture")
	private String profilePic;
	
	/**
	 * The place where the person live
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_id")
	private Complex complex;
	
	/**
	 * The phone number of the person
	 */
	@Column(name="u_phoneNumber")
	private String phoneNumber;
	
	/**
	 * The biography of the person
	 */
	@Column(name="u_bio")
	private String bio;
	
	/**
	 * The university of the person
	 */
	@Column(name="u_university")
	private String university;
	
	/**
	 * Whether the user had been validated by login in
	 */
	@Column(name="u_vaildated")
	private boolean vaildated;
	
	/**
	 * The URL to the person's Linkedin
	 */
	@Column(name="u_linkedin")
	private String linkedin;
	
	/**
	 * The total likes a person had gotten
	 */
	@Column(name="u_totalLikes")
	private int totalLikes;
	
	/**
	 * An empty constructor for initialize the Person object.
	 */
	public Person() {
		// Do nothing because of Hibernate to create the object
	}
	
	/**
	 * A constructor for initialize the Person object.
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @param username The user name of the person
	 * @param password The password of the person
	 * @param email The email of the person
	 * @param role The role of the person
	 * @param profilePic The URL of the profile picture 
	 * @param complex The place where the person live
	 * @param phoneNumber The phone number of the person
	 * @param bio The biography of the person
	 * @param university The university of the person
	 * @param vaildated Whether the user had been validated by login in
	 * @param linkedin The URL to the person's Linkedin
	 */
	public Person(String firstName, String lastName, String username, String password,
			String email, Role role, String profilePic, Complex complex, 
			String phoneNumber, String bio, String university, boolean vaildated,
			String linkedin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.profilePic = profilePic;
		this.complex = complex;
		this.phoneNumber = phoneNumber;
		this.bio = bio;
		this.university = university;
		this.vaildated = vaildated;
		this.linkedin = linkedin;
	}
	
	/**
	 * A constructor for initialize the Person object.
	 * @param id The primary ID of the Person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @param username The user name of the person
	 * @param password The password of the person
	 * @param email The email of the person
	 * @param role The role of the person
	 * @param profilePic The URL of the profile picture 
	 * @param complex The place where the person live
	 * @param phoneNumber The phone number of the person
	 * @param bio The biography of the person
	 * @param university The university of the person
	 * @param vaildated Whether the user had been validated by login in
	 * @param linkedin The URL to the person's Linkedin
	 * @param totalLikes The total likes a person had gotten
	 */
	public Person(int id, String firstName, String lastName, String username, 
			String password, String email, Role role, String profilePic, Complex complex, 
			String phoneNumber, String bio, String university, boolean vaildated, 
			String linkedin, int totalLikes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.profilePic = profilePic;
		this.complex = complex;
		this.phoneNumber = phoneNumber;
		this.bio = bio;
		this.university = university;
		this.vaildated = vaildated;
		this.linkedin = linkedin;
		this.totalLikes = totalLikes;
	}

	/**
	 * Getting the id of the Person
	 * @return The id of the Person
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the Person
	 * @param id The id of the Person
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the first name of the Person
	 * @return The first name of the Person
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set a new first name for the Person
	 * @param firstName The first name to be set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getting the last name of the Person
	 * @return The last name of the Person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set a new last name for the Person
	 * @param lastName The last name to be set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getting the user name of the Person
	 * @return The user name of the Person
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set a new user name for the Person
	 * @param username The user name to be set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getting the password of the Person
	 * @return The password of the Person
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set a new password for the Person
	 * @param username The password to be set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getting the email of the Person
	 * @return The email of the Person
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set a new email for the Person
	 * @param email The email to be set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getting the role of the Person
	 * @return The role of the Person
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Set a new role for the Person
	 * @param role The role of the Person
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Getting the profile picture of the Person
	 * @return The profile picture of the Person
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * Set a new profile picture for the Person
	 * @param profilePic The profile picture to be set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * Getting the complex of the Person
	 * @return The complex of the Person
	 */
	public Complex getComplex() {
		return complex;
	}

	/**
	 * Set a new complex for the Person
	 * @param complex The new complex to be set
	 */
	public void setComplex(Complex complex) {
		this.complex = complex;
	}

	/**
	 * Getting the phone number of the Person
	 * @return The phone number of the Person
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set a new phone number for the Person
	 * @param phoneNumber The new phone number to be set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getting the biography of the Person
	 * @return The biography of the Person
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Set a new biography for the Person
	 * @param bio The new biography to be set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Getting the university of the Person
	 * @return The university of the Person
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * Set a new university for the Person
	 * @param university The new university to be set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * Checking if the person had validated
	 * @return If the person had validated
	 */
	public boolean isVaildated() {
		return vaildated;
	}

	/**
	 * Set if the person had validated
	 * @param vaildated If the person had validated
	 */
	public void setVaildated(boolean vaildated) {
		this.vaildated = vaildated;
	}

	/**
	 * Getting the Linkedin URL of the Person
	 * @return The Linkedin URL of the Person
	 */
	public String getLinkedin() {
		return linkedin;
	}

	/**
	 * Set a new Linkedin URL for the Person
	 * @param linkedin The new Linkedin URL to be set
	 */
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	/**
	 * Getting the total likes of the Person
	 * @return The total likes of the Person
	 */
	public int getTotalLikes() {
		return totalLikes;
	}

	/**
	 * Set a new total likes for the Person
	 * @param totalLikes The new total likes to be set
	 */
	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" 
				+ lastName + ", username=" + username + ", password=" + password 
				+ ", email=" + email + ", role=" + role + ", profilePic=" + profilePic
				+ ", complex=" + complex + ", phoneNumber=" + phoneNumber + ", bio=" 
				+ bio + ", unviersity=" + university + ", vaildated=" + vaildated 
				+ ", linkedin=" + linkedin + ", totalLikes=" + totalLikes + "]";
	}
}
