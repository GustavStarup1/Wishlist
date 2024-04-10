package com.example.wishlist.controllers;
import com.example.wishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishController {
    @Autowired

    private WishService wishService;
    @GetMapping("/confirm_delete")
    public String confirmDelete(@RequestParam int id, Model model){
        model.addAttribute(wishService.getWish(id));
        return "wishlist/confirm_delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam ("id") int id) {
        wishService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/new")
    public String insert() {
        return "wishlist/new";
    }
    @PostMapping("/insert")
    public String insert(@RequestParam int wishlistId, @RequestParam String name, @RequestParam String wishText, @RequestParam double price, @RequestParam String link, @RequestParam boolean isBought, @RequestParam String isReservedByUserId) {
        wishService.createWish(wishlistId, name, wishText, price, link, isBought,isReservedByUserId);
        return "redirect:/";
    }
    @GetMapping("/Prepare_update")
    public String prepareWish(@RequestParam int id, Model model){
        model.addAttribute(wishService.prepareWish(id));
        return "wishlist/update";
    }
    @PostMapping("/update")
    public String update(@RequestParam int id, @RequestParam boolean isBought, @RequestParam String text ) {
       wishService.updateWish(id, isBought, text);
       return "redirect:/";
    }
    @GetMapping("/markAsBought/{id}")
    public String markAsBought(@PathVariable("id") int id) {
        wishService.markAsBought(id);
        return "redirect:/wishlist";
    }




}
