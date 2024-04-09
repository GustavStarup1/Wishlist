package com.example.wishlist.controllers;
import com.example.wishlist.model.Wish;
import com.example.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Wish> wishes = wishlistService.getWishes();
        model.addAttribute("wishes", wishes);
        return "wishlist";

    }
}