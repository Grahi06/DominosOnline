# 🍕 Dominos Online Ordering System (JavaFX)

## 📌 Project Description
This is a desktop-based food ordering system developed using Java and JavaFX.
The project allows users to login[Register], view food items, and place orders.

This project stores data using text files (.txt) instead of database.

## 🛠 Technologies Used
- Java
- JavaFX
- File Handling (Text Files)
- OOP Concepts
- CMD for Compilation & Execution

## ✨ Features
- User Login System
- Food Menu Display
- Order Placement
- File-based Data Storage (.txt)
- Exception Handling

## 📂 Project Structure
Dominos-Online-Ordering-System/
│
├── src/
│   │
│   ├── data/
│   │   ├── delivery.txt
│   │   ├── user.txt
│   │   ├── menu.txt
│   │   └── orders.txt
│   │
│   ├── exception/
│   │   ├── EmptyCartException.java
│   │   └── InvalidLoginException.java
│   │
│   ├── gui/
│   │   ├── CartPage.java
│   │   ├── LoginPage.java
│   │   ├── MenuPage.java
│   │   ├── OrderStatusPage.java
│   │   └── RegisterPage.java
│   │
│   ├── model/
│   │   ├── Admin.java
│   │   ├── Cart.java
│   │   ├── Drink.java
│   │   ├── Item.java
│   │   ├── Order.java
│   │   ├── Pizza.java
│   │   └── User.java
│   │
│   ├── service/
│   │   ├── AuthService.java
│   │   ├── FileService.java
│   │   ├── MenuService.java
│   │   └── OrderService.java
│   │
│   ├── thread/
│   │   └── OrderProcessingThread.java
│   │
│   └── Main.java
│
├── screenshots/
│   ├── login.png
│   ├── menu.png
│   ├── order.png
│   ├── orderStatus.png
│   └── orderDelivered.png
│
├── README.md
├── .gitignore
└── LICENSE

## 💾 Data Storage
- User and order data are stored in text (.txt) files.
- File handling is used instead of MySQL database.

## ▶ How to Run

1. Install Java (JDK 17+ recommended)
2. Install JavaFX SDK
3. Open CMD in project folder
4. Compile:
   javac --module-path "path_to_javafx_lib" --add-modules javafx.controls *.java
5. Run:
   java --module-path "path_to_javafx_lib" --add-modules javafx.controls Main

🎬 Project Workflow

--User registers or logs in to the system
--User browses available menu items
--Items are added to the cart
--Order is placed by the user
--Order is processed using multi-threading
--Order status is displayed (Processing → Delivered)

✨ Advanced Features

-Multi-threaded order processing system
-Custom exception handling implementation
-File-based persistent data storage
--Modular layered architecture design
-Object-Oriented Programming principles
-Command-line compilation and execution support

💡 Why This Project?

Helps in understanding JavaFX GUI development
Demonstrates file handling concepts
Implements multithreading concepts
Shows custom exception handling
Follows structured software design

## 🎯 Learning Outcomes
- JavaFX GUI Development
- File Handling in Java
- Exception Handling
- Object-Oriented Programming
- Project Structure Management

## 👨‍💻 Developer
Grahi Patel  
Computer Engineering Student (GTU)

---
⭐ Feel free to explore and improve this project!
