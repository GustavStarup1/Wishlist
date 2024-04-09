package com.example.wishlist.model;

import java.util.ArrayList;

public class Wishlist {
private ArrayList<Wish> wishes;

    public Wishlist(ArrayList<Wish> wishes) {
        wishes= new ArrayList<>();
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
    }
}

