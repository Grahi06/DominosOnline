package model;

public class Drink extends Item {

    // Constructor (Single size drink)
    public Drink(int itemId, String name, double price) {
        super(itemId, name, price);
    }

    @Override
    public double calculatePrice(int quantity) {
        return getPrice() * quantity;   // As it is price calculation
    }

    @Override
    public void displayItem() {
        System.out.println("---- Drink Details ----");
        super.displayItem();
    }

    @Override
    public String toString() {
        return itemId + "," + name + "," + price;
    }
}