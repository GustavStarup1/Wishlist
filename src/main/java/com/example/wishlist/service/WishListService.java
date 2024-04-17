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
    public List<Wishlist> getAllWishlistsByUserId(int id) {
        return wishlistRepository.getAllWishlistsByUserId(id);
    }

    public Wishlist getWish(int id) {
        return wishlistRepository.getWishlist(id);
    }

    public void deleteWishlist(int id) {
        wishlistRepository.deleteWishlist(id);
    }

    public void create(String text, int id) {
        wishlistRepository.createWishlist(text, id);
    }

    public void update(int id, String name) {
        wishlistRepository.updateWishlist(id, name);
    }

    public Wishlist prepareUpdate(int id) {
       return wishlistRepository.getWishlist(id);
    }
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.getAllWishlists();
    }

    public Wishlist getWishlist(int id) {
       return wishlistRepository.getWishlist(id);
    }


}

