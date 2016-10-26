package project3.service;

import org.springframework.web.multipart.MultipartFile;

public interface Jets3 {
	
	/**
	 * Attempts to upload a profile picture to the S3 server
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param loginName the name (or email) the user logs in with
	 * @param file a file that is to be uploaded to the S3 server
	 * @param publicKey The public key of S3
	 * @param privateKey The private key of S3
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	public String uploadProfileItem(String loginName, String fileName, MultipartFile file, 
			String publicKey, String privateKey);
	
	/**
	 * Attempts to upload a profile picture to the S3 server
	 * @param loginName the name (or email) the user logs in with
	 * @param fileName the destination name of the file, a valid extension should be included
	 * @param publicKey The public key of S3
	 * @param privateKey The private key of S3
	 * @return the URL where the file was uploaded if successful, null otherwise
	 */
	public String uploadProfileItem(String loginName, String fileName, String publicKey, String privateKey);

}
