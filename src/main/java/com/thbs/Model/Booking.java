package com.thbs.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Booking
{
    private String name;
    private String restolist;
    @Id
    private String email;
    private int phone;
    private Date date;
    private int noofpeople;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRestolist() {
        return restolist;
    }
    public void setRestolist(String restolist) {
        this.restolist = restolist;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNoofpeople() {
        return noofpeople;
    }
    public void setNoofpeople(int noofpeople) {
        this.noofpeople = noofpeople;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", restolist='" + restolist + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", date=" + date +
                ", noofpeople=" + noofpeople +
                '}';
    }
}
