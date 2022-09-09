package edu.westga.cs1302.password_manager.model;

/**
 * Data class to store information for a single credential
 * 
 * @author Vitor dos Santos
 * @version Fall 2022
 *
 */
public class Credential {
	private String systemName;
	private String userName;
	private String password;
	
	/**
	 * Get the system name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the system name
	 */
	public String getSystemName() {
		return this.systemName;
	}
	
	/**
	 * Set the system name
	 * 
	 * @precondition systemName != null && systemName != systemName.isEmpty()
	 * @postcondition getSystemName() == systemName
	 * 
	 * @param systemName the name of the system
	 * 
	 */
	public void setSystemName(String systemName) {
		if (systemName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_SYSTEM_ERROR);
		}
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_SYSTEM_NAME_ERROR);
		}
		this.systemName = systemName;
	}
	
	/**
	 * Get the user name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Set the user name for the specific system
	 * 
	 * @precondition getUserName != null && getUserName != getUserName.isEmpty()
	 * @postcondition getUserName() == userName
	 * 
	 * @param userName the user name
	 * 
	 */
	public void setUserName(String userName) {
		if (userName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_USER_NAME_ERROR);
		}
		if (userName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_USER_NAME_ERROR);
		}
		this.userName = userName;
	}
	
	/**
	 * Get the password
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Set the password for the specific system
	 * 
	 * @precondition getPassword != null && getPassword != getPassword.isEmpty()
	 * @postcondition getPassword() == password
	 * 
	 * @param password the password for the system
	 * 
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_PASSWORD_ERROR);
		}
		if (password.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_PASSWORD_ERROR);
		}
		this.password = password;
	}
}
