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
        
        System.out.println("testCheckUserName passed successfully.");
    }

    @Test
    public void testPasswordComplexity() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkPasswordComplexity());

        Login invalid = new Login("kyl_1", "password", "Kyle", "Doe", "+27838968976");
        assertFalse(invalid.checkPasswordComplexity());
        
        System.out.println("testPasswordComplexity passed successfully.");
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(valid.checkCellPhoneNumber());

        Login invalid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "08966553");
        assertFalse(invalid.checkCellPhoneNumber());
        
        System.out.println("testCheckCellPhoneNumber passed successfully.");
    }

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

    @Test
    public void testLoginUser() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));
        
        System.out.println("testLoginUser passed successfully.");
    }
}