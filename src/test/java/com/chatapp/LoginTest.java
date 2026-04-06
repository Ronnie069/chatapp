package com.chatapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testCheckUserName() {
        Login login = new Login("kyl_1", "P@ss123", "Kyle", "Doe");
        assertTrue(login.checkUserName(), "Valid username should return true");
        
        Login invalid = new Login("kyle!!!!!!!", "P@ss123", "Kyle", "Doe");
        assertFalse(invalid.checkUserName(), "Invalid username should return false");
    }

    @Test
    public void testPasswordComplexity() {
        // Valid Password from PoE data
        Login valid = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Doe");
        assertTrue(valid.checkPasswordComplexity());

        // Invalid Password (too simple)
        Login invalid = new Login("kyl_1", "password", "Kyle", "Doe");
        assertFalse(invalid.checkPasswordComplexity());
    }
}