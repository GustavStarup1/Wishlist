package com.example.wishlist.service;
import com.example.wishlist.model.Wish;
import com.example.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {
    @Autowired
    WishRepository wishRepository;

    public Wish getWish(int id) {
        return wishRepository.getWish(id);
    }

    public void delete(int id) {
        wishRepository.delete(id);
    }

    public void createWish(int wishlistId, String name, String wishText, double price, String link, boolean isBought, String isReservedByUserId) {
        wishRepository.createWish(wishlistId, name, wishText, price, link, isBought, isReservedByUserId);
    }

    public void updateWish(int id, boolean isBought, String text){
        wishRepository.updateWish(id, text, isBought);
    }

    public Wish prepareWish(int id) {
        return wishRepository.getWish(id);
    }
    public void markAsBought(int id){
         wishRepository.markAsBought(id);
    }

}
