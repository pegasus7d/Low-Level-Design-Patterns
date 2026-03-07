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

## SOLID Principles

Foundational OO principles; each has a small assignment in `SolidPrinciples/`.

| Principle | Description | Example in repo |
|-----------|-------------|------------------|
| **S**ingle Responsibility | One class, one reason to change | ReportGenerator (generate) vs ReportRepository (save) |
| **O**pen/Closed | Open for extension, closed for modification | New shapes (e.g. Triangle) without changing Circle/Rectangle |
| **L**iskov Substitution | Subtypes substitutable for base type | Square as its own type (not extending Rectangle) |
| **I**nterface Segregation | Don’t depend on interfaces you don’t use | Robot implements only Workable, not Eatable |
| **D**ependency Inversion | Depend on abstractions, not concretions | UserService depends on MessageSender, not EmailSender |

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
├── Priority1/
│   ├── BuilderPattern/
│   │   ├── PizzaExample/       # Pizza + PizzaBuilderTest
│   │   └── LaptopExample/      # Laptop + LaptopBuilderTest
│   ├── Singleton/
│   │   └── LoggerExample/      # Logger + LoggerSingletonTest
│   ├── FactoryMethod/
│   │   └── PaymentExample/     # Payment, PaymentFactory + PaymentFactoryTest
│   ├── Adapter/
│   │   └── MediaPlayerExample/  # MediaPlayer, VlcPlayerAdapter + AdapterTest
│   ├── Decorator/
│   │   └── CoffeeExample/      # Beverage, CoffeeDecorator + CoffeeDecoratorTest
│   ├── Facade/
│   │   └── HomeTheaterExample/ # HomeTheaterFacade + FacadeTest
│   ├── Strategy/
│   │   └── PaymentStrategyExample/ # PaymentStrategy, ShoppingCart + StrategyTest
│   ├── Observer/
│   │   └── WeatherExample/     # WeatherSubject, DisplayObserver + ObserverTest
│   └── Command/
│       └── TextEditorExample/  # Command, CommandInvoker + CommandTest
├── Priority2/
│   ├── AbstractFactory/
│   │   └── UIThemeExample/     # GUIFactory, Dark/Light themes + AbstractFactoryTest
│   ├── Prototype/
│   │   └── ShapeExample/       # Shape, Circle clone + PrototypeTest
│   ├── Proxy/
│   │   └── ImageExample/       # Image, ImageProxy (lazy) + ProxyTest
│   ├── Composite/
│   │   └── FileSystemExample/  # FileSystemComponent, File, Folder + CompositeTest
│   ├── TemplateMethod/
│   │   └── DataProcessorExample/ # DataProcessor, CsvProcessor + TemplateMethodTest
│   ├── Iterator/
│   │   └── CollectionExample/ # SimpleCollection, SimpleIterator + IteratorTest
│   └── State/
│       └── VendingMachineExample/ # VendingState, VendingMachine + StateTest
├── Priority3/
│   ├── ObjectPool/
│   │   └── ConnectionPoolExample/ # ConnectionPool, PooledConnection + ObjectPoolTest
│   ├── Bridge/
│   │   └── DeviceRemoteExample/   # Device, RemoteControl (Bridge) + BridgeTest
│   ├── Flyweight/
│   │   └── CharacterExample/      # FlyweightCharacter, CharacterFactory + FlyweightTest
│   ├── ChainOfResponsibility/
│   │   └── LoggerExample/         # LogHandler chain + ChainOfResponsibilityTest
│   ├── Mediator/
│   │   └── ChatRoomExample/       # ChatMediator, ChatRoom, User + MediatorTest
│   ├── Memento/
│   │   └── EditorExample/        # Memento, Editor, History + MementoTest
│   └── Visitor/
│       └── ShapeVisitorExample/   # Shape, ShapeVisitor, AreaVisitor + VisitorTest
├── SolidPrinciples/
│   ├── SingleResponsibility/
│   │   └── ReportExample/         # ReportGenerator, ReportRepository + SRPTest
│   ├── OpenClosed/
│   │   └── ShapeExample/          # Shape, Circle, Rectangle, Triangle + OpenClosedTest
│   ├── LiskovSubstitution/
│   │   └── ShapeExample/          # Rectangle, Square + LSPTest
│   ├── InterfaceSegregation/
│   │   └── WorkerExample/         # Workable, Eatable, Human, Robot + ISPTest
│   └── DependencyInversion/
│       └── NotificationExample/   # MessageSender, EmailSender, UserService + DIPTest
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

## Make commands for tests

From the **project root** (`javaLowLevelDesign/`), use `make` to compile and run tests. Each `run-*` target compiles **only that example** (so incomplete skeletons like Laptop don’t break others), then runs the test.

### General commands

| Command | Description |
|--------|-------------|
| `make build` | Compile **all** examples to `out/` (fails if any example is incomplete). |
| `make clean` | Remove the `out/` directory. |
| `make help` | Print a short list of run targets. |

### Priority 1 – run one test

| Command | Example / test run |
|--------|---------------------|
| `make run-pizza` | Builder (Pizza) |
| `make run-laptop` | Builder (Laptop) |
| `make run-logger` | Singleton (Logger) |
| `make run-payment-factory` | Factory Method (Payment) |
| `make run-adapter` | Adapter (MediaPlayer) |
| `make run-decorator` | Decorator (Coffee) |
| `make run-facade` | Facade (HomeTheater) |
| `make run-strategy` | Strategy (ShoppingCart) |
| `make run-observer` | Observer (Weather) |
| `make run-command` | Command (TextEditor) |

