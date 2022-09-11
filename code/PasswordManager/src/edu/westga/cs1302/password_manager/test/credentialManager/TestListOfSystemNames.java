package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestListOfSystemNames {

	@Test
	void testListOfSystemNamesWithEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		ArrayList<String> credentialsList = new ArrayList<String>();
		
		assertEquals(credentialsList.size(), newManager.listOfSystemNames().size());
	}
	
	@Test
	void testListOfSystemNamesWithOneCredential() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			
		ArrayList<String> credentialsList = new ArrayList<String>();
			credentialsList.add(newCredential.getSystemName());
		
		assertEquals(credentialsList, newManager.listOfSystemNames());
	}
	
	@Test
	void testListOfSystemNamesWithMultipleCredentials() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
			
		Credential newCredentialTwo = new Credential(
				"whatsapp",
				"hugo",
				"987654321");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			newManager.addCredential(newCredentialTwo);
			
		ArrayList<String> credentialsList = new ArrayList<String>();
			credentialsList.add(newCredential.getSystemName());
			credentialsList.add(newCredentialTwo.getSystemName());
		
		assertEquals(credentialsList, newManager.listOfSystemNames());
	}

}
