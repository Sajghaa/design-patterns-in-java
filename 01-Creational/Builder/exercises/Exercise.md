# Builder Pattern

## Exercise 1: Adding a New Field
Add a new optional field `String email` to then `WithBuilder`class.
- Add the validation rule: email must contain '@' if provided.
- Updated the `toString()` method.
- Write a `main()` that builds a user with email.

## Exercise 2: The "Illegal State" Scenario
You are building a `Computer` class. It has `RAM` and `HDD` (both required) and optional `Bluetooth` and `WIFI`.
Write the Builder for it, but enforce a rule:
- If `Bluetooth` is `true`, then `WiFi` must also be `true` (because Bluetooth pairing often needs a companion app via WiFi).

## Exercises 3: Reflection Question
Explain in 2 sentences:
*"Why is the Builder pattern considered better than Telescoping Constructor pattern for unit testing"*
*(Hint: Think about creating valid vs invalid objects)*