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

## Important Low Level Design Questions

Classic LLD problems frequently asked in interviews. Practice designing classes, relationships, and key flows before coding.

### LLD Interview Problems (core 12)

Matches the standard “LLD Interview Problems” list; practice these first. Difficulty: **M** = Medium, **H** = Hard.

| # | Problem | Difficulty | What to design | Key patterns |
|---|---------|------------|-----------------|---------------|
| 1 | **Design Tic-Tac-Toe Game** | M | Board, 2 players, move, win/draw check, turn | State, Strategy (validation) |
| 2 | **Design Chess Game** | H | Board, pieces, moves, capture, check/checkmate, turn | State, Strategy (move rules) |
| 3 | **Design Snake & Food Game** | M | Board, snake (body segments), food, grow, direction, collision, score | State, Observer (score/game over) |
| 4 | **Design Parking Lot** | M | Slots (bike/car/truck), vehicle types, assign/release, payment | State, Strategy (pricing), Factory |
| 5 | **Design Elevator System** | H | Elevator, floors, requests (up/down), scheduling (SCAN), door | State, Command, Observer |
| 6 | **Design Inventory Management System** | M | Products, stock, add/remove/reserve, low-stock alert, orders | State, Observer (alerts) |
| 7 | **Design Car Rental System** | M | Vehicles, booking by date, return, pricing, availability | State, Strategy (pricing) |
| 8 | **Design Vending Machine** | M | Items, coins/notes, select, dispense, change | State, Strategy (payment) |
| 9 | **Design File System** | H | Directories, files, search, permissions, tree | Composite, Proxy (lazy) |
| 10 | **Design Logging System** | M | Log levels, handlers (file/console), format, async | Chain of Responsibility, Singleton |
| 11 | **Design Splitwise** | H | Users, expenses, split (equal/percent/custom), balances, settle | Strategy (split), data structures |
| 12 | **Design ATM Machine** | M | Card, PIN, account, withdraw/deposit/balance, transaction log | State, Command, Singleton (session) |

### LLD + Concurrency Interview Problems

These add concurrency/thread-safety and distributed-style thinking.

| # | Problem | What to design | Key patterns / concepts |
|---|---------|----------------|--------------------------|
| 1 | **Design Movie Ticket Booking System** | Theatres, shows, seats, book/cancel, concurrent booking, lock seats | State (seat), locking, idempotency |
| 2 | **Design Cache** | Get/put, eviction (LRU/LFU), TTL, thread-safe, capacity | Strategy (eviction), concurrent structures |
| 3 | **Design Pub-Sub Model (e.g. Kafka-style)** | Topics, producers, consumers, offset, partition, delivery | Observer, queue, at-least-once / exactly-once |
| 4 | **Design Rate Limiter (LLD)** | Limit by user/IP, sliding window or token bucket, allow/deny, thread-safe | Strategy (algorithm), Singleton (config) |

### Concurrency in Java (9 topics)

Assignments in `Concurrency/` — skeleton code + TODOs; run with `make run-conc-<name>`.

| # | Topic | Assignment | Make target |
|---|-------|------------|-------------|
| 1 | **Threads — Thread class and Runnable** | PrintTask + start/join | `make run-conc-threads` |
| 2 | **Thread pool and thread lifecycle** | Worker + ExecutorService | `make run-conc-pool` |
| 3 | **Thread Executors** | SumTask (Callable) + Future | `make run-conc-exec` |
| 4 | **Thread Synchronization** | Counter (synchronized increment) | `make run-conc-sync` |
| 5 | **Thread Communication** | SharedBuffer (wait/notify) | `make run-conc-comm` |
| 6 | **Locks and types of locks** | ResourceWithLock (ReentrantLock) | `make run-conc-locks` |
| 7 | **Semaphore** | PermitTask (acquire/release) | `make run-conc-sem` |
| 8 | **Java Concurrent Collections** | ConcurrentHashMap + AtomicInteger | `make run-conc-coll` |
| 9 | **Future and CompletableFuture** | supplyAsync + thenApply | `make run-conc-cf` |

### Concurrency Interview Problems (5)

| # | Problem | Difficulty | Make target |
|---|---------|------------|-------------|
| 1 | **Print Zero Even Odd** | Medium | `make run-conc-zero-even-odd` |
| 2 | **Fizz Buzz Multithreaded** | Medium | `make run-conc-fizzbuzz` |
| 3 | **Design Bounded Blocking Queue** | Medium | `make run-conc-bbq` |
| 4 | **The Dining Philosophers** | Hard | `make run-conc-dining` |
| 5 | **Multithreaded Web Crawler** | Hard | `make run-conc-crawler` |

### Very Common (extended list)

| Question | What to design | Key patterns / concepts |
|----------|----------------|--------------------------|
| **Parking Lot** | Slots (types: bike/car/truck), vehicle types, assign/release slot, payment | State, Strategy (pricing), maybe Factory |
| **Elevator / Lift** | Elevator, floors, requests (up/down), scheduling (e.g. SCAN), door open/close | State, Command, Observer |
| **Library Management** | Books, members, borrow/return, reservations, fines | State (book status), Strategy (fine calculation) |
| **Vending Machine** | Items, coins/notes, select item, dispense, change | State, Strategy (payment) |
| **ATM / Banking** | Card, PIN, account, withdraw/deposit/balance, transaction log | State, Command, Singleton (session) |
| **Chess / Tic-Tac-Toe** | Board, pieces, moves, win/draw check, turn | State, Strategy (move validation) |
| **Hotel Booking** | Rooms, room types, dates, booking/cancel, search | Factory (room types), State (booking status) |
| **Restaurant / Food Ordering** | Menu, order, kitchen, payment, table | Command (order), Observer (notify kitchen), State |
| **Deck of Cards / Blackjack** | Deck, card, shuffle, deal, hand, rules | Factory, State (game state) |
| **Rate Limiter** | Limit by user/IP, sliding window or token bucket, allow/deny | Strategy (algorithm), Singleton (config) |

