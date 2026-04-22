package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
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
        inventory.sort(Comparator.comparing(Product::getName));
        boolean isDone = false;
        while (!isDone) {
            System.out.println("What do you want to do?");
            System.out.println("\t1 - List all products");
            System.out.println("\t2 - Look up a product by its id");
            System.out.println("\t3 - Find all products within a price range");
            System.out.println("\t4 - Add a new product");
            System.out.println("\t5 - Quit the application");
            System.out.println("Enter command: ");
            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    for (Product product : inventory) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    getbyProductId();
                    break;
                case 3:
                    getbyPriceRange();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static ArrayList getbyProductId() {
        ArrayList<Product> foundProduct = new ArrayList<>();
        System.out.println("Enter product id: ");
        int desiredProductId = scan.nextInt();
        boolean found = false;
        for (Product product : inventory) {
            if (product.getId() == desiredProductId) {
                System.out.println(product);
                foundProduct.add(product);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Product not found");
        }
        return foundProduct;

    }

    public static ArrayList<Product> getbyPriceRange() {
        ArrayList<Product> foundProduct = new ArrayList<>();
        System.out.println("Enter product min: ");
        double min = scan.nextInt();
        System.out.println("Enter product max: ");
        double max = scan.nextInt();
        boolean isFound = false;
        for (Product product : inventory) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.println(product);
                isFound = true;
                foundProduct.add(product);
            }
        }
        if (isFound == false) {
            System.out.println("Sorry no products within the range");
        }
        return foundProduct;
    }

    public static void addProduct() {
        System.out.println("Enter product name: ");
        String productName = scan.next();
        System.out.println("Enter product price: ");
        double productPrice = scan.nextDouble();
        int productId = (inventory.get(inventory.size() - 1).getId()) + 1;
        inventory.add(new Product(productId, productName, productPrice));
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
