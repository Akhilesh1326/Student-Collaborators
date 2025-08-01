package com.example.user_management_service.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "basic_information_table")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy =  "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(updatable = false, nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String googleId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private String profilePictureUrl;

    private String collegeName;

    @Column
    private Integer year;

    @Column
    private String department;

    @Column
    private String state;

    @Column String city;
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return this.username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleId() {
        return this.googleId;
    }
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


    public String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }
    public void setProfilePictureUrl(String PPURL) {
        this.profilePictureUrl = PPURL;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public String getCollegeName() {
        return this.collegeName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setYear(Integer year){
        this.year = year;
    }
    public Integer getYear(){
        return this.year;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return this.department;
    }


    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
}
