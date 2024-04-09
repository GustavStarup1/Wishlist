package com.example.wishlist.service;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishRepository wishRepository;

   public List<Wish> getAllWishes() {
        return wishRepository.getAllWishes();
    }

    public Wish getWish(int id) {
        return wishRepository.getWish(id);
    }

    public void delete(int id) {
        wishRepository.deleteWish(id);
    }

    public void create(String text, boolean isBought) {
        wishRepository.createWish(text, isBought);
    }

    public void update(int id, String text, boolean isBought) {
        wishRepository.updateWish(id, text, isBought);
    }
}

