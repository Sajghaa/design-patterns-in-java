# Singleton Pattern

## The Problem

We need exactly **one instance** of a class (e.g., Database connection, Configuration manager, Logger). Everyone in the application should use the same instance

## The Naive Implementation (`NaiveSingleton.java`)
We just make the constructor `private`  and expose a `public static` `getInstance()` method that creates the instance if `null`.

## Why It fails
1. **Not Thread-Safe**: If two threads call `getInstance()` at the same time when `instance == null`, both will create separate objects -> **two instance exist** -> Singleton is broken.
2. **Reflection Attack**: Using `setAccessible(true)`, anyone can call the private constructor and create new instances.
3 **Serialization Problem**: When you deserialize a Singleton, Java creates a new instance unless you implement `readResolve()`

## The Pattern Solutions
We provide **three** robust implementations, each with its own trade-offs:

### 1. Eager Singleton (`EagerSingleton.java`)
- The instance is created at class loading time.
- **Thread-safe** by default(JVM guarantees it).
- **Downside**: Wastes memory if the instance is never used.

### 2. lazy Singleton with Double-Checked Locking(`LazySingleton.java`)
- The instance is created only when `getInstance()` is first called.
- Uses `synchronized` block and `volatile`keyword.
- **Thread-safe** and **lazy**.
- **Downside**: Slightly complex to read.

### 3. Enum Singleton (`EnumSingleton.java`)
- Joshua Block's recommended approach.
- **Thread-safe**, **reflection-proof**, and **serialization-safe** out of the box.
- **Downside**: Some purists dislike enums for this, but it's technically perfect.

## Trade-offs Summary
| Approach | Thread-Safe | Lazy | Reflection-Safe | Serialization-Safe |
|----------|-------------|------|-----------------|---------------------|
| Naive    | ❌          | ✅   | ❌              | ❌                  |
| Eager    | ✅          | ❌   | ❌              | ❌ (needs `readResolve`) |
| Lazy (DCL) | ✅       | ✅   | ❌              | ❌ (needs `readResolve`) |
| Enum     | ✅          | ✅   | ✅              | ✅                  |