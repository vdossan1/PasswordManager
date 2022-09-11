package edu.westga.cs1302.password_manager.test.credentialManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;

class TestUpdateCredential {

	@Test
	void testUpdateCredentialWithEmptyList() {
		
		CredentialManager newManager = new CredentialManager();
			
		assertThrows(IllegalStateException.class, () -> {
			newManager.updateCredential("facebook", "vitor", "123456");
		});
	}
	
	@Test
	void testUpdateCredentialWithNullSystemName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential(null, "vitor", "123456");
		});
	}
	
	@Test
	void testUpdateCredentialWithEmptySystemName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential("", "vitor", "123456");
		});
	}
	
	@Test
	void testUpdateCredentialWithNullUserName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential("facebook", null, "123456");
		});
	}
	
	@Test
	void testUpdateCredentialWithEmptyUserName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential("facebook", "", "123456");
		});
	}
	
	@Test
	void testUpdateCredentialWithNullPassword() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential("facebook", "vitor", null);
		});
	}
	
	@Test
	void testUpdateCredentialWithEmptyPassword() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newManager.updateCredential("facebook", "vitor", "");
		});
	}
	
	@Test
	void testUpdateCredentialWithOneCredentialUpdateName() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		String systemName = newCredential.getSystemName();
		String newUserName = "hugo";
		String newPassword = "123456789";
			
		newManager.updateCredential(systemName, newUserName, newPassword);
		
		assertEquals(newUserName, newManager.getCredentialWithSpecifiedName(systemName).getUserName());
	}
	
	@Test
	void testUpdateCredentialWithOneCredentialUpdatePassword() {
		Credential newCredential = new Credential(
				"facebook",
				"vitor",
				"123456789");
		
		CredentialManager newManager = new CredentialManager();
			newManager.addCredential(newCredential);
		
		String systemName = newCredential.getSystemName();
		String newUserName = "vitor";
		String newPassword = "hudsauhdasa";
			
		newManager.updateCredential(systemName, newUserName, newPassword);
		
		assertEquals(newPassword, newManager.getCredentialWithSpecifiedName(systemName).getPassword());
	}
	
	@Test
	void testUpdateCredentialWithMultipleCredentialsUpdateNameSecondCredential() {
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
		
		String systemName = newCredentialTwo.getSystemName();
		String newUserName = "santos";
		String newPassword = "123456789";
			
		newManager.updateCredential(systemName, newUserName, newPassword);
		
		assertEquals(newUserName, newManager.getCredentialWithSpecifiedName(systemName).getUserName());
	}
	
	@Test
	void testUpdateCredentialWithMultipleCredentialsUpdatePassowrdSecondCredential() {
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
		
		String systemName = newCredentialTwo.getSystemName();
		String newUserName = "hugo";
		String newPassword = "123456sad";
			
		newManager.updateCredential(systemName, newUserName, newPassword);
		
		assertEquals(newPassword, newManager.getCredentialWithSpecifiedName(systemName).getPassword());
	}

}
