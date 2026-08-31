# Observer Pattern

## The Core Philosophy
> *"Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically."*

Think of a **Motion Sensor** in a security system. The sensor (Subject) watches for movement. When movement is detected, it notifies all connected devices (Observers): the alarm, the security camera, and the security guard's phone.

## The Enemy
**Polling** — endlessly checking if something has changed, wasting CPU and causing lag.

## The Anatomy
1. **Subject (Observable)**: Maintains a list of observers and notifies them of changes.
2. **Concrete Subject**: Holds the actual state/data.
3. **Observer**: Defines the `update()` method.
4. **Concrete Observers**: React to changes.

## Push vs Pull
- **Push**: Subject sends all data to observers.
- **Pull**: Observer pulls only what it needs from the subject.

## Observer vs Pub-Sub
- **Observer**: Direct, synchronous, in-process.
- **Pub-Sub**: Indirect, asynchronous, distributed (message broker).

## Real-World Use
- `java.util.Observer` (deprecated but still studied).
- `java.util.EventListener` (GUI programming).
- `javax.servlet.ServletContextListener`.
- Spring's `ApplicationListener` (Event-Driven).