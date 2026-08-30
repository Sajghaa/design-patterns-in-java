# Strategy Pattern

## The Core Philosophy
> *"Define a family of algorithms, encapsulate each one, and make them interchangeable."*

Think of it like a **Camera Lens**. You have a Portrait Lens, a Wide-Angle Lens, and a Macro Lens. Your Camera (the Context) takes a picture (the Method), but the *way* it captures the image depends on which lens (Strategy) you attach.

## The Enemy
Massive `if-else`/`switch` chains that cram multiple algorithms into one class, violating OCP and SRP.

## The Anatomy
1. **Strategy (Interface)**: Defines the algorithm contract.
2. **Concrete Strategies**: The actual implementations.
3. **Context**: Holds a reference to a Strategy and delegates the work.
4. **Client**: Chooses which Strategy to inject at runtime.

## Strategy vs Factory (Crucial Distinction)
- **Factory** decides **which class** to instantiate (creation).
- **Strategy** decides **which algorithm** to execute (behavior).

## Real-World Use
- `java.util.Comparator` (a Strategy for sorting).
- `javax.servlet.http.HttpSession` (session management strategies).
- Spring's `ResourceLoader` (different strategies for loading files).