package dk.ek.wishlist.controllers;

import dk.ek.wishlist.models.Product;
import dk.ek.wishlist.models.User;
import dk.ek.wishlist.services.IndexService;
import dk.ek.wishlist.services.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;
    private final IndexService indexService;

    public WishlistController(WishlistService wishlistService, IndexService indexService) {
        this.wishlistService = wishlistService;
        this.indexService = indexService;
    }

    @GetMapping("/wishlists")
    public ModelAndView wishlists() {
        ModelAndView mav = new ModelAndView("wishlists");

        // Fetch wishlists with their items
        List<WishlistService.WishlistWithItems> wishlists = wishlistService.getAllWishlistsWithItems();
        mav.addObject("wishlists", wishlists);

        // Fetch all products for dropdown
        List<Product> products = indexService.getAllProducts();
        mav.addObject("products", products);

        return mav;
    }

    @PostMapping("/wishlists/create")
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            wishlistService.createWishlist(user.getId(), name, description);
        }
        return "redirect:/wishlists";
    }

    @PostMapping("/wishlist/add")
    public String addProduct(@RequestParam long wishlistId,
                             @RequestParam long productId) {
        wishlistService.addProduct(wishlistId, productId);
        return "redirect:/wishlists";
    }

    @PostMapping("/reserve")
    public String reserve(@RequestParam long itemId,
                          HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            wishlistService.reserve(itemId, user.getId());
        }
        return "redirect:/wishlists";
    }
}