**Run all Priority 1 tests:**  
`make run-p1` (runs the 10 commands above in sequence).

### Priority 2 – run one test

| Command | Example / test run |
|--------|---------------------|
| `make run-abstract-factory` | Abstract Factory (UI theme) |
| `make run-prototype` | Prototype (Shape/Circle) |
| `make run-proxy` | Proxy (lazy Image) |
| `make run-composite` | Composite (file system) |
| `make run-template` | Template Method (data processor) |
| `make run-iterator` | Iterator (collection) |
| `make run-state` | State (vending machine) |

### Priority 3 – run one test

| Command | Example / test run |
|--------|---------------------|
| `make run-pool` | Object Pool (connection pool) |
| `make run-bridge` | Bridge (device remote) |
| `make run-flyweight` | Flyweight (character) |
| `make run-chain` | Chain of Responsibility (logger) |
| `make run-mediator` | Mediator (chat room) |
| `make run-memento` | Memento (editor undo) |
| `make run-visitor` | Visitor (shape area) |

### SOLID principles – run one test

| Command | Example / test run |
|--------|---------------------|
| `make run-srp` | Single Responsibility (Report generate + save) |
| `make run-ocp` | Open/Closed (Shape + Triangle) |
| `make run-lsp` | Liskov Substitution (Square) |
| `make run-isp` | Interface Segregation (Robot / Workable) |
| `make run-dip` | Dependency Inversion (UserService + MessageSender) |

### Usage

```bash
cd javaLowLevelDesign
make run-pizza
```

Requires Java (e.g. JDK 11+) and `make`. Output is written to `out/` (in `.gitignore`).

---

## How We Create Assignments (Pattern & Workflow)

This section describes the **assignment pattern** used in this repo: how examples are structured, who implements what, and how to run them.

### Workflow

| Role | Responsibility |
|------|----------------|
| **Setup (skeleton)** | Provide the pattern file (e.g. `Pizza.java`, `Laptop.java`) with **TODO comments** for fields, constructor, getters, and builder inner class. No package; minimal comments. |
| **You (learner)** | Implement the design pattern in the main class (e.g. fill in `Pizza`, `Laptop`) by following the TODOs. |
| **Tests** | Test class (e.g. `PizzaBuilderTest.java`) is **mostly complete**. Only **one** test method is left for you to implement: **creating the object using the builder** (e.g. replace `null` with the builder chain). All other test methods are already written. |

So: **you implement the pattern + one “builder call” in the test**; the rest of the test code is given.

### Per-pattern structure

For each pattern we add **one folder per example** under the pattern (e.g. Builder → PizzaExample, LaptopExample):

```
Priority1/BuilderPattern/
├── PizzaExample/
│   ├── Pizza.java           ← You implement (TODOs: fields, constructor, getters, Builder class)
│   └── PizzaBuilderTest.java ← You implement one method (e.g. testBasicPizza: create Pizza via builder)
└── LaptopExample/
    ├── Laptop.java
    └── LaptopBuilderTest.java
```

- **Naming:** `&lt;Thing&gt;.java` (the product) and `&lt;Thing&gt;BuilderTest.java` (the test runner).
- **Packages:** Each example has its own package (e.g. `Priority1.BuilderPattern.PizzaExample`) so duplicate class names (e.g. `Circle` in Prototype vs Visitor) don’t conflict. Each test can be run independently.
- **Independent:** Each example folder is self-contained; run by its main class (see below).

### What you implement

1. **In the product class (e.g. `Pizza.java`, `Laptop.java`):**
   - Final fields, private constructor taking the builder, getters, static inner Builder class with mutable fields, setter methods that return `this`, and `build()`.

2. **In the test class (e.g. `PizzaBuilderTest.java`):**
   - Only **one** method where you **create the object** (e.g. `Pizza pizza = new Pizza.PizzaBuilder().size("Large").addCheese().build();`). The rest of the tests are already implemented.

### How to run (independently)

- **From IDE:**  
  Use **one source root** (project root). Run the main class for the example you want, e.g.:
  - `Priority1.BuilderPattern.PizzaExample.PizzaBuilderTest`
  - `Priority2.Prototype.ShapeExample.PrototypeTest`
  - `Priority3.Visitor.ShapeVisitorExample.VisitorTest`  
  Each example has its own package, so you can run any test without conflicts (e.g. `Circle` in Prototype vs Visitor).
- **From terminal (project root) – use the Makefile:** see **Make commands for tests** below.
  Manual compile/run (no Makefile):
  - `javac -d out -sourcepath . Priority1/BuilderPattern/PizzaExample/*.java`
  - `java -cp out Priority1.BuilderPattern.PizzaExample.PizzaBuilderTest`

### Summary

- One **pattern** (e.g. Builder) → multiple **examples** (Pizza, Laptop), each in its own folder and package.
- You **implement the pattern** in the main class and **one builder-call** in the test; everything else is provided.
- Each example is **independent**; run with `make run-<name>` or from the IDE using its main class.

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
4. **SOLID**: `SolidPrinciples/` — SRP, OCP, LSP, ISP, DIP assignments (`make run-srp`, `run-ocp`, etc.)
5. **Ongoing**: Practice implementing from scratch

---

*Last Updated: March 2026*