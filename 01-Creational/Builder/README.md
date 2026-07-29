# Builder Design Pattern

## 1. What Problem Does Builder Pattern Solve?

The Builder Pattern solves the problem of creating complex objects that have many attributes, especially when many attributes are optional.

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

