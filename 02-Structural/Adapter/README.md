# Adapter Pattern

## The Core Philosophy

> "Allow two incompatible interfaces to work together without modifying either one."

Think of a **power plug adapter** (US to EU). The device works, the wall socket works, but they speak different "languages." The adapter translates voltage and plug shape so they can communicate.

## The 4 Immutable Parts
1. **Target (Interface)**: What the client expects.(e.g., `NewTaxCalculator`)
2. **Adaptee (Legacy Class)**: The existing class that does job but has a different interface. (e.gm `LegacyTaxSystem`)
3. **Adapter (Translator)**: Implements the target, holds an instance of the Adaptee, and translates calls between them.
4. **Client**: The code that only talks to the Target, unaware the Adaptee exists.


## Why It's a Best Practice (Exam/Interview Gold)

- **Single Responsibility**: Translation logic is isolated in the adapter.
- **Open/Closed**: To add a new legacy system, create a new Adapter. Never touch existing code.
- **Reusability**: Old, stable legacy code gets a new life in modern systems.

## Adapter vs Decorator (The #1 Trap)
| Feature | Adapter | Decorator |
|---------|---------|-----------|
|**Intent**|**Translation** (Change the interface) | **Enhancement** (adds behavior)|
|**Interface**| Implements a **DIFFERENT** interface than wrapped object | Implements the **SAME** interface |
| **Analogy** | Power plug adapter (changes shape) | Whipped cream on coffee (same cup, enhanced taste) |
| **Code Clue** | `Adapter` implements `Target` but holds `LegacyClass` | `Decorator` implements `SameInterface` and holds `SameInterface` |

> **Golden Rule:** If it implements a **different** interface, it's **Adapter**. If it implements the **same** interface, it's a **Decorator**.

## Real-World Use
- `InputStreamReader` (Converts `InputStream`) byte stream to `Reader` character stream.
- `Arrays.asList()` (adapts array to `List ` interface).
- Spring's `HandleAdapter` (Adapter different controller types to the same execution flow).
