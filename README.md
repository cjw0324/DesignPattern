# Design Pattern

This repository contains the solutions for the Design Patterns course labs. Each lab focuses on different design principles or patterns. Below is the description of each lab:

## Lab01: SOLID Principles
In this lab, we applied the **SOLID principles** to improve code structure and maintainability. The SOLID principles are:
- **S**: Single Responsibility Principle
- **O**: Open/Closed Principle
- **L**: Liskov Substitution Principle
- **I**: Interface Segregation Principle
- **D**: Dependency Inversion Principle

This lab focuses on refactoring a given codebase to adhere to these principles, ensuring better flexibility and reduced coupling.

## Lab02: Strategy Pattern
This lab focuses on implementing the **Strategy Pattern**, a behavioral design pattern that enables selecting an algorithm's behavior at runtime. 
The lab demonstrates how to:
- Define a family of algorithms, encapsulate each one, and make them interchangeable.
- Use different algorithms without altering the context in which they're used.

Example use cases include sorting algorithms, disk scheduling algorithms, and other operations where the logic may vary dynamically.

## Lab03: Observer Pattern
In this lab, the **Observer Pattern** is implemented. This pattern allows an object (subject) to notify other objects (observers) about state changes, typically used for implementing event-driven systems.
Key concepts covered in this lab include:
- **Subject**: The object being observed.
- **Observer**: The object(s) observing and reacting to changes in the subject.
- Real-world examples such as UI event handling and data monitoring.

---

### Lab04: Decorator Pattern
In this lab, we explore the **Decorator Pattern**, a structural design pattern that allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects from the same class. The pattern involves a set of decorator classes that are used to wrap concrete components.

Key concepts covered in this lab include:
- **Component**: The base interface or abstract class that defines the core functionality (in this case, a `Doll`).
- **Concrete Component**: A class that implements the `Component` interface (e.g., `CatDoll`, `DogDoll`, `RabbitDoll`).
- **Decorator**: An abstract class that wraps a `Component` and adds new behaviors or responsibilities (e.g., `HatDecorator`, `BallDecorator`, `ToyDecorator`).
- **Concrete Decorators**: These are specific decorators that implement the additional behavior (e.g., `HatDecorator` adds a hat to the doll, `BallDecorator` adds a ball).

In this lab:
- We create different types of dolls (Cat, Dog, Rabbit).
- Decorators are used to dynamically add accessories like hats, balls, and toys to the dolls.
- Random positioning and scaling of these accessories are demonstrated.
- The `Clear` functionality allows for resetting the added decorations while keeping the base doll intact.

This lab emphasizes the flexibility of the Decorator Pattern, allowing objects to be composed with various behaviors dynamically and promoting open/closed design.

---

Each lab includes the code solution and test cases for the given design pattern or principle. Feel free to explore and experiment with each implementation.
