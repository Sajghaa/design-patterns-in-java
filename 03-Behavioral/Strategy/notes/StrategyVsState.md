# Strategy vs State

## The Core Distinction
- **Strategy**: Behavior changes based on **external configuration** (the client decides).
- **State**: Behavior changes based on **internal state** (the object decides).

## Example
**Strategy (Payment)**: The user clicks "PayPal". The context swaps the strategy. *External trigger*.

**State (Vending Machine)**:
- No Coin State: Waits for money.
- Has Coin State: Accepts selection.
- Sold Out State: Rejects orders.
The machine changes its own behavior based on *internal* conditions (coin inserted, stock empty).

## The "Kill Shot" Analogy
- **Strategy**: You choose which lens to put on your camera (Manual choice).
- **State**: Your camera automatically switches to "Night Mode" because it senses darkness (Automatic change).