package edu.westga.cs1302.password_manager.model;

import java.util.ArrayList;

/**
 * List Wrapper Class to store a collection of Credential objects
 *  
 * @author Vitor dos Santos
 * @version Fall 2022
 *
 */
public class CredentialManager {
	private ArrayList<Credential> credentialsList;
	
	/**
	 * Create a ListOfSystemsData object
	 */
	public CredentialManager() {
		this.credentialsList = new ArrayList<Credential>();
	}
	
	/**
	 * Gets the size of the list of credentials
	 * 
	 * @return the size of the list of credentials
	 */
	public int getSize() {
		return this.credentialsList.size();
	}
	
	/**
	 * Add a credential object to the CredentialManager if the system name does not exist on the credentialsList
	 * 
	 * @precondition credential != null
	 * @postcondition this.getSize() == this.getSize()@prev + 1
	 * 
	 * @param credential the credential to be added to the this.credentialList
	 * 
	 * @return true if the credential is added, throw an exception if it does not
	 */
	public boolean addCredential(Credential credential) {
		
		if (credential == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_CREDENTIAL_ERROR);
		}
		
		if (this.checkIfSystemNameExists(credential.getSystemName())) {
			throw new IllegalArgumentException(CharacterUtility.SYSTEM_ALREADY_EXISTS);
		} else {
			return this.credentialsList.add(credential);
		}
		
	}
	
	private boolean checkIfSystemNameExists(String systemName) {
		for (Credential sysName: this.credentialsList) {
			if (sysName.getSystemName().equals(systemName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a list of all the credentials
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return all the credentials in the list
	 */
	public ArrayList<Credential> credentialsList() {
		
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
		
		for (Credential currentCredential: this.credentialsList) {
			credentialsList.add(currentCredential);
		}
		
		return credentialsList;
	}
	
	/**
	 * Returns an array list with all the system names in the credentialsList
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list with the system names in the list
	 */
	public ArrayList<String> listOfSystemNames() {
		
		ArrayList<String> systemNamesList = new ArrayList<String>();
		
		for (Credential sysName: this.credentialsList) {
			systemNamesList.add(sysName.getSystemName());
		}
		
		return systemNamesList;
	}
	
	/**
	 * Get a specific credential object that matches the system name provided in the parameter
	 * 
	 * @precondition systemName != null & !systemName.isEmpty
	 * @postcondition none
	 * 
	 * @param systemName the name of the system that should be returned
	 * 
	 * @return credential the credential with system name matching the parameter
	 */
	public Credential getCredentialWithSpecifiedName(String systemName) {
		
		if (systemName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_SYSTEM_ERROR);
		}
		
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_SYSTEM_NAME_ERROR);
		}
		
		if (!this.checkIfSystemNameExists(systemName)) {
			throw new IllegalArgumentException(CharacterUtility.SYSTEM_DO_NOT_EXIST_ERROR);
		}
		
		Credential selectedCredential = null;
		
		for (Credential credential: this.credentialsList) {
    		if (credential.getSystemName().equals(systemName)) {
    			selectedCredential = credential;
    		}
    	}
		
		return selectedCredential;
	}
	
	/**
	 * Remove the credentials with specified system name
	 * 
	 * @precondition systemName != null && !systemName.isEmpty
	 * @postcondition this.getSize() == this.getSize()@prev - 1
	 * 
	 * @param systemName the name of the system that should be removed
	 * 
	 * @return true is the system has been removed
	 */
	public boolean removeCredential(String systemName) {
		
		if (this.getSize() == 0) {
			throw new IllegalStateException(CharacterUtility.EMPY_LIST_ERROR);
		}
		
		if (systemName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_SYSTEM_ERROR);
		}
		
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_SYSTEM_NAME_ERROR);
		}
		
		if (!this.checkIfSystemNameExists(systemName)) {
			throw new IllegalArgumentException(CharacterUtility.SYSTEM_DO_NOT_EXIST_ERROR);
		}
		
		Credential credentialToBeRemoved = this.getCredentialWithSpecifiedName(systemName);	
		
		return this.credentialsList.remove(credentialToBeRemoved);
	}
	
	/**
	 * Update the specified credential with the new information
	 * 
	 * @precondition systemName != null && systemName != systemName.isEmpty()
	 * 				 getUserName != null && getUserName != getUserName.isEmpty()
	 * 				 getPassword != null && getPassword != getPassword.isEmpty()
	 * @postcondition this.getCredentialWithSpecifiedName(systemName).getUserName.equals(userName)
	 * 				  this.getCredentialWithSpecifiedName(systemName).getPassword.equals(password)
	 * 
	 * @param systemName the new system name
	 * @param userName the new user name
	 * @param password the new password
	 */
	public void updateCredential(String systemName, String userName, String password) {
		
		if (this.getSize() == 0) {
			throw new IllegalStateException(CharacterUtility.EMPY_LIST_ERROR);
		}
		
		if (systemName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_SYSTEM_ERROR);
		}
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_SYSTEM_NAME_ERROR);
		}
		
		if (userName == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_USER_NAME_ERROR);
		}
		if (userName.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_USER_NAME_ERROR);
		}
		
		if (password == null) {
			throw new IllegalArgumentException(CharacterUtility.NULL_PASSWORD_ERROR);
		}
		
		if (password.isEmpty()) {
			throw new IllegalArgumentException(CharacterUtility.EMPTY_PASSWORD_ERROR);
		}
		
		Credential credentialToChange = this.getCredentialWithSpecifiedName(systemName);
		
		credentialToChange.setUserName(userName);
		credentialToChange.setPassword(password);
		
		
	}
}
