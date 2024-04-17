package com.example.wishlist.controllers;
import com.example.wishlist.model.User;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.service.WishListService;
import com.example.wishlist.service.WishService;
import jakarta.servlet.http.HttpSession;
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

    /*viser alle ønske lister*/
    @GetMapping("/")
    public String showWishlists(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        // session.invalidate(); Logud endpoint
        model.addAttribute("user",user);  // Kan bruges til at vise user på siden altså hvem der er logget ind
        List<Wishlist> wishlists = wishlistService.getAllWishlistsByUserId(user.getId());
        model.addAttribute("wishlists", wishlists);
        return "home/wishlists";
    }


    @GetMapping("/confirm_delete")
    public String confirmDelete(@RequestParam int id, Model model) {
        model.addAttribute("wishlist", wishlistService.getWishlist(id));
        return "home/confirm_delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/wishlist/";
    }

    @GetMapping("/new_wishlist")
    public String insert(){
        return "home/new_wishlist";
    }
    @PostMapping("/insert")
    public String insert(@RequestParam String name,HttpSession session ) {
        User user = (User)session.getAttribute("user");
        wishlistService.create(name, user.getId());
        return "redirect:/wishlist/";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestParam String name){
        wishlistService.update(id, name);
        return "redirect:/wishlist/";
    }

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int id, Model model) {
        model.addAttribute(wishlistService.prepareUpdate(id));
        return "home/prepare_update_wishlist";
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

