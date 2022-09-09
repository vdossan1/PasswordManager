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
			throw new IllegalArgumentException("System Name cannot be null");
		}
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException("System Name cannot be empty");
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
			throw new IllegalArgumentException("User name cannot be null");
		}
		if (userName.isEmpty()) {
			throw new IllegalArgumentException("User name cannot be empty");
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
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (password.isEmpty()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		this.password = password;
	}
}
