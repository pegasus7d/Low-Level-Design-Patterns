# Low Level Design Patterns - Must Know

A comprehensive guide to essential design patterns for interviews and practical development.

---

## Priority 1: Must Know by Heart

These patterns appear frequently in interviews and real-world projects. Master these first.

### Creational Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Singleton** | Ensure only one instance exists | Database connection, Logger, Config manager |
| **Factory Method** | Create objects without specifying exact class | Payment processors, Document creators |
| **Builder** | Construct complex objects step-by-step | StringBuilder, Pizza builder, Query builder |

### Structural Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Adapter** | Convert interface to expected format | Legacy code integration, API adapters |
| **Decorator** | Add behavior dynamically | InputStream wrappers, Coffee toppings |
| **Facade** | Simplify complex subsystems | Database facade, API gateway |

### Behavioral Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Strategy** | Swap algorithms at runtime | Payment methods, Sorting algorithms |
| **Observer** | Notify multiple objects of events | Event systems, Pub-sub, UI listeners |
| **Command** | Encapsulate requests as objects | Undo/Redo, Task queues, Remote controls |

---

## Priority 2: Very Important

These are commonly asked and useful in real projects.

### Creational Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Abstract Factory** | Create families of related objects | UI themes (dark/light), Database drivers |
| **Prototype** | Clone existing objects | Avoid expensive creation, Game objects |

### Structural Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Proxy** | Control access to an object | Lazy loading, Caching, Security |
| **Composite** | Tree structures with uniform handling | File systems, UI components, Organizations |

### Behavioral Patterns

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Template Method** | Define algorithm skeleton in base class | Game loop, Data processing pipelines |
| **Iterator** | Traverse collections uniformly | Collections, Trees, Graphs |
| **State** | Change behavior based on internal state | Order status, Vending machines, Traffic lights |

---

## Priority 3: Know the Concept

Understand these patterns but implementation can be looked up when needed.

### Creational
- **Object Pool** - Reuse expensive objects (database connections, threads)

### Structural
- **Bridge** - Separate abstraction from implementation
- **Flyweight** - Share common state to reduce memory

### Behavioral
- **Chain of Responsibility** - Pass request through handler chain
- **Mediator** - Centralize communication between objects
- **Memento** - Save and restore object state
- **Visitor** - Add operations without modifying classes

---

## Pattern Relationships

```
┌─────────────────────────────────────────────────────────────┐
│                    CREATIONAL PATTERNS                      │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐     │
│   │Singleton │     │Factory Method│     │  Abstract    │     │
│   │          │────▶│              │────▶│  Factory     │     │
│   └──────────┘     └──────────────┘     └──────────────┘     │
│         │                                       │            │
│         │                                       ▼            │
│         │                              ┌──────────────┐      │
│         │                              │  Prototype   │      │
│         │                              └──────────────┘      │
│         │                                       │            │
│         ▼                                       ▼            │
│   ┌──────────┐                          ┌──────────────┐      │
│   │ Builder  │                          │ Object Pool  │      │
│   └──────────┘                          └──────────────┘      │
│                                                              │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    STRUCTURAL PATTERNS                       │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐     │
│   │ Adapter  │     │   Facade     │     │   Proxy      │     │
│   │          │────▶│              │◀────│              │     │
│   └──────────┘     └──────────────┘     └──────────────┘     │
│         │                  │                   │             │
│         │                  ▼                   │             │
│         │          ┌──────────────┐            │             │
│         │          │  Composite   │            │             │
│         │          └──────────────┘            │             │
│         │                  │                   │             │
│         ▼                  ▼                   ▼             │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐      │
│   │Decorator │     │   Bridge     │     │  Flyweight   │      │
│   └──────────┘     └──────────────┘     └──────────────┘      │
│                                                              │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                   BEHAVIORAL PATTERNS                        │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐     │
│   │ Strategy │     │   Observer   │     │   Command     │     │
│   │          │     │              │     │              │     │
│   └──────────┘     └──────────────┘     └──────────────┘     │
│         │                  │                   │             │
│         │                  ▼                   │             │
│         │          ┌──────────────┐            │             │
│         │          │    State     │            │             │
│         │          └──────────────┘            │             │
│         │                  │                   │             │
│         ▼                  ▼                   ▼             │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐      │
│   │Template  │     │  Iterator    │     │ Chain of     │      │
│   │ Method   │     │              │     │Responsibility│      │
│   └──────────┘     └──────────────┘     └──────────────┘      │
│         │                  │                   │              │
│         ▼                  ▼                   ▼              │
│   ┌──────────┐     ┌──────────────┐     ┌──────────────┐      │
│   │ Mediator │     │   Memento    │     │   Visitor    │      │
│   └──────────┘     └──────────────┘     └──────────────┘      │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

---

## Quick Reference: When to Use What

| Problem | Pattern |
|---------|---------|
| Only one instance needed | Singleton |
| Create objects dynamically | Factory Method |
| Build complex objects | Builder |
| Incompatible interfaces | Adapter |
| Add features dynamically | Decorator |
| Simplify complex system | Facade |
| Control object access | Proxy |
| Tree structure | Composite |
| Swap algorithms | Strategy |
| Event notification | Observer |
| Undo/Redo operations | Command |
| Common algorithm, vary steps | Template Method |
| Traverse collections | Iterator |
| Object changes behavior | State |

---

## Interview Tips

1. **Know the structure**: Class diagram, key participants
2. **Know the use cases**: 2-3 real-world examples
3. **Know the trade-offs**: When NOT to use
4. **Practice coding**: Implement from scratch in Java
5. **Compare similar patterns**: Factory vs Abstract Factory, Strategy vs State

---

## Project Structure

```
javaLowLevelDesign/
├── README.md
├── creational/
│   ├── singleton/
│   ├── factory/
│   ├── abstract-factory/
│   ├── builder/
│   └── prototype/
├── structural/
│   ├── adapter/
│   ├── decorator/
│   ├── facade/
│   ├── proxy/
│   ├── composite/
│   └── bridge/
└── behavioral/
    ├── strategy/
    ├── observer/
    ├── command/
    ├── template-method/
    ├── iterator/
    ├── state/
    └── chain-of-responsibility/
```

---

## Resources

- **Book**: "Design Patterns" by Gang of Four (GoF)
- **Book**: "Head First Design Patterns"
- **Website**: Refactoring.guru
- **Practice**: LeetCode System Design, Code implementations

---

## Learning Path

1. **Week 1-2**: Priority 1 patterns (Singleton, Factory, Builder, Adapter, Decorator, Facade, Strategy, Observer, Command)
2. **Week 3**: Priority 2 patterns
3. **Week 4**: Priority 3 patterns + comparison
4. **Ongoing**: Practice implementing from scratch

---

*Last Updated: March 2026*