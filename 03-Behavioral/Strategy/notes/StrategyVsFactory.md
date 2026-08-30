# Strategy vs Factory

## The Core Distinction
- **Factory**: **What** to create.
- **Strategy**: **How** to execute.


## The "Kill Shot" Analogy
- **Factory**: The weapon forge. it decides if you get a sword or a Bow.
- **Strategy**: The combat style. You already have a Sword, but do you use it for parrying or slashing? 


## Example
**Factory**: 
```java
PaymentStrategy strategy = PaymentFactory.create("credit");