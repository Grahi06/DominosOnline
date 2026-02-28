package model;

public class Pizza extends Item {

    private String size;   // Small, Medium, Large

    // Constructor
    public Pizza(int itemId, String name, double price, String size) {
        super(itemId, name, price);   // Call parent constructor
        this.size = size;
    }

    // Getter
    public String getSize() {
        return size;
    }

    // Setter
    public void setSize(String size) {
        this.size = size;
    }

    // Method Overriding (Polymorphism)
@Override
public double calculatePrice(int quantity) {

    double basePrice = getPrice();

    if (size != null) {

        if (size.equalsIgnoreCase("Medium")) {
            basePrice += 100;
        }
        else if (size.equalsIgnoreCase("Large")) {
            basePrice += 200;
        }
    }

    return basePrice * quantity;
}

    @Override
    public void displayItem() {
        System.out.println("---- Pizza Details ----");
        super.displayItem();
        System.out.println("Size: " + size);
    }

    @Override
    public String toString() {
        return itemId + "," + name + "," + price + "," + size;
    }
}