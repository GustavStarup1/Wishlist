package com.example.wishlist.model;


    public class Wish {
        private int id;
        private String text;
        private boolean isBought;


        public Wish(int id, String text, boolean isBought) {
            this.id = id;
            this.text = text;
            this.isBought = isBought;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

