package project3.service;

public interface Crypt {

	/**
	 * This method salts && encrypts the target.
	 *  
	 * @param target : The string you want encrypted.
	 * @return Returns the encrypted target.
	 */
	public String encrypt(String target);

	/**
	 * Getting a random string for the password
	 * @param length The length of the string
	 * @return A random string for the password
	 */
	public String getRandom(int length);
	
	/**
	 * 
	 * This method is used to compare user supplied values to encrypted fields.
	 * 
	 * @param input  : User supplied value. Such as: password from user.
	 * @param hashed : Encrypted version of that value. Such as: password from database.
	 * @return true if they match, false if they don't.
	 */
	public boolean validate(String input, String hashed);
	
}
