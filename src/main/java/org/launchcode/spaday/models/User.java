package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 15, message="Username must be between 5 and 15 characters long")
    private String username;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please enter a valid email address.")
    private String email;

    @NotBlank(message = "Please enter a password")
    private String password;

    public User() {
        id = nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

