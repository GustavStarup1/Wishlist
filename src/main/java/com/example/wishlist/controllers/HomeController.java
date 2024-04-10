package com.example.wishlist.controllers;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private WishListService wishlistService;

    @GetMapping("/")
    public String index(Model model) {
        List<Wishlist> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/wishlist";
    }

    public static void main(String[] args) {
        SpringApplication.run(Wishlist.class, args);
    }
}