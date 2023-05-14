package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User { // משתמש
    @Id
    @GeneratedValue
    private Long id; //מספר מזהה

    private String tz;// תעודת זהות
    private String name; // שם
    private String phone;//טלפון
    private String mail;// מייל
    private String status;// האם הוא מנהל או משתמש
    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<Renting> rentings;//למשתמש אחד יש הרבה השכרות

    public User(Long id, String tz, String name, String phone, String mail, String status, List<Renting> rentings) {
        this.id = id;
        this.tz = tz;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.rentings = rentings;
    }

    public User() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Renting> getRentings() {
        return rentings;
    }

    public void setRentings(List<Renting> rentings) {
        this.rentings = rentings;
    }
}
