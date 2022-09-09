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
		
		if (!this.checkIfSystemNameExists(credential)) {
			return this.credentialsList.add(credential);
		} else {
			return false;
		}
		
		
	}
	
	private boolean checkIfSystemNameExists(Credential credential) {
		for (Credential sysName: this.credentialsList) {
			if (sysName.getSystemName().equals(credential.getSystemName())) {
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
}
