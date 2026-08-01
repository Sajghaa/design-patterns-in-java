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

## The Pattern Solution
We introduce a Factory Interface (or abstract class) with a createShape() method. Each concrete factory (CircleFactory, SquareFactory, TriangleFactory) implements this interface and creates exactly one type.

Alternatively, we use a Factory Class with a createShape() method that encapsulates the if-else logic in ONE place (Simple Factory). For exams, Factory Method (using interfaces) is the gold standard.

## Why It's a Best Practice
1. **Open/Closed Principle**: Adding a new shape means adding a new Pentagon class AND a new PentagonFactory. We never touch the existing factories or the client code (if we use dependency injection).
2. **Single Responsibility**: Each factory has one job — create its specific shape.
3. **Decoupling**: The client code only depends on the Shape interface and the abstract ShapeFactory — not on concrete classes.
4. **Testability**: You can easily mock factories in unit tests.

## Trade-offs
- **Pros**: Clean separation, easy extension, SOLID compliance.
- **Cons**: More classes (but that's a feature in enterprise Java, not a bug).