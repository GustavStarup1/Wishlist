package com.example.wishlist.model;


    public class Wish {
        private int id;
        private int wishlistId;
        private String name;
        private String text;
        private double price;
        private String link;
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

        public String getIsReservedByUserId() {
            return isReservedByUserId;
        }

        public void setIsReservedByUserId(String isReservedByUserId) {
            this.isReservedByUserId = isReservedByUserId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getWishlistId() {
            return wishlistId;
        }

        public void setWishlistId(int wishlistId) {
            this.wishlistId = wishlistId;
        }

        @Override
        public String toString() {
            return "Wish{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", text='" + text + '\'' +
                    ", isBought=" + isBought +
                    ", isReservedByUserId='" + isReservedByUserId + '\'' +
                    '}';
        }
    }

