package com.example.wishlist.model;
import java.sql.Date;
import java.util.List;


public class Wishlist {
private List<Wish> wishes;
private List<Wishlist> wishlists;
private int id;
private String name;
private Date creationDate;

    public Wishlist() {

    }

    public List<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(List<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    public List<Wish> getWishes() {
        return wishes;
    }
    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

