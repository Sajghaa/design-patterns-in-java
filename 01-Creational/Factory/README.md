# Factory Pattern (Factory Method)

## The Problem
We need to create different types of objects (e.g., `Circle`, `Square`, `Triangle`) based on some input (e.g., a `String` type). 
The naive approach uses `if-else` or `switch` statements scattered across the codebase.

## The Naive Implementation (`WithoutFactory.java`)
We write a single method that takes a `String` type and returns the appropriate object using `if-else`:
```java
if (type.equals("circle")) return new Circle();
else if (type.equals("square")) return new Square();
else if (type.equals("triangle")) return new Triangle();
```

## Why It Fails
- **Violates Open/Closed Principle**: To add a new shape (e.g., Pentagon), you have to modify this class — it's closed for modification, but we need it to be open for extension.
- **Violates Single Responsibility**: This method does two things: (1) decides which object to create, and (2) creates it. That's two reasons to change.
- **Code Duplication**:Every time you need a new shape, you copy-paste this if-else block elsewhere in the codebase.
- **Tight Coupling**: The client code *(main())* is directly coupled to all concrete classes *(Circle, Square, Triangle)*.