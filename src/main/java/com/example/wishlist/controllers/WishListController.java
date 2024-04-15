package com.example.wishlist.controllers;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishListService;
import com.example.wishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishlistService;
    @Autowired
    private WishService wishService;

    /*viser alle ønsker lister*/
    @GetMapping("/")
    public String showWishlists(Model model) {
        List<Wishlist> wishlists = wishlistService.getAllWishlists();
        model.addAttribute("wishlists", wishlists);
        return "home/wishlists";
    }

// shows all wishes
    @GetMapping("/show")
    public String showAllWishes(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/showallwishes";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("wish", wishlistService.getWish(id));
        return "home/confirm_delete_wish";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/index";
    }

    @GetMapping("/new")
    public String insert(){
        return "home/new";
    }
    @PostMapping("/insert")
    public String insert(@RequestParam String name ) {
        wishlistService.create(name);
        return "redirect:/wishlist/";
    }

     @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String name){
        wishlistService.update(name);
        return "redirect:/index";
    }

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int id, Model model) {
        model.addAttribute(wishlistService.prepareUpdate(id));
        return "home/update";
    }

    /*viser valgt wishlist*/
    @GetMapping("/{id}")
    public String wishlist(@PathVariable("id") int id, Model model) {
        model.addAttribute(wishlistService.getWishlist(id));
        List<Wish> wishes = wishService.getWishesByWishListId(id);
        model.addAttribute("wishes", wishes);
        return "home/wishlist";
    }
}

