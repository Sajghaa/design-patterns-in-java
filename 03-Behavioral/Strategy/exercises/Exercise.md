# Strategy Pattern — Exercises

## Exercise 1: Add a "Student" Fare (OCP Test)
- Create `StudentFare.java` that returns 50000.0.
- In `TravelBookingDemo`, use the new fare.
- **Question**: Did you modify `TravelContext` or any existing fare class?
- **Answer**: No. OCP is fully respected.

## Exercise 2: Add "ApplePay" Strategy
- Create `ApplePayStrategy.java` implementing `PaymentStrategy`.
- Add it to `PaymentDemo`.
- Print "🍎 Paid X using Apple Pay".

## Exercise 3: Dynamic Strategy Selection (Real-World)
- Write a method in `TravelBookingDemo` that asks the user for input (Scanner).
- Based on the input string ("economy", "business"), create the appropriate strategy.
- This simulates how real apps decide which strategy to use based on user choices.

## Exercise 4: Reflection Question
*"If we use the Strategy pattern, where does the `if-else` logic go?"*
- **Hint**: It moves from inside the Context to the **Client**. The client chooses which strategy to inject. This is a valid trade-off because it makes the Context cleaner and allows us to use polymorphism.

## Exercise 5: Strategy with Lambda (Java 8+)
- Rewrite the `FareStrategy` implementation using Lambda expressions in the `main` method.
- Example: `context.setFareStrategy(() -> 100000.0);`
- This shows how modern Java simplifies the pattern even further.