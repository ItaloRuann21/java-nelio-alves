package enumeracoesComposicoes.exercicios.application;

import enumeracoesComposicoes.exercicios.models.entities.Client;
import enumeracoesComposicoes.exercicios.models.entities.Order;
import enumeracoesComposicoes.exercicios.models.entities.OrderItem;
import enumeracoesComposicoes.exercicios.models.entities.Product;
import enumeracoesComposicoes.exercicios.models.enums.OrderStatus;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = scanner.nextLine();
        System.out.print("Email: ");
        String clientEmail = scanner.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scanner.next());

        Client client = new Client(nameClient, birthDate, clientEmail);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            scanner.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = scanner.nextLine();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();

            Product product = new Product(nameProduct, productPrice);

            OrderItem items = new OrderItem(quantity, productPrice, product);

            order.addItem(items);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        scanner.close();
    }
}
