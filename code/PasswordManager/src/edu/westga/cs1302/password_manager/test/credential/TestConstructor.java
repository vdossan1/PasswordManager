package edu.westga.cs1302.password_manager.test.credential;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_manager.model.Credential;

class TestConstructor {

	@Test
	void testConstructorNullSystemName() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential(null, "name", "password");
		});
	}
	
	@Test
	void testConstructorEmptySystemName() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential("", "name", "password");
		});
	}
	
	@Test
	void testConstructorNullUserName() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential("systemName", null, "password");
		});
	}
	
	@Test
	void testConstructorEmptyUserName() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential("systemName", "", "password");
		});
	}
	
	@Test
	void testConstructorNullPassword() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential("systemName", "name", null);
		});
	}
	
	@Test
	void testConstructorEmptyPassword() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			new Credential("systemname", "name", "");
		});
	}
	
	@Test
	void testConstructorValidParameters() {
		Credential newCredential = new Credential("systemname", "userName", "password");
		
		assertEquals("systemname", newCredential.getSystemName());
		assertEquals("userName", newCredential.getUserName());
		assertEquals("password", newCredential.getPassword());
	}

}
