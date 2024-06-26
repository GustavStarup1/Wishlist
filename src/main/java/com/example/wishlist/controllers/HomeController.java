package com.example.wishlist.controllers;
import com.example.wishlist.model.User;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.UserService;
import com.example.wishlist.service.WishListService;
import jakarta.servlet.http.HttpSession;
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
    private UserService userService;

    /*@GetMapping("/")
    public String login(Model model) {
        model.addAttribute("user", userService);
        return "home/login";
    }*/

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("user", user);
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/index";
    }

    public static void main(String[] args) {
        SpringApplication.run(Wishlist.class, args);
    }
}