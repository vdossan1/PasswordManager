package edu.westga.cs1302.password_manager.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestCredentialManager {

	@Test
	void testConstructor() {
		
		CredentialManager newManager = new CredentialManager();
		assertEquals(0, newManager.getSize());
	}
	
	@Test
	void testAddCredentialWithNullParamenter() {
		CredentialManager newManager = new CredentialManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.addCredential(null);
		});
	}
	
	@Test
	void testAddCredentialWithValidCredential() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
		
		CredentialManager newManager = new CredentialManager();
		
		assertTrue(newManager.addCredential(newCredential));	
	}
	
	@Test
	void testAddCredentialWithMultipleValidCredentials() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
			
		Credential newCredentialTwo = new Credential();
			newCredentialTwo.setSystemName("whatsapp");
			newCredentialTwo.setUserName("hugo");
			newCredentialTwo.setPassword("987654321");
		
		CredentialManager newManager = new CredentialManager();
		
		newManager.addCredential(newCredential);
		newManager.addCredential(newCredentialTwo);
		
		assertEquals(2, newManager.getSize());
	}
	
	@Test
	void testAddCredentialsWithMultipleCredentialsOneInvalidName() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
		
		Credential newCredentialTwo = new Credential();
			newCredentialTwo.setSystemName("facebook");
			newCredentialTwo.setUserName("hugo");
			newCredentialTwo.setPassword("987654321");
		
		CredentialManager newManager = new CredentialManager();
		
		newManager.addCredential(newCredential);
		
		assertFalse(newManager.addCredential(newCredentialTwo));
	}
	
	@Test
	void testCredentialListEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
		
		assertEquals(credentialsList, newManager.credentialsList());
	}
	
	@Test
	void testCredentialListWithOneCredential() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
			credentialsList.add(newCredential);
		
		assertEquals(credentialsList.size(), newManager.credentialsList().size());
	}
	
	@Test
	void testCredentialListWithMultipleCredentials() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
			
		Credential newCredentialTwo = new Credential();
			newCredentialTwo.setSystemName("whatsapp");
			newCredentialTwo.setUserName("hugo");
			newCredentialTwo.setPassword("987654321");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			newManager.addCredential(newCredentialTwo);
			
		ArrayList<Credential> credentialsList = new ArrayList<Credential>();
			credentialsList.add(newCredential);
			credentialsList.add(newCredentialTwo);
		
		assertEquals(credentialsList.size(), newManager.credentialsList().size());
	}
	
	@Test
	void testListOfSystemNamesWithEmptyList() {
		CredentialManager newManager = new CredentialManager();
		
		ArrayList<String> credentialsList = new ArrayList<String>();
		
		assertEquals(credentialsList.size(), newManager.listOfSystemNames().size());
	}
	
	@Test
	void testListOfSystemNamesWithOneCredential() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			
		ArrayList<String> credentialsList = new ArrayList<String>();
			credentialsList.add(newCredential.getSystemName());
		
		assertEquals(credentialsList, newManager.listOfSystemNames());
	}
	
	@Test
	void testListOfSystemNamesWithMultipleCredentials() {
		Credential newCredential = new Credential();
			newCredential.setSystemName("facebook");
			newCredential.setUserName("vitor");
			newCredential.setPassword("123456789");
			
		Credential newCredentialTwo = new Credential();
			newCredentialTwo.setSystemName("whatsapp");
			newCredentialTwo.setUserName("hugo");
			newCredentialTwo.setPassword("987654321");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			newManager.addCredential(newCredentialTwo);
			
		ArrayList<String> credentialsList = new ArrayList<String>();
			credentialsList.add(newCredential.getSystemName());
			credentialsList.add(newCredentialTwo.getSystemName());
		
		assertEquals(credentialsList, newManager.listOfSystemNames());
	}
}
