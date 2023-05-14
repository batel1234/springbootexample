package com.javatpoint.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Apartment { //דירות
    @Id
    @GeneratedValue
    private Long id;//מספר מזהה

    private String name;//שם הדירה
    private String description;//תאור הדירה
    private int price;//מחיר הדירה
    private String attractions;// אטרקציות
    private String img; // תמונה
    private boolean status; //פנוי או תפוס
    @JsonIgnore
    @ManyToOne
    private Category categoryId; // הרבה דירות בקטגוריה אחת

    @JsonIgnore
    @OneToMany(mappedBy = "apartment")// לפי הדירה
    private List<Renting> rentings; // הרבה השכרות לדירה אחת- רשימת השכרות לדירה

    public Apartment(Long id, String name, String description, int price, String attractions, String img, boolean status, Category categoryId, List<Renting> rentings) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.attractions = attractions;
        this.img = img;
        this.status = status;
        this.categoryId = categoryId;
        this.rentings = rentings;
    }

    public Apartment() {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAttractions() {
        return attractions;
    }

    public void setAttractions(String attractions) {
        this.attractions = attractions;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public List<Renting> getRentings() {
        return rentings;
    }

    public void setRentings(List<Renting> rentings) {
        this.rentings = rentings;
    }
}
