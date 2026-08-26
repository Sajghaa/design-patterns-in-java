# Facade Pattern

## The Core Philosophy
> *"Provide a unified, simplified interface to a complex subsystem."*

Think of a **Home Theatre Remote**. Instead of turning on the TV, adjusting the volume, switching the input, and turning on the speakers separately, you press one button: `Watch Movie`. The Remote handles the complexity.

## The Enemy
Clients that are tightly coupled to multiple subsystems, forcing them to manage complex initialization and ordering.

## The Anatomy
1. **Complex Subsystem**: The hundreds of classes doing the actual work (Lights, Thermostat, CPU, Memory).
2. **Facade**: The single class wrapping the subsystems, providing simple high-level methods (`leaveHome()`, `startComputer()`).
3. **Client**: The code that only calls the Facade. It has zero knowledge of the subsystems.

## When to Use
- You need a simple interface to a complex subsystem.
- You want to decouple the client from the subsystems.
- You want to structure your system into layers.

## Real-World Use
- `java.net.URL` (provides a simple interface to the complex networking subsystem).
- `javax.faces.context.ExternalContext` (simplifies servlet and portlet APIs).
- Spring's `JdbcTemplate` (simplifies JDBC by handling connections, statements, and result sets).