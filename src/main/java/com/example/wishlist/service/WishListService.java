package com.example.wishlist.service;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishlistRepository;

   public List<Wish> getAllWishes() {
        return wishlistRepository.getAllWishes();
    }

    public Wishlist getWish(int id) {
        return wishlistRepository.getWishlist(id);
    }

    public void deleteWishlist(int id) {
        wishlistRepository.deleteWishlist(id);
    }

    public void create(String text) {
        wishlistRepository.createWishlist(text);
    }

    public void update(String name) {
        wishlistRepository.updateWishlist(name);
    }

    public Object prepareUpdate(int id) {
       return wishlistRepository.getWishlist(id);
    }
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.getAllWishlists();
    }

    public Object getWishlist(int id) {
       return wishlistRepository.getWishlist(id);
    }


}

