package com.chatapp;

public class Login {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
