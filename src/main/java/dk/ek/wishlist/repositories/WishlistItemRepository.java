package dk.ek.wishlist.repositories;

import dk.ek.wishlist.models.WishlistItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistItemRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void addProduct(long wishlistId, long productId) {
        String sql = "INSERT INTO wishlist_items (wishlist_id, product_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, wishlistId);
            stmt.setLong(2, productId);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<WishlistItem> findByWishlist(long wishlistId) {
        List<WishlistItem> list = new ArrayList<>();
        String sql = "SELECT * FROM wishlist_items WHERE wishlist_id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, wishlistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new WishlistItem(
                        rs.getLong("id"),
                        rs.getLong("wishlist_id"),
                        rs.getLong("product_id"),
                        rs.getInt("quantity"),
                        rs.getString("note")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}