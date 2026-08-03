# Decorator Pattern - Exam Prep Exercises

## Exercise 1: Add a New Topping (Open/Closed Test)
1. Create a `PepperoniDecorator` that adds $2.5 to the cost and " + Pepperoni" to the description.
2. Use it to create a Pizza with Pepperoni, Cheese, and Olive.
3. **Question**: Did you modify `Pizza`, `PlainPizza`, `PizzaDecorator`, or any existing decorator? This proves OCP!

## Exercise 2: Dynamic Runtime Building (Lambda/Switch)
Write a method `createPizza(List<String> toppings)` that takes a list of topping names (e.g., `["cheese", "mushroom"]`) and dynamically builds the pizza using the appropriate decorators. 
- Use a `switch` or `Map<String, Function<Pizza, Pizza>>` to map strings to decorator constructors.

## Exercise 3: The `java.io` Connection (Common Exam Question)
Look at the following Java code:
```java
InputStream in = new BufferedInputStream(new FileInputStream("file.txt"));