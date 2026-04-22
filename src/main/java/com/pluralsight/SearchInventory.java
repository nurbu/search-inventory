package com.pluralsight;

import java.util.ArrayList;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(1, "Watch", 503.4));
        inventory.add(new Product(2, "Iphone", 1234.4));
        inventory.add(new Product(3, "Gum", 2.4));
        inventory.add(new Product(4, "Ipad", 231.4));
        inventory.add(new Product(5, "Laptop", 423.4));

        return inventory;
    }
}
