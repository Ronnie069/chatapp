package com.chatapp;

import java.util.regex.Pattern;

public class Login {

    private final String username;
    private final String password;
    private String phoneNumber;

    public Login(String username, String password, String firstName, String lastName, String string) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        // Regex explanation: 
        // (?=.*[A-Z]) -> at least one uppercase
        // (?=.*[0-9]) -> at least one digit
        // (?=.*[!@#$%^&*]) -> at least one special char
        // .{8,} -> at least 8 characters long
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        return java.util.regex.Pattern.compile(regex).matcher(this.password).matches();
    }

    public boolean checkCellPhoneNumber() {
        // PoE Requirement: International code (+) and length check
        String regex = "^\\+\\d{1,3}\\d{9,10}$";
        return Pattern.compile(regex).matcher(this.phoneNumber).matches();
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is notcorrectly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Username, Password and Cell phone number successfully captured.";
    }
}
