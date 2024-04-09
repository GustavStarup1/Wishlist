package com.example.wishlist.controllers;
import com.example.wishlist.model.Wish;
import com.example.wishlist.service.WishListService;
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

    @GetMapping("")
    public String showWishlist(Model model) {
        model.addAttribute("wishes", wishlistService.getWishes());
        return "wishlist/index";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("wish", wishlistService.getWish(id));
        return "wishlist/confirm_delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        wishlistService.delete(id);
        return "redirect:/wishlist";
    }

    @GetMapping("/new")
    public String showCreateForm() {
        return "wishlist/new";
    }

    @PostMapping("/new")
    public String create(@RequestParam("text") String text) {
        wishlistService.create(text);
        return "redirect:/wishlist";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("wish", wishlistService.getWish(id));
        return "wishlist/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestParam("text") String newText) {
        wishlistService.update(id, newText);
        return "redirect:/wishlist";
    }

    @GetMapping("/markAsBought/{id}")
    public String markAsBought(@PathVariable("id") int id) {
        wishlistService.markAsBought(id);
        return "redirect:/wishlist";
    }
    @GetMapping("")
    public String getWishes(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "wishlist";
    }

}

