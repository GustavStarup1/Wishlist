package com.example.wishlist.model;
import java.util.ArrayList;
import java.util.List;


public class Wishlist {
private List<Wish> wishes;

    public Wishlist() {
    }

    public Wishlist(List<Wish> wishes) {
        wishes = new ArrayList<>();
    }
    public List<Wish> getWishes() {
        return wishes;
    }
    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

}

