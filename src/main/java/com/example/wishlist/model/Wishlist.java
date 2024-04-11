package com.example.wishlist.model;
import java.util.ArrayList;
import java.util.List;


public class Wishlist {
private List<Wish> wishes;

    public Wishlist() {
    }

    public List<Wish> getWishes() {
        return wishes;
    }
    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishes=" + wishes +
                '}';
    }
}

