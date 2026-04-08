package dk.ek.wishlist.services;

import dk.ek.wishlist.models.Product;
import dk.ek.wishlist.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
}
