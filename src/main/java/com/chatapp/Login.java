package com.chatapp;

import java.util.regex.Pattern;

/**
 * Class Login Part of the Package com.chatapp
 */
public class Login {

    // Using final ensures these values cannot be changed after the object is created
    private final String username;
    private final String password;
    private final String phoneNumber;

    /**
     * Constructor Details: Login
     *
     * @param username the user's chosen name
     * @param password the user's secret credential
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param phoneNumber the user's international contact number
     */
    public Login(String username, String password, String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method Details: checkUserName
     *
     * @return boolean - true if username contains '_' and length {@code <=} 5
     */
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Method Details: checkPasswordComplexity
     *
     * @return boolean - true if password meets complexity requirements
     */
    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        return java.util.regex.Pattern.compile(regex).matcher(this.password).matches();
    }

    /**
     * Method Details: checkCellPhoneNumber
     *
     * @return boolean - true if phone number follows international format
     */
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        return Pattern.compile(regex).matcher(this.phoneNumber).matches();
    }

    /**
     * Method Details: registerUser
     *
     * @return String - status message indicating success or specific formatting
     * error
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Username, Password and Cell phone number successfully captured.";
    }

    /**
     * Method Details: loginUser
     *
     * @param enteredUser the username provided at login
     * @param enteredPass the password provided at login
     * @return boolean - true if credentials match stored data
     */
    public boolean loginUser(String enteredUser, String enteredPass) {
        return this.username.equals(enteredUser) && this.password.equals(enteredPass);
    }

    /**
     * Method Details: returnLoginStatus
     *
     * @param isLoggedIn status of the login attempt
     * @param firstName user's first name for greeting
     * @param lastName user's last name for greeting
     * @return String - personalized welcome message or error message
     */
    public String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
