package src.entities.test;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import src.entities.NormalUser;

/**
 * This is the unit test part for Normal User.
 **/

class NormalUserTest {

	private int userID = 1;
	private String username = "test name";
	private String password = "test password";
	private NormalUser user;

	private void resetUser() {
		this.user = new NormalUser(this.userID, this.username, this.password);
	}

	@Test
	void testClassIsCorrect() {
		this.resetUser();
		assertTrue(this.user.getClass().equals(NormalUser.class));
	}

	@Test
	void testCanGetUserID() {
		this.resetUser();
		assertEquals(user.getUserID(), this.userID);
	}

	@Test
	void testCanGetName() {
		this.resetUser();
		assertEquals(user.getUsername(), this.username);
	}

	@Test
	void testCanGetPassword() {
		this.resetUser();
		assertEquals(user.getPassword(), this.password);
	}

	@Test
	void testCanSetUserName() {
		this.resetUser();
		String testName = "new name";
		this.user.setName(testName);
		assertEquals(this.user.getUsername(), testName);
	}

	@Test
	void testCanSetUserPassword() {
		this.resetUser();
		String testPassword = "new password";
		user.setPassword(testPassword);
		assertEquals(user.getPassword(), testPassword);
	}

}
