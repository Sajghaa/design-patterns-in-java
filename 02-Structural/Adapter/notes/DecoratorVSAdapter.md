# Adapter vs Decorator - The Ultimate Distinction

## The 10-Second Test

> **Look at the interface they implement**

| | Adapter | Decorator |
|---|---|---|
| **Implements** | A **DIFFERENT** interface than the wrapped object. | The **SAME** interface as the wrapped object. |
|**Intent** | **Translation** - making things compatible. | **Enhancement** - adding new behavior. |

## Side-by-Side Code comparison

### Adapter (Tax Example)
```java
// Target is DIFFERENT from Adaptee
class LegacyTaxSystem {
    double calculateTax(double income);
}

class LegacyTaxAdapter implements NewTaxCalculator {
    private LegacyTaxSystem legacy;
}