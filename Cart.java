package model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> itemList;
    private ArrayList<Integer> quantityList;

    // Constructor
    public Cart() {
        itemList = new ArrayList<>();
        quantityList = new ArrayList<>();
    }

    // Add Item to Cart
    public void addItem(Item item, int quantity) {

        if (item == null || quantity <= 0) {
            System.out.println("Invalid item or quantity!");
            return;
        }

        itemList.add(item);
        quantityList.add(quantity);

        System.out.println(item.getName() + " added to cart.");
    }

    // Remove Item from Cart
    public void removeItem(int index) {

        if (index < 0 || index >= itemList.size()) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.println(itemList.get(index).getName() + " removed from cart.");

        itemList.remove(index);
        quantityList.remove(index);
    }

    // Calculate Total Bill
public double calculateTotal() {

    double total = 0;

    for (int i = 0; i < itemList.size(); i++) {

        Item item = itemList.get(i);
        int qty = quantityList.get(i);

        total += item.calculatePrice(qty);
    }

    return total;
}

    // Display Cart (Console Debug Purpose)
    public void displayCart() {

        if (itemList.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("----- Cart Items -----");

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(
                    (i + 1) + ". " +
                            itemList.get(i).getName() +
                            " | Qty: " + quantityList.get(i)
            );
        }

        System.out.println("Total Bill: ₹" + calculateTotal());
    }

    // Check cart empty
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    // Getters
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public ArrayList<Integer> getQuantityList() {
        return quantityList;
    }
}