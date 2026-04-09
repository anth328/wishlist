package dk.ek.wishlist.models;

public class WishlistItem {
    private long id;
    private long wishlistId;
    private long productId;
    private int quantity;
    private String note;

    public WishlistItem(long id, long wishlistId, long productId, int quantity, String note) {
        this.id = id;
        this.wishlistId = wishlistId;
        this.productId = productId;
        this.quantity = quantity;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public long getWishlistId() {
        return wishlistId;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }
}