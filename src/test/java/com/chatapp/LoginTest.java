package com.chatapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login login = new Login("kyl_1", "P@ss123", "Kyle", "Doe", "+27838968976");
        assertTrue(login.checkUserName());

        Login invalid = new Login("kyle!!!!!!!", "P@ss123", "Kyle", "Doe", "+27838968976");
        assertFalse(invalid.checkUserName());
    }

    @Test
    public void testPasswordComplexity() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkPasswordComplexity());

        Login invalid = new Login("kyl_1", "password", "Kyle", "Doe", "+27838968976");
        assertFalse(invalid.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkCellPhoneNumber());

        Login invalid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "08966553");
        assertFalse(invalid.checkCellPhoneNumber());
    }

    // MANDATORY assertEquals TESTS FROM POE TABLE [cite: 101, 106]
    @Test
    public void testRegisterUserMessages() {
        // Test Case: Incorrect Username [cite: 101]
        Login badUser = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", badUser.registerUser());

        // Test Case: Incorrect Password [cite: 106]
        Login badPass = new Login("kyl_1", "password", "Kyle", "Doe", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", badPass.registerUser());
    }

    @Test
    public void testLoginUser() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));
    }
}