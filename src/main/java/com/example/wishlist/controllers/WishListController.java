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

// shows all wishes
    @GetMapping("/show")
    public String showAllWishes(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        model.addAttribute("wishes", wishes);
        return "home/showallwishes";
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

