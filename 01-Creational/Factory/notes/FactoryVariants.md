# Factory Variants Cheat Sheet

## 1. Simple Factory (Not a real GoF pattern)
- One class with as static method containing `if-else`.
- Pros:Easy to write.
- Cons: Violates OCP. Adding new products means modifying the class.
- *Where to use*: Small utilities, quick prototypes.

## 2. Factory Method (The real deal)
- Abstract `Creator` with subclasses.
- Pros: OCP compliant. Each Factory creates exactly one product.
- Cons: Creates a new class for every product.
- *Where to use*: Libraries, frameworks, dependency injection.

## 3. Abstract Factory (Factory of Factories)
- Used for **families** of products (e.g., Windows UI components, Mac UI components).
- Pros: Swap entire families at runtime.
- Cons: Hard to extend (adding a new product type means changing all factories).
- *Where to use:* GUI toolkits, database drivers (e.g., `ConnectionFactory`for Oracle vs MySQL).

## The Interview Kill shot
> *"We prefer the Factory Method because it fully respects the Open/Closed Principle by using polymorphism to delegate creation to subclasses, whereas as Simple Factory violates OCP by requiring modification for each new type"*