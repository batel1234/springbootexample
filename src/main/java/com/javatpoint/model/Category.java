package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category { //קטגורית ערים
    @Id
    @GeneratedValue
    private Long id; //מספר מזהה
    private String city; // הקטוגוריות- עיר
    @JsonIgnore
    @OneToMany(mappedBy = "categoryId")
    private List<Apartment> apartments; // קטגוריה אחת להרבה דירות

    public Category(Long id, String city, List<Apartment> apartments) {
        this.id = id;
        this.city = city;
        this.apartments = apartments;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}