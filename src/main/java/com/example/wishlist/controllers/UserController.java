package com.example.wishlist.controllers;

import com.example.wishlist.model.User;
import com.example.wishlist.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
   @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    @PostMapping("/authorize_login")
    public String authorizeLogin(HttpSession session, @RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username,password);
        System.out.println(user);

        session.setAttribute("user", user);
        return "redirect:/wishlist/";

        /*if (user!=null) {
            session.setAttribute("user", user);
            return "redirect:/wishlist/";
        } else {
            model.addAttribute("user", null);
            return "home/index";
        }*/
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }
}
