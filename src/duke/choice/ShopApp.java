/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Jumanazar Saidov
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the Duke Shop!");
        Customer c1 = new Customer("Pinky", 3);

        //c1.setSize(measurement);
        c1.setSize("S");

        System.out.println("Min price : " + Clothing.MIN_PRICE);
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");

        Clothing[] items = {item1, item2, new Clothing("Green Scarf", 5, "S"), new Clothing("Blue T-Shirt", 10.5, "S")};

        c1.addItems(items);

//        System.out.println(item1.description + ", " + item1.price + ", " + item1.size);
//        System.out.println(item2.description + ", " + item2.price + ", " + item2.size);
        System.out.println("Customer is " + c1.getName() + ", " + c1.getSize() + ", " + c1.getTotalClothingCost());

        for (Clothing item : c1.getItems()) {

            //System.out.println("Item: " + item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
            System.out.println("Item: " + item);
        }

        int total = 0;
        int num = 0;

        for (Clothing item : c1.getItems()) {
            if (item.getSize().equals("L")) {
                total += item.getPrice();
                num += 1;
            }

        }
        try {
            total = num == 0 ? 0 : (total / num);
            System.out.println("Avg price: " + total);

        } catch (ArithmeticException a) {
            System.out.println("Don't divide by zero");
        }
        Arrays.sort(c1.getItems());

        for (Clothing item : c1.getItems()) {

            //System.out.println("Item: " + item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
            System.out.println("Item: " + item);
        }

        try {

            ItemList list = new ItemList(items);

            Routing routing = Routing.builder().get("/items", list).build();

            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws = WebServer.create(config, routing);

            ws.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
