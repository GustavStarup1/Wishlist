package com.example.wishlist.controllers;
import com.example.wishlist.model.Wish;
import com.example.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishlistService;

// shows wishes in wishlist
    @GetMapping("/show")
    public String showWishlist(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/wishlist";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("wish", wishlistService.getWish(id));
        return "home/confirm_delete";
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
        return "redirect:/";
    }


    /* @PostMapping("/update/{id}")
    public String update(@PathVariable("name") String name){
        wishlistService.update(name);
        return "redirect:/index";
    }*/

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int id, Model model) {
        model.addAttribute(wishlistService.prepareUpdate(id));
        return "home/update";
    }
}

