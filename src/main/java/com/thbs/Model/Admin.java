package com.thbs.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
    @Id
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(int admin_id, String username, String password) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
