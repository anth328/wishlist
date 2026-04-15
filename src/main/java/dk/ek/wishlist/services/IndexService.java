package dk.ek.wishlist.services;

import dk.ek.wishlist.models.Product;
import dk.ek.wishlist.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class IndexService {
    private final ProductRepository repo;

    public IndexService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductMatch(int id) {
        for (Product p : repo.findAll()) {
            if (p.getId()==id) {
                return p;
            }
        }
        return null;
    }

    public Product createProduct(String name, String description, int price,
                                 String url, String iurl) {

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String fs = localDate.format(formatter);

        int count = 1;
        for (Product p : repo.findAll()) {
            count++;
        }
        Product p = new Product(count, name, description, price, url, iurl, fs);
        return p;
    }
}
