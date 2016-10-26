package project3.service.impl;

import org.jets3t.service.S3Service;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.GroupGrantee;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import project3.service.Jets3;

@Component
public class Jets3Impl implements Jets3{

	private S3Service S3; 
	/**
	 * The name of the S3 that was made
	 */
	private static final String BUCKET = "revaturepage";
	
	/**
	 * The folder inside of revatuerpage that contain the picture
	 */
	private static final String PROFILES = "profiles/";
	
	/**
	 * The HTTP of address
	 */
	private static final String HTTP = "http://";
	
	/**
	 * The address where S3 is
	 */
	private static final String ADDRESS = "s3-us-west-2.amazonaws.com/";
	
	/**
	 * Attempts to upload a profile picture to the S3 server
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param loginName the name (or email) the user logs in with
	 * @param file a file that is to be uploaded to the S3 server
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	@Override
	public String uploadProfileItem(String loginName, String fileName, MultipartFile file, 
			String publicKey, String privateKey) {
		return uploadFile(PROFILES + loginName + "/", fileName, file, publicKey, privateKey);
	}
	
	/**
	 * Attempts to upload a profile picture to the S3 server
	 * @param loginName the name (or email) the user logs in with
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param publicKey The public key of S3
	 * @param privateKey The private key of S3
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	public String uploadProfileItem(String loginName, String fileName, String publicKey, String privateKey){
		return copyDefault(PROFILES + loginName + "/", fileName, publicKey, privateKey);
	}
	
	/**
	 * Attempts to upload a file to the S3 server
	 * @param folderPath the path to the folder this file will be stored at starting at the S3 root
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param file a File that is to be uploaded to the database
	 * @param publicKey The public key of S3
	 * @param privateKey The private key of S3
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	protected String uploadFile(String folderPath, String fileName, MultipartFile file,
			String publicKey, String privateKey) {
		S3 = new RestS3Service(new AWSCredentials(
				publicKey, privateKey));
		try {
			S3Bucket bucket = S3.getBucket(BUCKET);
			//make the path for the file
			S3Object s3Obj = new S3Object(folderPath + fileName);
			//what type of the file it is
			s3Obj.setContentType(file.getContentType());
			//set the security of the file
			AccessControlList acl = new AccessControlList();
			acl.setOwner(bucket.getOwner());
			acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
			//upload the file
			s3Obj.setDataInputStream(file.getInputStream());
			s3Obj.setContentLength(file.getSize());
			s3Obj.setAcl(acl);
			S3.putObject(bucket, s3Obj);

			return 
				HTTP + ADDRESS +BUCKET+ "/" + folderPath + fileName;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Resource could not be uploaded
	}
	
	/**
	 * Attempts to upload the default file from the S3 to associate with the user profile 
	 * @param folderPath the path to the folder this file will be stored at starting at the S3 root
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param file a File that is to be uploaded to the database
	 * @param publicKey The public key of S3
	 * @param privateKey The private key of S3
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	protected String copyDefault(String folderPath, String fileName, String publicKey, String privateKey) {
		S3 = new RestS3Service(new AWSCredentials(
				publicKey, privateKey));
		try {
			S3Bucket bucket = S3.getBucket(BUCKET);
			String bucketName = bucket.getName();
			//make the path for the file
			S3Object s3Obj = new S3Object(folderPath + fileName);
			//set the security of the file
			s3Obj.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
			//upload the file
			S3.copyObject(bucketName, "resources/img/default.png", bucketName, s3Obj, false);
			return 
				HTTP + ADDRESS + BUCKET + "/" + folderPath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Resource could not be uploaded
	}
}