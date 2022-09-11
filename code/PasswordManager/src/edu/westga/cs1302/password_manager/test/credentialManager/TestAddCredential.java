package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestAddCredential {

	@Test
	void testAddCredentialWithNullParamenter() {
		CredentialManager newManager = new CredentialManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.addCredential(null);
		});
	}
	
	@Test
	void testAddCredentialWithValidCredential() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
		
		assertTrue(newManager.addCredential(newCredential));	
	}
	
	@Test
	void testAddCredentialWithMultipleValidCredentials() {
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
		
		assertEquals(2, newManager.getSize());
	}
	
	@Test
	void testAddCredentialsWithMultipleCredentialsOneInvalidName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		Credential newCredentialTwo = new Credential(
				"facebook",
				"hugo",
				"987654321");
		
		CredentialManager newManager = new CredentialManager();
		
		newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.addCredential(newCredentialTwo);
		});
	}

}
