# Facade Pattern — Exercises

## Exercise 1: Add a DoorLock to SmartHome (OCP Test)
- Create a `DoorLock` class with methods `lock()` and `unlock()`.
- Modify `SmartHomeFacade` to include `DoorLock`.
  - `leaveHome()` calls `doorLock.lock()`.
  - `arriveHome()` calls `doorLock.unlock()`.
- **Question**: Did you modify `SmartHomeDemo` (the client)?
- **Answer**: No! The client just calls the facade. The client stays clean.

## Exercise 2: Add a new method to Facade
- Add a method `sleepMode()` to the SmartHomeFacade that:
  - Turns off lights.
  - Sets thermostat to 20 degrees.
  - Locks the doors (if you added DoorLock).
- Test it in the demo.

## Exercise 3: The Restaurant Analogy
- Think of a restaurant. The **Kitchen** is the complex subsystem (chefs, ovens, ingredients). The **Waiter** is the Facade.
- Write a `WaiterFacade` that provides methods `orderPizza()` and `orderPasta()`.
- The client only talks to the waiter, not the chefs or ovens.

## Exercise 4: Reflection Question
*"Why is the Facade pattern considered a 'structural' pattern rather than a 'creational' pattern?"*
- **Hint**: It structures how classes interact, not how they are created.