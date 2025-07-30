package com.example.user_management_service.DTO;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserRegisterDTO {

    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String googleId;

    private String profilePictureUrl;

    private String collegeName;

    private Integer year;

    private String department;

    private String state;

    private String city;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGoogleId() {
        return googleId;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public Integer getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
