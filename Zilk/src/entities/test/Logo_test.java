package src.entities.test;

import src.entities.Logo;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**
 * This is the unit test part for Logo.
 **/
class LogoTest {

	@Test
	void testCanOutputLogo() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		Logo.genLogo();
		assertNotNull(os.toString());
	}
}
