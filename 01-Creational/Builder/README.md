# Builder Design Pattern

## What Problem Does Builder Pattern Solve?

The Builder Pattern solves the problem of creating complex objects that have many attributes, especially when many attributes are optional. 
## The Naive Implementation(`WithoutBuilder.java`)

We use the **Telescoping Constructor** pattern. We provide a constructor for every possible combination of parameter

## Why It Fails

When an object has too many constructor parameter, the code become difficult to read, maintain, and understand

Example:
```java
User user = new User(
    "Serge",
    "Rwanda".
    "Software Engineer",
    true,
    "java",
    "Django"
)
```

1. **Readability Nightmare**: When you see `new User("Serge", "Rwanda", "Software Engineer",true, "java", "Django")`, you have no idea what `true` or `"Django"` refers to without checking the constructor signature.

2. **Fragile Code**: IF you swap the of `isActive` and `Language` accidentally in the call, The Compiler wont complain, but your logic breaks.

3. **Hard to Maintain**: Adding a new optional(eg., `email`) forces you to create a whole new constructor, breaking the open/closed Principle.

## Pattern Solution (`WithBuilder.java`)
we use a static nested `Builder` class. It uses **method chaining** to set parameters.

## Why It's a Best Practice

1. **Immutability**: The actual class has `final` fields and no setters. ONce built, it cannot change.

2. **Fluent Interface**: `new Builder("Serge").country("Rwanda").profession("software engineer").build()` is self-documenting.

3. **Validation Centralized**: We put all validation logic inside the `build()` method. IF `age` is negative, we throw an exception right when the object is created, preventing invalid objects from existing.


## Trade-offs
- **Pros**: Clean, safe, immutable, readable.
- **Cons**: More boilerplate code (but modern generate this in 2 clicks).

## Real-World Use

`StringBuilder.append()`, `Stream.Builder`, and complex DTOs(Data Transfer Objects) in enterprise applications.


### Exercises

Check the `exercises/` folder for hands-on challenges