
# 🛒 Java E-Commerce System – Fawry Internship Challenge

This project is a simple object-oriented e-commerce system built in Java, designed as part of the Fawry Full Stack Internship Challenge.

It simulates a shopping experience with different product types, a shopping cart, and a checkout process. It demonstrates proper use of object-oriented principles, error handling, interfaces, and clean architecture, using only two generic product classes.

---

## 📌 Features

- Two generic product types:
  - `PerishableShippableProduct`: products that expire and require shipping (e.g., Cheese, Biscuits).
  - `SimpleProduct`: basic products that do not expire or require shipping (e.g., Scratch Cards).
- Customers can:
  - Add products to their cart with specified quantity.
  - Checkout to see a full receipt and shipping summary.
- Shipping handled through a dedicated `ShippingService` with `Shippable` interface.
- Error handling for:
  - Expired products
  - Insufficient stock
  - Empty cart
  - Insufficient customer balance

---

## 🧱 Project Structure

```
src/
├── data/              # Cart and cart-related classes
├── model/             # Generic product classes and customer
│   ├── Product.java
│   ├── PerishableShippableProduct.java
│   └── SimpleProduct.java
├── service/           # Business logic: checkout and shipping
├── util/              # Interfaces and shared logic
└── Main.java          # Entry point with all test scenarios
```

---

## 🚀 How to Run

1. Clone or download the project.
2. Open it in any Java IDE (IntelliJ, VS Code...).
3. Ensure JDK 8+ is installed.
4. Run the `Main.java` file.

Console will display output for all test cases.

---

## ✅ Test Scenarios in `Main.java`

| Case | Description |
|------|-------------|
| ✅ Successful checkout | All items are valid, with enough balance |
| ❌ Empty cart | Throws error when trying to checkout with no items |
| ❌ Expired product | Error when attempting to purchase expired product |
| ❌ Quantity exceeds stock | Cannot add more than available quantity |
| ❌ Insufficient balance | Total price exceeds customer balance |

---

## 📦 Example Output

```
** Shipment notice **
2x Cheese     400.0g
1x Biscuits   700.0g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese     200.0
1x Biscuits   150.0
1x Scratch Card     50.0
----------------------
Subtotal         400.0
Shipping         30.0
Total Amount     430.0
Remaining Balance: 4570.0
```

---

## 🧠 Concepts Used

- Object-Oriented Programming (OOP)
  - Inheritance
  - Encapsulation
  - Abstraction
  - Polymorphism
- Interfaces (`Shippable`)
- Clean separation of concerns (`model`, `service`, `data`, `util`)
- Structured error handling with meaningful feedback
- Minimal and scalable class design (only two product types)

---

## 👨‍💻 Author

- **Ahmed Hosny**
- Submitted for Fawry Internship Technical Evaluation – July 2025

