package dk.ek.wishlist.controllers;

import dk.ek.wishlist.models.Product;
import dk.ek.wishlist.services.IndexService;
import dk.ek.wishlist.repositories.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    private final IndexService service;
    private final ProductRepository repo;

    public IndexController(IndexService service, ProductRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession session) {
        ModelAndView mav = new ModelAndView("index");

        Object user = session.getAttribute("user");
        mav.addObject("user", user);

        return mav;
    }

    @GetMapping("/products")
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView("products");
        List<Product> products = service.getAllProducts();
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/products/item")
    public ModelAndView product(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("item");
        Product item = service.getProductMatch(id);
        mav.addObject("item",item);
        return mav;
    }

    @GetMapping("/products/create")
    public ModelAndView createProduct() {
        ModelAndView mav = new ModelAndView("editorcreate");
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute Product product) {

        Product newProduct = service.createProduct(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getUrl(),
                product.getImage_url()
        );

        repo.addProduct(newProduct);

        return "redirect:/products";
    }
}