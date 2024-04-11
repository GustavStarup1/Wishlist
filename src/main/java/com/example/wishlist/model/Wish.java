package com.example.wishlist.model;


    public class Wish {
        private int id;
        private String name;
        private String text;
        private boolean isBought;
        private String isReservedByUserId;

        public Wish() {
        }

        public Wish(int id, String name, String text, boolean isBought, String isReservedByUserId) {
            this.id = id;
            this.name = name;
            this.text = text;
            this.isBought = isBought;
            this.isReservedByUserId = isReservedByUserId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getIsReservedByUserId() {
            return isReservedByUserId;
        }

        public void setIsReservedByUserId(String isReservedByUserId) {
            this.isReservedByUserId = isReservedByUserId;
        }
    }

