package com.chatapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testCheckUserName() {
        Login login = new Login("kyl_1", "P@ss123", "Kyle", "Doe");
        assertTrue(login.checkUserName(), "Valid username should return true");
        
        Login invalid = new Login("kyle!!!!!!!", "P@ss123", "Kyle", "Doe");
        assertFalse(invalid.checkUserName(), "Invalid username should return false");
    }
}