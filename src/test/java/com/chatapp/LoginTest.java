package com.chatapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Login class. Verifies username formatting, password
 * complexity, phone number validation, and login logic.
 */
public class LoginTest {

    /**
     * Tests the checkUserName method. Validates that usernames containing an
     * underscore and under 5 characters return true, while overly long or
     * poorly formatted usernames return false.
     */
    @Test
    public void testCheckUserName() {
        Login login = new Login("kyl_1", "P@ss123", "Kyle", "Doe", "+27838968976");
        assertTrue(login.checkUserName());

        Login invalid = new Login("kyle!!!!!!!", "P@ss123", "Kyle", "Doe", "+27838968976");
        assertFalse(invalid.checkUserName());

        System.out.println("testCheckUserName passed successfully.");
    }

    /**
     * Tests the checkPasswordComplexity method. Ensures passwords with mixed
     * case, numbers, and special characters pass, while simple strings return
     * false.
     */
    @Test
    public void testPasswordComplexity() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkPasswordComplexity());

        Login invalid = new Login("kyl_1", "password", "Kyle", "Doe", "+27838968976");
        assertFalse(invalid.checkPasswordComplexity());

        System.out.println("testPasswordComplexity passed successfully.");
    }

    /**
     * Tests the checkCellPhoneNumber method. Confirms that international
     * formats starting with '+' are accepted, while local-only formats are
     * rejected.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkCellPhoneNumber());

        Login invalid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "08966553");
        assertFalse(invalid.checkCellPhoneNumber());

        System.out.println("testCheckCellPhoneNumber passed successfully.");
    }

    /**
     * Tests the registerUser method for specific error messages. Verifies that
     * the correct descriptive string is returned for each validation failure.
     */
    @Test
    public void testRegisterUserMessages() {
        // Test Case: Incorrect Username
        Login badUser = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", badUser.registerUser());

        // Test Case: Incorrect Password
        Login badPass = new Login("kyl_1", "password", "Kyle", "Doe", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", badPass.registerUser());

        System.out.println("testRegisterUserMessages passed successfully.");
    }

    /**
     * Tests the loginUser method. Validates that successful matching of stored
     * credentials returns true.
     */
    @Test
    public void testLoginUser() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));

        System.out.println("testLoginUser passed successfully.");
    }
}
