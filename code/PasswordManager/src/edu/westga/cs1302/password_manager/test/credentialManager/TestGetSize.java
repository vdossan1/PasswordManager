package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestGetSize {

	@Test
	void testGetSizeEmptyList() {
		
		CredentialManager newManager = new CredentialManager();
		
		ArrayList<Credential> testList = new ArrayList<Credential>();
		
		assertEquals(newManager.getSize(), testList.size());	
	}
	
	@Test
	void testGetSizeOneCredential() {
		
		
		Credential newCredential = new Credential("facebook", "vitor", "123456");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
			
		ArrayList<Credential> testList = new ArrayList<Credential>();
			testList.add(newCredential);
		
		assertEquals(newManager.getSize(), testList.size());	
	}

}
