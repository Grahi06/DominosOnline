package service;

import model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MenuService {

    private ArrayList<Item> menuList;

    public MenuService() {
        menuList = new ArrayList<>();
        loadMenu();
    }

    // Load menu from file
    private void loadMenu() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("data/menu.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts[0].equalsIgnoreCase("Pizza")) {

                    Pizza pizza = new Pizza(
                            Integer.parseInt(parts[1]),
                            parts[2],
                            Double.parseDouble(parts[3]),
                            parts[4]
                    );

                    menuList.add(pizza);
                }

else if (parts[0].equalsIgnoreCase("Drink")) {

    Drink drink = new Drink(
            Integer.parseInt(parts[1]),
            parts[2],
            Double.parseDouble(parts[3])
    );

    menuList.add(drink);
}
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Menu file loading error!");
        }
    }

    // Get Menu List
    public ArrayList<Item> getMenu() {
        return menuList;
    }

    // Display Menu
    public void displayMenu() {

        System.out.println("------ MENU ------");

        for (Item item : menuList) {
            item.displayItem();
            System.out.println("----------------");
        }
    }
}