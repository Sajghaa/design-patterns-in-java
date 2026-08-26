# Structural Patterns Comparison: Adapter vs Decorator vs Facade

## The 10-Second Test

| Pattern | Intent | Interface | Analogy |
|---------|--------|-----------|---------|
| **Adapter** | **Translation** | Changes the interface to match what the client expects. | Power plug converter. |
| **Decorator** | **Enhancement** | Keeps the same interface, adds new behavior. | Whipped cream on coffee. |
| **Facade** | **Simplification** | Creates a new, simpler interface to hide complexity. | Universal TV remote. |

## When to use which?

| Scenario | You need to... | Use |
|----------|----------------|-----|
| Integrate a legacy library with a modern interface. | Translate method signatures. | **Adapter** |
| Add optional features (tax, discounts, logging) at runtime. | Enhance behavior without changing the class. | **Decorator** |
| Make a complex subsystem (like a library) easy to use. | Hide complexity and create a simple API. | **Facade** |
| Two systems have different APIs but do the same job. | Bridge the gap. | **Adapter** |
| You want to add a layer of abstraction to reduce client coupling. | Create a single point of entry. | **Facade** |

## The Core Distinction
- **Adapter** solves *incompatibility*.
- **Decorator** solves *class explosion*.
- **Facade** solves *complexity*.

## Interview Kill Shot
> *"An Adapter changes the interface to make things compatible, a Decorator enhances behavior while keeping the interface identical, and a Facade simplifies a complex system by providing a unified higher-level interface. Facade does not add new behavior or change interfaces—it just makes the existing system easier to interact with."*