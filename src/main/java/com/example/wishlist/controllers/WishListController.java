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

    @GetMapping("/showWishlist")
    public String showWishlist(Model model) {
        model.addAttribute("wishes", wishlistService.getAllWishes());
        return "wishlist/index";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("wish", wishlistService.getWish(id));
        return "index/confirm_delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/index";
    }

    @GetMapping("/new")
    public String showCreateForm() {
        return "index/new";
    }

    @PostMapping("/new")
    public String create(@RequestParam("text") String text) {
        wishlistService.create(text);
        return "redirect:/index";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("name") String name){
        wishlistService.update(name);
        return "redirect:/index";
    }

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int id, Model model) {
        model.addAttribute(wishlistService.prepareUpdate(id));
        return "index/update";
    }


    @GetMapping("/getwishes")
    public String getWishes(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/index";
    }
}

