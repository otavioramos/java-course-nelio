package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private List<OrderItem>  orderItems= new ArrayList<>();
    private Client client;

    public Order(OrderStatus status) {
        this.moment = new Date();
        this.status = status;
    }
    public Order(){
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }
    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }
    public Double total(){
        Double total = 0.0;
        for(OrderItem item : orderItems){
            total += item.subTotal();
        }
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ORDER SUMMARY:\n");
        stringBuilder.append("Order moment: " + moment.toString() + "\n");
        stringBuilder.append("Order status: " + status.toString() + "\n");
        stringBuilder.append(client.toString());

        stringBuilder.append("Ordem items: \n");
        for (OrderItem orderItem : orderItems){
            stringBuilder.append(orderItem.toString());
        }

        stringBuilder.append("\n Total price: " + total());

        return stringBuilder.toString();
    }
}
