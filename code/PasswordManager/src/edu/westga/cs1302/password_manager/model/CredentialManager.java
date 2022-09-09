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
	 * Add a credential object to the CredentialManager if the system name for that object does not exists in the list already
	 * 
	 * @precondition credential != null
	 * @postcondition this.getSize() == this.getSize()@prev + 1
	 * 
	 * @param credential the credential to be added to the this.credentialList
	 * 
	 * @return true if the credential was added to the list
	 */
	public boolean addCredential(Credential credential) {
		
		if (credential == null) {
			throw new IllegalArgumentException("Credential cannot be null");
		}
		
		if (!this.checkIfSystemNameExists(credential.getSystemName())) {
			return this.credentialsList.add(credential);
		} else {
			return false;
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
			throw new IllegalArgumentException("System name cannot be null");
		}
		
		if (systemName.isEmpty()) {
			throw new IllegalArgumentException("System name cannot be empty");
		}
		
		if (!this.checkIfSystemNameExists(systemName)) {
			throw new IllegalArgumentException("That system requested does not exist");
		}
		
		Credential selectedCredential = null;
		
		for (Credential credential: this.credentialsList) {
    		if (credential.getSystemName().equals(systemName)) {
    			selectedCredential = credential;
    		}
    	}
		
		return selectedCredential;
	}
}
