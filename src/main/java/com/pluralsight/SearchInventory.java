package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.split("\\|");
                int id = Integer.parseInt(productInfo[0]);
                String name = productInfo[1];
                double price = Double.parseDouble(productInfo[2]);
                inventory.add(new Product(id, name, price));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

//    public static ArrayList<Product> getInventory() {
//        ArrayList<Product> inventory = new ArrayList<>();
//
//        inventory.add(new Product(1, "Watch", 503.4));
//        inventory.add(new Product(2, "Iphone", 1234.4));
//        inventory.add(new Product(3, "Gum", 2.4));
//        inventory.add(new Product(4, "Ipad", 231.4));
//        inventory.add(new Product(5, "Laptop", 423.4));
//
//        return inventory;
//    }
}
