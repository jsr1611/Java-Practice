/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 * @author Jumanazar Saidov
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double tax = 0.2;
        double total = 0;

        System.out.println("Welcome to the Duke Shop!");

        Customer c1 = new Customer();

        c1.setName("Pinky");
        c1.setSize("S");

        Clothing item1 = new Clothing();
        Clothing item2 = new Clothing();
        Clothing item3 = new Clothing();
        Clothing item4 = new Clothing();

        Clothing[] items = {item1, item2, item3, item4};

        c1.addItems(items);
        item1.setDescription("Blue Jacket");
        item1.setPrice(20.9);
        item1.setSize("M");

        item2.setDescription("Orange T-Shirt");
        item2.setPrice(10.5);
        item2.setSize("S");

        item3.setDescription("Green Scarf");
        item3.setPrice(5);
        item3.setSize("S");

        item4.setDescription("Blue T-Shirt");
        item4.setPrice(10.5);
        item4.setSize("S");

//        System.out.println(item1.description + ", " + item1.price + ", " + item1.size);
//        System.out.println(item2.description + ", " + item2.price + ", " + item2.size);
        int measurement = 8;

        c1.setSize(measurement);
        System.out.println("Customer is " + c1.getName() + ", " + c1.getSize() + ", " + c1.getTotalClothingCost());

        //c1.getTotalClothingCost();

        
        
        for (Clothing item : c1.getItems()) {

        System.out.println("Item: " + item.getDescription()+ ", " + item.getPrice() + ", " + item.getSize());    

        }

    }

}
