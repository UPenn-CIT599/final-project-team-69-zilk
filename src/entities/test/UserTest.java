package src.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
	
	User u1 = new User(2,"name","pw");
	
	@Test
	void testUser() {
		assertEquals(u1.userID, 2);
	}

	@Test
	void testSetPassword() {
		
		u1.setPassword("pw2")
		assertEquals(u1.password);
	}

	@Test
	void testSetName() {
		
		u1.setName("name2")
		assertEquals(u1.username,"name2");
	}

	@Test
	void testGetPassword() {
		
		assertEquals(u1.getPassword(),"pw2";
	}

	@Test
	void testGetUsername() {
		
		assertEquals(u1.getUsername(),"name2");
	}

	@Test
	void testGetUserID() {
		
		assertEquals(u1.getUserID(), 2);
	}

}
