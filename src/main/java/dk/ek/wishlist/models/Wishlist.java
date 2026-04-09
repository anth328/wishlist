package dk.ek.wishlist.models;

public class Wishlist {
    private long id;
    private long userId;
    private String name;
    private String description;

    public Wishlist(long id, long userId, String name, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}