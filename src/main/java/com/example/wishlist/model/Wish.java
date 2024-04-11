package com.example.wishlist.model;


    public class Wish {
        private int id;
        private String name;
        private String text;
        private boolean isBought;
        private String isReserved;

        public Wish() {
        }

        public Wish(int id, String name, String text, boolean isBought, String isReserved) {
            this.id = id;
            this.name = name;
            this.text = text;
            this.isBought = isBought;
            this.isReserved = isReserved;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsReserved() {
            return isReserved;
        }

        public void setIsReserved(String isReserved) {
            this.isReserved = isReserved;
        }
    }

