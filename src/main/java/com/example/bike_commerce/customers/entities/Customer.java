package com.example.bike_commerce.customers.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="service_user")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "date_created")
    private Date date_created;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String user_role;

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_role() {
        return user_role;
    }

    public Date getDateCreated() {
        return date_created;
    }

    // === SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_role(String role) {
        this.user_role = role;
    }

    public void setDateCreated(Date dateCreated) {
        this.date_created = dateCreated;
    }
}