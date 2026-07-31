# Singleton Pattern - Exam Prep Exercises

## Exercise 1: The Serialization Trap
Take `EagerSingleton.java`. Add `implements Serializable`.
- Write a test that:
  1. Serializes the singleton to a file.
  2. Deserializes it back.
  3. Compare the hashCodes before and after serialization.
- Fix it by adding `protected Object readResolve()` that returns `INSTANCE`.

## Exercise 2: Thread-Safety Analysis
Look at `NaiveSingleton.java`. 
- Write a loop that creates 100 threads, each calling `getInstance()` 100 times.
- Print how many distinct instances were created.
- Then replace it with `LazySingleton` and prove it produces only one instance.

## Exercise 3: Multiple Singleton (Bill Pugh's Approach - BONUS)
Research the **Bill Pugh Singleton** (uses a static inner helper class).
- Write it in a new file `BillPughSingleton.java`.
- Explain why it is considered the **best** lazy-loaded thread-safe implementation without synchronization overhead.
- Add it to your `src/` folder.

## Exercise 4: Reflection Question (Exam favorite)
Explain in 2 sentences:
*"Why can't we use reflection to break the Enum Singleton?"*

## Exercise 5: Real-World Scenario
You are building a logging utility. The logger must be a singleton because we want all logs to go to the same file.
- Which implementation would you choose for a **web application** that handles thousands of concurrent requests? Justify your answer.