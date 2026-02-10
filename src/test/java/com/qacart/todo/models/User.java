package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL) //to prevent null values to be sent in the body of the request
public class User { //POJO class for the user

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonProperty("access_token")
    private String accessToken;

    private String userID;

    public User() //for deSerial
    {
    }

    public User(String email_, String password_) { //FOR LOGIN
        this.email = email_;
        this.password = password_;
    }

    public User(String firstName_, String lastName_, String email_, String password_) // For Register
    {
        this.firstName = firstName_;
        this.lastName = lastName_;
        this.email = email_;
        this.password = password_;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String access_token) {
        this.accessToken = access_token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