### Common

| Question | What to design | Key patterns / concepts |
|----------|----------------|--------------------------|
| **Online Chess (multiplayer)** | Board, players, move validation, turn, sync | State, Observer (notify other player) |
| **Snakes and Ladders** | Board, dice, players, snakes/ladders, win condition | State, simple OOP |
| **Movie Ticket Booking** | Theatres, shows, seats, book/cancel, payment | Factory (seat types), State (seat status) |
| **Splitwise** | Users, expenses, split (equal/percent/custom), balances | Strategy (split type), data structures for balances |
| **Amazon / E-commerce (LLD)** | Product, cart, order, payment, inventory | Observer (inventory), Strategy (payment), State (order) |
| **File System** | Directories, files, search, permissions | Composite, Proxy (lazy load) |
| **Logger** | Log levels, multiple handlers (file/console), format | Chain of Responsibility, Singleton |
| **Notification System** | Channels (email/SMS/push), users, send | Strategy (channel), Observer |
| **Traffic Light Controller** | Lights, phases, timers, sensors | State, Observer |
| **Coffee Vending Machine** | Ingredients, recipes, dispense, refill | State, Strategy (recipe) |

### Good to know

| Question | What to design | Key patterns / concepts |
|----------|----------------|--------------------------|
| **Car Rental** | Vehicles, booking by date, return, pricing | State, Strategy (pricing) |
| **Online Auction** | Item, bid, bidder, close auction, winner | Observer (outbid), State |
| **Parking Lot (multi-floor)** | Floors, slot types, display board | Composite (floor → slots), Observer |
| **LRU Cache** | Get/put, eviction when full | Data structure (map + doubly linked list) |
| **Design a Map (like Google Maps)** | Location, route, shortest path | Graph, algorithms (BFS/Dijkstra) — LLD focuses on classes |
| **WhatsApp / Chat (LLD)** | User, chat, message, group, send/deliver/read | Observer, Mediator (group) |
| **Uber / Cab Booking (LLD)** | Rider, driver, trip, location, matching | State (trip), Observer (location updates) |
| **Calendar / Meeting Scheduler** | Events, rooms, conflict check, invitees | State, Strategy (scheduling) |
| **Trello / Kanban Board** | Board, list, card, move card, assignee | State, Observer, Composite (board → lists → cards) |
| **YouTube (LLD)** | User, video, playlist, like/comment, recommend | Observer, Strategy (recommendation stub) |

### How to use this list

1. **Pick 5–8** from “Very Common” and design on paper/whiteboard (classes, main methods, 1–2 flows).
2. **Code 2–3** end-to-end (e.g. Parking Lot, Elevator, Vending Machine) in Java using patterns from this repo.
3. For each: identify **entities**, **states**, **who notifies whom**, and which **pattern** fits (State, Strategy, Observer, Command, etc.).

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
├── Concurrency/
│   ├── ThreadsRunnable/          # Thread + Runnable (PrintTask) + ThreadsRunnableTest
│   ├── ThreadPoolLifecycle/      # Thread pool, Worker + ThreadPoolLifecycleTest
│   ├── ThreadExecutors/          # ExecutorService, Callable (SumTask) + ThreadExecutorsTest
│   ├── Synchronization/          # Counter (synchronized) + SynchronizationTest
│   ├── ThreadCommunication/      # wait/notify (SharedBuffer) + ThreadCommunicationTest
│   ├── Locks/                    # ReentrantLock (ResourceWithLock) + LocksTest
│   ├── Semaphore/                # Semaphore (PermitTask) + SemaphoreTest
│   ├── ConcurrentCollections/    # ConcurrentHashMap, AtomicInteger + ConcurrentCollectionsTest
│   ├── CompletableFuture/        # CompletableFutureTest
│   ├── ZeroEvenOdd/              # Print Zero Even Odd (LeetCode 1116) + ZeroEvenOddTest
│   ├── FizzBuzzMultithreaded/    # Fizz Buzz multithreaded (LeetCode 1195) + FizzBuzzTest
│   ├── BoundedBlockingQueue/     # Bounded blocking queue (LeetCode 1188) + BoundedBlockingQueueTest
│   ├── DiningPhilosophers/       # Dining philosophers (LeetCode 1226) + DiningPhilosophersTest
│   └── MultithreadedWebCrawler/   # Multithreaded web crawler (LeetCode 1242) + WebCrawlerTest
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

### Concurrency — run one test

| Command | Description |
|--------|-------------|
| `make run-conc-threads` | Threads & Runnable |
| `make run-conc-pool` | Thread pool & lifecycle |
| `make run-conc-exec` | Thread Executors (Callable/Future) |
| `make run-conc-sync` | Synchronization (Counter) |
| `make run-conc-comm` | Thread communication (wait/notify) |
| `make run-conc-locks` | Locks (ReentrantLock) |
| `make run-conc-sem` | Semaphore |
| `make run-conc-coll` | Concurrent collections |
| `make run-conc-cf` | CompletableFuture |
| `make run-conc-zero-even-odd` | Zero Even Odd |
| `make run-conc-fizzbuzz` | Fizz Buzz multithreaded |
| `make run-conc-bbq` | Bounded blocking queue |
| `make run-conc-dining` | Dining philosophers |
| `make run-conc-crawler` | Multithreaded web crawler |

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