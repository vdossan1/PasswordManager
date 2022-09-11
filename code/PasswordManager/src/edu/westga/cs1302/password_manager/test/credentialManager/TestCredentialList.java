package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestCredentialList {

	@Test
	void testCredentialListEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
		
		assertEquals(credentialsList, newManager.credentialsList());
	}
	
	@Test
	void testCredentialListWithOneCredential() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
			credentialsList.add(newCredential);
		
		assertEquals(credentialsList.size(), newManager.credentialsList().size());
	}
	
	@Test
	void testCredentialListWithMultipleCredentials() {
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
			
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
			credentialsList.add(newCredential);
			credentialsList.add(newCredentialTwo);
		
		assertEquals(credentialsList.size(), newManager.credentialsList().size());
	}

}
