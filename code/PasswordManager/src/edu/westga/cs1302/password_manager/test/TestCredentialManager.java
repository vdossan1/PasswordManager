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
