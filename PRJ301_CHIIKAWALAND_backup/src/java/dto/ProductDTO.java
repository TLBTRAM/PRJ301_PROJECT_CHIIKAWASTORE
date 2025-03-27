package dto;

public class ProductDTO {
    private String productID;
    private String title;
    private String brand;
    private String category;
    private double price;
    private int quantity;
    private String image;

    public ProductDTO() {
        this.productID = "";
        this.title = "";
        this.brand = "";
        this.category = "";
        this.price = 0;
        this.quantity = 0;
        this.image = "";
    }

    public ProductDTO(String productID, String title, String brand, String category, double price, int quantity, String image) {
        this.productID = productID;
        this.title = title;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
