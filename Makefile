# Java LLD patterns - compile and run tests from project root
# Usage: make build && make run-pizza   OR   make run-pizza (builds if needed)

OUT = out
JAVAC = javac -d $(OUT) -sourcepath .
JAVA = java -cp $(OUT)

# All example dirs (source paths)
P1_PIZZA    = Priority1/BuilderPattern/PizzaExample
P1_LAPTOP   = Priority1/BuilderPattern/LaptopExample
P1_LOGGER   = Priority1/Singleton/LoggerExample
P1_PAYMENT  = Priority1/FactoryMethod/PaymentExample
P1_ADAPTER  = Priority1/Adapter/MediaPlayerExample
P1_DECORATOR= Priority1/Decorator/CoffeeExample
P1_FACADE   = Priority1/Facade/HomeTheaterExample
P1_STRATEGY = Priority1/Strategy/PaymentStrategyExample
P1_OBSERVER = Priority1/Observer/WeatherExample
P1_COMMAND  = Priority1/Command/TextEditorExample
P2_ABSTRACT = Priority2/AbstractFactory/UIThemeExample
P2_PROTOTYPE = Priority2/Prototype/ShapeExample
P2_PROXY    = Priority2/Proxy/ImageExample
P2_COMPOSITE = Priority2/Composite/FileSystemExample
P2_TEMPLATE = Priority2/TemplateMethod/DataProcessorExample
P2_ITERATOR = Priority2/Iterator/CollectionExample
P2_STATE    = Priority2/State/VendingMachineExample
P3_POOL     = Priority3/ObjectPool/ConnectionPoolExample
P3_BRIDGE   = Priority3/Bridge/DeviceRemoteExample
P3_FLYWEIGHT = Priority3/Flyweight/CharacterExample
P3_CHAIN    = Priority3/ChainOfResponsibility/LoggerExample
P3_MEDIATOR = Priority3/Mediator/ChatRoomExample
P3_MEMENTO  = Priority3/Memento/EditorExample
P3_VISITOR  = Priority3/Visitor/ShapeVisitorExample
SOLID_SRP   = SolidPrinciples/SingleResponsibility/ReportExample
SOLID_OCP   = SolidPrinciples/OpenClosed/ShapeExample
SOLID_LSP   = SolidPrinciples/LiskovSubstitution/ShapeExample
SOLID_ISP   = SolidPrinciples/InterfaceSegregation/WorkerExample
SOLID_DIP   = SolidPrinciples/DependencyInversion/NotificationExample
CONC_THREADS = Concurrency/ThreadsRunnable
CONC_POOL   = Concurrency/ThreadPoolLifecycle
CONC_EXEC   = Concurrency/ThreadExecutors
CONC_SYNC   = Concurrency/Synchronization
CONC_COMM   = Concurrency/ThreadCommunication
CONC_LOCKS  = Concurrency/Locks
CONC_SEM    = Concurrency/Semaphore
CONC_COLL   = Concurrency/ConcurrentCollections
CONC_CF     = Concurrency/CompletableFuture
CONC_ZEO    = Concurrency/ZeroEvenOdd
CONC_FB     = Concurrency/FizzBuzzMultithreaded
CONC_BBQ    = Concurrency/BoundedBlockingQueue
CONC_DP     = Concurrency/DiningPhilosophers
CONC_CRAWL  = Concurrency/MultithreadedWebCrawler
PARKING_LOT = Questions/ParkingLot
ELEVATOR_SYSTEM = Questions/ElevatorSystem

