# Decorator Pattern

## The Problem
We need to add optional behaviors (toppings, add-ons, filters) to a core object dynamically.

## The Naive Implementation (`WithoutDecorator.java`)
We use **inheritance**. We create a base `Pizza` class and then extend it for every possible combination of toppings:
- `CheesePizza`
- `OlivePizza`
- `CheeseOlivePizza`
- `MushroomCheeseOlivePizza`
- ... and so on.

## Why It Fails (Exam Critical)
1. **Class Explosion**: For `n` toppings, we need `2^n` subclasses. With just 4 toppings, that's 16 classes!
2. **Code Duplication**: The cost and description logic is duplicated across every subclass.
3. **Static Behavior**: The combination is fixed at compile-time. You can't add a topping to a pizza *at runtime* (e.g., based on user input).
4. **Violates Open/Closed Principle**: Adding a new topping (e.g., `Pepperoni`) forces you to create dozens of new subclasses (PepperoniPizza, CheesePepperoniPizza, OlivePepperoniPizza...).

## The Pattern Solution (`WithDecorator.java`)
We use **composition** instead of inheritance.
1. **Component Interface** (`Pizza`): Defines the core behavior.
2. **Concrete Component** (`PlainPizza`): The base object.
3. **Decorator Abstract Class** (`PizzaDecorator`): Wraps a `Pizza` object and implements the same interface.
4. **Concrete Decorators** (`CheeseDecorator`, `OliveDecorator`, `MushroomDecorator`): Add behavior *before* or *after* delegating to the wrapped object.

## Why It's a Best Practice (Exam Critical)
1. **Open/Closed**: Adding `PepperoniDecorator` requires zero changes to existing classes.
2. **Runtime Flexibility**: You can build pizzas dynamically: `new CheeseDecorator(new OliveDecorator(new PlainPizza()))`.
3. **Composition Over Inheritance**: We are *wrapping* rather than *extending*.
4. **Single Responsibility**: Each decorator handles exactly one add-on.

## 🚨 EXAM TRAP: Decorator vs Adapter 🚨
This is the #1 source of confusion in exams. Memorize this table:

| Feature | Decorator | Adapter |
| :--- | :--- | :--- |
| **Intent** | Adds **new behavior** (responsibilities). | Makes two **incompatible interfaces** work together. |
| **Interface** | **Same** interface as the wrapped object. | **Different** interface (translates one to another). |
| **Structure** | Wraps one object. | Wraps one object. |
| **Real-World Analogy** | Adding whipped cream on top of coffee. | A power plug adapter (US->EU) changes the *shape* of the plug. |
| **Code Clue** | Implements the *same* interface as the wrapped class. | Implements a *new/target* interface, but calls a legacy/adaptee class. |

---

## Real-World Use
- `java.io.InputStream` – `FileInputStream` wrapped by `BufferedInputStream` (adds buffering) and `DataInputStream` (adds data parsing). This is the classic Java Decorator example!
- `javax.swing.JScrollPane` (adds scrolling to a component).

### Exercises
Check the `exercises/` folder for hands-on challenges.