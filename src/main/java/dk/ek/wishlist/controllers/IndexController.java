package dk.ek.wishlist.controllers;

import dk.ek.wishlist.models.Product;
import dk.ek.wishlist.services.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class IndexController {
    private final IndexService service;

    public IndexController(IndexService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<Product> products = service.getAllProducts();
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/item")
    public ModelAndView product(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("item");
        Product item = service.getProductMatch(id);
        mav.addObject("item",item);
        return mav;
    }
}