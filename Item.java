package model;

public abstract class Item {

    // Data Members
    protected int itemId;
    protected String name;
    protected double price;

    // Constructor
    public Item(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    // Abstract Method (must be implemented by child classes)
    public abstract double calculatePrice(int quantity);

    // Concrete Method
    public void displayItem() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: ₹" + price);
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return itemId + "," + name + "," + price;
    }
}