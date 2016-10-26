package project3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The key to the S3
 */
@Entity
@Table(name="AwsKey")
public class AwsKey {

	/**
	 * The primary ID of the AwsKey
	 */
	@Id
	@Column(name="aws_id")
	private int id;
	
	/**
	 * The access key to S3
	 */
	@Column(name="aws_key")
	private String accessKey;
	
	/**
	 * The secret access key to S3
	 */
	@Column(name="aws_pkey")
	private String secretAccessKey;

	/**
	 * An empty constructor for initialize the AwsKey object.
	 */
	public AwsKey() {
		// Do nothing because of Hibernate to create the object
	}

	/**
	 * A constructor for initialize the AwsKey object.
	 * @param id The primary ID of the AwsKey
	 * @param accessKey The access key to S3
	 * @param secretAccessKey The secret access key to S3
	 */
	public AwsKey(int id, String accessKey, String secretAccessKey) {
		super();
		this.id = id;
		this.accessKey = accessKey;
		this.secretAccessKey = secretAccessKey;
	}

	/**
	 * Getting the id of the AwsKey
	 * @return The id of the AwsKey
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set a new id for the AwsKey
	 * @param id The new id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getting the accessKey of the AwsKey
	 * @return The accessKey of the AwsKey
	 */
	public String getAccessKey() {
		return accessKey;
	}

	/**
	 * Set a new accessKey for the AwsKey
	 * @param accessKey The new accessKey to be set
	 */
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	/**
	 * Getting the secretAccessKey of the AwsKey
	 * @return The secretAccessKey of the AwsKey
	 */
	public String getSecretAccessKey() {
		return secretAccessKey;
	}

	/**
	 * Set a new secretAccessKey for the AwsKey
	 * @param secretAccessKey The new secretAccessKey to be set
	 */
	public void setSecretAccessKey(String secretAccessKey) {
		this.secretAccessKey = secretAccessKey;
	}

	/**
	 * A String representation of the object
	 */
	@Override
	public String toString() {
		return "AwsKey [id=" + id + ", accessKey=" + accessKey + ", secretAccessKey=" 
				+ secretAccessKey + "]";
	}
}
