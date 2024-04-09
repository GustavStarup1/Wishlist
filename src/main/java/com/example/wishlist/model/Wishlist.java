package com.example.wishlist.model;

public class Wishlist {
        private Long id;
        private String text;
        private boolean isBought;

    public Wishlist(Long id, String text, boolean isBought) {
        this.id = id;
        this.text = text;
        this.isBought = isBought;
    }

    public Wishlist(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }
}

