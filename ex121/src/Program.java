import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client1 = new Client(clientName, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

        Order order1 = new Order(orderStatus);

        order1.setClient(new Client(clientName, email, birthDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for(int i =1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();


            OrderItem orderItem = new OrderItem(quantity);
            orderItem.setProduct(productName, price);
            order1.addItem(orderItem);
        }

        System.out.println(order1.toString());
    }
}
