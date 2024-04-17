package com.example.wishlist.controllers;
import com.example.wishlist.model.Wish;
import com.example.wishlist.service.WishListService;
import com.example.wishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishlist/wish")
public class WishController {
    @Autowired
    private WishService wishService;

    @GetMapping("/confirm_delete")
    public String confirmDelete(@RequestParam int id, Model model){
        model.addAttribute(wishService.getWish(id));
        return "home/confirm_delete_wish";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam ("id") int id) {
        Wish wish = wishService.getWish(id);
        int wishlistId = wish.getWishlistId();
        wishService.delete(id);
        return "redirect:/wishlist/" + wishlistId; /*sender tilbage til ønskelisten man sletter ønske fra*/
    }

    @GetMapping("/{id}/new_wish")
    public String newWish(@PathVariable("id") int wishlistId, Model model){ /*modtager id'et fra wishlists viewet og sætter ind i modellem*/
        Wish wish = new Wish();
        wish.setWishlistId(wishlistId);
        model.addAttribute("wish", wish);
        return "home/new_wish";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam int wishlistId,@RequestParam String name, @RequestParam String text, @RequestParam double price, @RequestParam String link) {
        wishService.createWish(wishlistId, name, text, price, link);
        return "redirect:/wishlist/" + wishlistId;
    }

    @GetMapping("/Prepare_update")
    public String prepareWish(@RequestParam int id, Model model){
        model.addAttribute(wishService.prepareWish(id));
        return "home/prepare_update";
    }
    @PostMapping("/update")
    public String update(@RequestParam int id, @RequestParam boolean isBought, @RequestParam String text ) {
        System.out.println("IsBought: " + isBought);
        Wish wish = wishService.getWish(id);
        int wishlistId = wish.getWishlistId();
       wishService.updateWish(id, isBought, text);
       return "redirect:/wishlist/" + wishlistId;
    }
    @GetMapping("/markAsBought/{id}")
    public String markAsBought(@PathVariable("id") int id) {
        wishService.markAsBought(id);
        return "redirect:/index";
    }




}
