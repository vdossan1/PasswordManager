package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestGetCredentialWithSpecifiedName {

	@Test
	void testGetCredentialWithSpecifiedNameWithEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		String systemName = "facebook";
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.getCredentialWithSpecifiedName(systemName);
		});
	}
	
	@Test
	void testGetCredentialWithSpecifiedNameWithNullParameter() {
		CredentialManager newManager = new CredentialManager();
		
		String systemName = null;
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.getCredentialWithSpecifiedName(systemName);
		});
	}
	
	@Test
	void testGetCredentialWithSpecifiedNameWithEmptyParameter() {
		CredentialManager newManager = new CredentialManager();
		
		String systemName = "";
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.getCredentialWithSpecifiedName(systemName);
		});
	}
	
	@Test
	void testGetCredentialWithSpecifiedNameWithOneValidParameter() {
		
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
			
		CredentialManager newManager = new CredentialManager();
		newManager.addCredential(newCredential);
			
		String systemName = "facebook";
		
		assertEquals(newCredential, newManager.getCredentialWithSpecifiedName(systemName));
	}
	
	@Test
	void testGetCredentialWithSpecifiedNameWithMultipleValidParameter() {
		
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
		
		assertEquals(newCredentialTwo, newManager.getCredentialWithSpecifiedName(systemName));
	}
	
	@Test
	void testGetCredentialWithSpecifiedNameWithMultipleInvalidParameter() {
		
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
			
		String systemName = "snapchat";
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.getCredentialWithSpecifiedName(systemName);
		});
	}

}
