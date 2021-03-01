package entities;

public class OrderItem {

    static StringBuilder stringBuilder = new StringBuilder();

    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity) {
        this.quantity = quantity;
    }
    public OrderItem(){
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(String productName, Double productPrice) {
        this.product = new Product(productName, productPrice);
    }

    public Double subTotal(){
        return this.product.getPrice() * this.quantity;
    }
    public String toString(){
        stringBuilder.append(getProduct().toString());
        stringBuilder.append(", Quantity: " + quantity);
        stringBuilder.append(", Subtotal: " + subTotal());
        return stringBuilder.toString();
    }
}
