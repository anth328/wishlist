package dk.ek.wishlist.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private String url;
    private String image_url;
    private String created_at;

    public Product(){}

    public Product(int i, String n, String d, int p, String u, String iU, String cA) {
        id = i;
        name = n;
        description = d;
        price = p;
        url = u;
        image_url = iU;
        created_at = cA;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
