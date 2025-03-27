package dto;

public class CartItem {

    private String productID;
    private String title;
    private double price;
    private int quantity;

    public CartItem(String productID, String title, double price, int quantity) {
        this.productID = productID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() { return productID; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    
}
