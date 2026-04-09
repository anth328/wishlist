package dk.ek.wishlist.services;

import dk.ek.wishlist.models.User;
import dk.ek.wishlist.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public void register(String username, String email, String password) {
        User user = new User(0, username, email, password);
        repo.save(user);
    }

    public User login(String username, String password) {
        User user = repo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}