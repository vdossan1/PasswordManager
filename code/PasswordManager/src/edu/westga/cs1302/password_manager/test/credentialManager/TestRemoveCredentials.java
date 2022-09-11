package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestRemoveCredentials {

	@Test
	void testRemoveCredentialWithEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		String systemName = "facebook";
		
		assertThrows(IllegalStateException.class, () -> {
			newManager.removeCredential(systemName);
		});
	}
	
	@Test
	void testRemoveCredentialWithWithNullParameter() {
		
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);	
		
		String systemName = null;
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.removeCredential(systemName);
		});
	}
	
	@Test
	void testRemoveCredentialWithEmptyParameter() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);	
		
		String systemName = "";
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.removeCredential(systemName);
		});
	}
	
	@Test
	void testRemoveCredentialWithOneParameter() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);	
		
		String systemName = "facebook";
		
		assertTrue(newManager.removeCredential(systemName));
	}
	
	@Test
	void testRemoveCredentialWithMultipleParameter() {
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
		
		String systemName = "whatsapp";
		
		assertTrue(newManager.removeCredential(systemName));
	}

}