# Build: compile ALL examples (fails if any skeleton is incomplete; use run-* to build/run one)
build:
	@mkdir -p $(OUT)
	@$(JAVAC) $(P1_PIZZA)/*.java $(P1_LAPTOP)/*.java $(P1_LOGGER)/*.java $(P1_PAYMENT)/*.java
	@$(JAVAC) $(P1_ADAPTER)/*.java $(P1_DECORATOR)/*.java $(P1_FACADE)/*.java $(P1_STRATEGY)/*.java $(P1_OBSERVER)/*.java $(P1_COMMAND)/*.java
	@$(JAVAC) $(P2_ABSTRACT)/*.java $(P2_PROTOTYPE)/*.java $(P2_PROXY)/*.java $(P2_COMPOSITE)/*.java $(P2_TEMPLATE)/*.java $(P2_ITERATOR)/*.java $(P2_STATE)/*.java
	@$(JAVAC) $(P3_POOL)/*.java $(P3_BRIDGE)/*.java $(P3_FLYWEIGHT)/*.java $(P3_CHAIN)/*.java $(P3_MEDIATOR)/*.java $(P3_MEMENTO)/*.java $(P3_VISITOR)/*.java
	@$(JAVAC) $(SOLID_SRP)/*.java $(SOLID_OCP)/*.java $(SOLID_LSP)/*.java $(SOLID_ISP)/*.java $(SOLID_DIP)/*.java
	@$(JAVAC) $(CONC_THREADS)/*.java $(CONC_POOL)/*.java $(CONC_EXEC)/*.java $(CONC_SYNC)/*.java $(CONC_COMM)/*.java $(CONC_LOCKS)/*.java $(CONC_SEM)/*.java $(CONC_COLL)/*.java $(CONC_CF)/*.java $(CONC_ZEO)/*.java $(CONC_FB)/*.java $(CONC_BBQ)/*.java $(CONC_DP)/*.java $(CONC_CRAWL)/*.java
	@echo "Build done. Class files in $(OUT)/"

# Run targets: compile ONLY that example then run (so incomplete skeletons don't break others)
run-pizza:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_PIZZA)/*.java
	$(JAVA) Priority1.BuilderPattern.PizzaExample.PizzaBuilderTest

run-laptop:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_LAPTOP)/*.java
	$(JAVA) Priority1.BuilderPattern.LaptopExample.LaptopBuilderTest

run-logger:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_LOGGER)/*.java
	$(JAVA) Priority1.Singleton.LoggerExample.LoggerSingletonTest

run-payment-factory:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_PAYMENT)/*.java
	$(JAVA) Priority1.FactoryMethod.PaymentExample.PaymentFactoryTest

run-adapter:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_ADAPTER)/*.java
	$(JAVA) Priority1.Adapter.MediaPlayerExample.AdapterTest

run-decorator:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_DECORATOR)/*.java
	$(JAVA) Priority1.Decorator.CoffeeExample.CoffeeDecoratorTest

run-facade:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_FACADE)/*.java
	$(JAVA) Priority1.Facade.HomeTheaterExample.FacadeTest

run-strategy:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_STRATEGY)/*.java
	$(JAVA) Priority1.Strategy.PaymentStrategyExample.StrategyTest

run-observer:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_OBSERVER)/*.java
	$(JAVA) Priority1.Observer.WeatherExample.ObserverTest

run-command:
	@mkdir -p $(OUT) && $(JAVAC) $(P1_COMMAND)/*.java
	$(JAVA) Priority1.Command.TextEditorExample.CommandTest

run-abstract-factory:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_ABSTRACT)/*.java
	$(JAVA) Priority2.AbstractFactory.UIThemeExample.AbstractFactoryTest

run-prototype:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_PROTOTYPE)/*.java
	$(JAVA) Priority2.Prototype.ShapeExample.PrototypeTest

run-proxy:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_PROXY)/*.java
	$(JAVA) Priority2.Proxy.ImageExample.ProxyTest

run-composite:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_COMPOSITE)/*.java
	$(JAVA) Priority2.Composite.FileSystemExample.CompositeTest

run-template:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_TEMPLATE)/*.java
	$(JAVA) Priority2.TemplateMethod.DataProcessorExample.TemplateMethodTest

run-iterator:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_ITERATOR)/*.java
	$(JAVA) Priority2.Iterator.CollectionExample.IteratorTest

run-state:
	@mkdir -p $(OUT) && $(JAVAC) $(P2_STATE)/*.java
	$(JAVA) Priority2.State.VendingMachineExample.StateTest

run-pool:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_POOL)/*.java
	$(JAVA) Priority3.ObjectPool.ConnectionPoolExample.ObjectPoolTest

run-bridge:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_BRIDGE)/*.java
	$(JAVA) Priority3.Bridge.DeviceRemoteExample.BridgeTest

run-flyweight:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_FLYWEIGHT)/*.java
	$(JAVA) Priority3.Flyweight.CharacterExample.FlyweightTest

run-chain:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_CHAIN)/*.java
	$(JAVA) Priority3.ChainOfResponsibility.LoggerExample.ChainOfResponsibilityTest

run-mediator:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_MEDIATOR)/*.java
	$(JAVA) Priority3.Mediator.ChatRoomExample.MediatorTest

run-memento:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_MEMENTO)/*.java
	$(JAVA) Priority3.Memento.EditorExample.MementoTest

run-visitor:
	@mkdir -p $(OUT) && $(JAVAC) $(P3_VISITOR)/*.java
	$(JAVA) Priority3.Visitor.ShapeVisitorExample.VisitorTest

# SOLID principles
run-srp:
	@mkdir -p $(OUT) && $(JAVAC) $(SOLID_SRP)/*.java
	$(JAVA) SolidPrinciples.SingleResponsibility.ReportExample.SRPTest
run-ocp:
	@mkdir -p $(OUT) && $(JAVAC) $(SOLID_OCP)/*.java
	$(JAVA) SolidPrinciples.OpenClosed.ShapeExample.OpenClosedTest
run-lsp:
	@mkdir -p $(OUT) && $(JAVAC) $(SOLID_LSP)/*.java
	$(JAVA) SolidPrinciples.LiskovSubstitution.ShapeExample.LSPTest
run-isp:
	@mkdir -p $(OUT) && $(JAVAC) $(SOLID_ISP)/*.java
	$(JAVA) SolidPrinciples.InterfaceSegregation.WorkerExample.ISPTest
run-dip:
	@mkdir -p $(OUT) && $(JAVAC) $(SOLID_DIP)/*.java
	$(JAVA) SolidPrinciples.DependencyInversion.NotificationExample.DIPTest

# Concurrency (concepts)
run-conc-threads:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_THREADS)/*.java
	$(JAVA) Concurrency.ThreadsRunnable.ThreadsRunnableTest
run-conc-pool:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_POOL)/*.java
	$(JAVA) Concurrency.ThreadPoolLifecycle.ThreadPoolLifecycleTest
run-conc-exec:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_EXEC)/*.java
	$(JAVA) Concurrency.ThreadExecutors.ThreadExecutorsTest
run-conc-sync:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_SYNC)/*.java
	$(JAVA) Concurrency.Synchronization.SynchronizationTest
run-conc-comm:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_COMM)/*.java
	$(JAVA) Concurrency.ThreadCommunication.ThreadCommunicationTest
run-conc-locks:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_LOCKS)/*.java
	$(JAVA) Concurrency.Locks.LocksTest
run-conc-sem:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_SEM)/*.java
	$(JAVA) Concurrency.Semaphore.SemaphoreTest
run-conc-coll:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_COLL)/*.java
	$(JAVA) Concurrency.ConcurrentCollections.ConcurrentCollectionsTest
run-conc-cf:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_CF)/*.java
	$(JAVA) Concurrency.CompletableFuture.CompletableFutureTest
# Concurrency (interview problems)
run-conc-zero-even-odd:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_ZEO)/*.java
	$(JAVA) Concurrency.ZeroEvenOdd.ZeroEvenOddTest
run-conc-fizzbuzz:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_FB)/*.java
	$(JAVA) Concurrency.FizzBuzzMultithreaded.FizzBuzzTest
run-conc-bbq:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_BBQ)/*.java
	$(JAVA) Concurrency.BoundedBlockingQueue.BoundedBlockingQueueTest
run-conc-dining:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_DP)/*.java
	$(JAVA) Concurrency.DiningPhilosophers.DiningPhilosophersTest
run-conc-crawler:
	@mkdir -p $(OUT) && $(JAVAC) $(CONC_CRAWL)/*.java
	$(JAVA) Concurrency.MultithreadedWebCrawler.WebCrawlerTest

# LLD Questions - Parking Lot
run-parking-lot:
	@mkdir -p $(OUT) && $(JAVAC) $(PARKING_LOT)/*.java
	$(JAVA) Questions.ParkingLot.ParkingLotMain

# LLD Questions - Elevator System
run-elevator:
	@mkdir -p $(OUT) && $(JAVAC) $(ELEVATOR_SYSTEM)/*.java
	$(JAVA) Questions.ElevatorSystem.ElevatorMain

# Run all Priority1 tests (each compiles only its own example)
run-p1: run-pizza run-laptop run-logger run-payment-factory run-adapter run-decorator run-facade run-strategy run-observer run-command

# Clean
clean:
	rm -rf $(OUT)
	@echo "Cleaned $(OUT)/"

# Help
help:
	@echo "Java LLD - run tests from project root:"
	@echo "  make build          - compile all examples to $(OUT)/"
	@echo "  make run-pizza      - build + run Pizza Builder test"
	@echo "  make run-laptop     - build + run Laptop Builder test"
	@echo "  make run-logger     - build + run Singleton test"
	@echo "  make run-payment-factory run-adapter run-decorator run-facade run-strategy run-observer run-command"
	@echo "  make run-abstract-factory run-prototype run-proxy run-composite run-template run-iterator run-state"
	@echo "  make run-pool run-bridge run-flyweight run-chain run-mediator run-memento run-visitor"
	@echo "  make run-srp run-ocp run-lsp run-isp run-dip   - SOLID principles"
	@echo "  make run-conc-threads run-conc-pool ... run-conc-crawler  - Concurrency"
	@echo "  make run-parking-lot - Parking Lot LLD (entry + exit + observers)"
	@echo "  make run-elevator   - Elevator System LLD (State, Strategy, Observer)"
	@echo "  make run-p1         - run all Priority1 tests"
	@echo "  make clean         - remove $(OUT)/"

.PHONY: build clean help run-pizza run-laptop run-logger run-payment-factory run-adapter run-decorator run-facade run-strategy run-observer run-command run-abstract-factory run-prototype run-proxy run-composite run-template run-iterator run-state run-pool run-bridge run-flyweight run-chain run-mediator run-memento run-visitor run-srp run-ocp run-lsp run-isp run-dip run-conc-threads run-conc-pool run-conc-exec run-conc-sync run-conc-comm run-conc-locks run-conc-sem run-conc-coll run-conc-cf run-conc-zero-even-odd run-conc-fizzbuzz run-conc-bbq run-conc-dining run-conc-crawler run-parking-lot run-elevator run-p1
