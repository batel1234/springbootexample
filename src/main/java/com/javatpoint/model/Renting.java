package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Renting {//השכרה
    @Id
    @GeneratedValue
    private Long id;// מספר מזהה
    @JsonIgnore
    @ManyToOne
    private User userId;// הרבה השכרות למשתמש אחד
    @JsonIgnore
    @ManyToOne
    private Apartment apartment; // הרבה השכרות לדירה אחת
    public Renting(Long id, User userId, Apartment apartment) {
        this.id = id;
        this.userId = userId;
        this.apartment = apartment;
    }

    public Renting() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
