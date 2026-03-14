# Elevator System — Interview follow-up questions

*Current implementation: no request queue; call and destination requests are applied immediately. The answers below describe what to add for concurrency and scale.*

## 1. “What if multiple people press buttons at the same time?” (Concurrent requests)

**What to say:**  
“We need the request queue and elevator assignment to be thread-safe. The controller receives all requests (call + destination) and assigns them; that logic should be atomic so two threads don’t corrupt the queue or assign the same elevator inconsistently.”

**What to add (conceptually):**
- Make the **ElevatorController** methods that accept requests and assign elevators **synchronized** (or use a **ReentrantLock**).
- Use a thread-safe queue (e.g. **BlockingQueue** or **synchronized** list) for pending requests.
- When an elevator updates its stop list or state, guard that with the same lock or per-elevator lock so concurrent updates don’t race.

**Minimal code idea:**
- `public synchronized void submitCallRequest(int floor, Direction direction) { ... }` and `public synchronized void submitDestinationRequest(DestinationRequest request) { ... }` on the controller.
- Elevator’s “add stop” / “remove stop” / “set state” only called from controller or from a single elevator thread, or synchronized on the elevator.

---

## 2. “How would you support different scheduling algorithms?”

**What to say:**  
“We’d use the **Strategy** pattern. The controller holds a **SchedulingStrategy** (e.g. nearest elevator, SCAN, load-balanced). When a call request arrives, we call `strategy.selectElevator(callRequest, elevators)` and assign the request to the returned elevator. We can switch strategies at runtime or by configuration.”

**What to add (if they want code):**
- **SchedulingStrategy** interface: e.g. `Elevator selectElevator(CallRequest request, List<Elevator> elevators)`.
- Implementations: **FirstIdleStrategy** (nearest idle), **NearestIdleOrSameDirectionStrategy**, or **ScanStrategy**, **LeastLoadedStrategy**.
- **ElevatorController** has a `SchedulingStrategy schedulingStrategy` field and `setSchedulingStrategy(SchedulingStrategy)`; uses it in `selectElevator()` when processing call requests.
- *(Already implemented in this project.)*

---

## 3. “What if an elevator fails or goes into maintenance?”

**What to say:**  
“We’d add an **out-of-service** or **maintenance** state to the elevator. The controller would exclude such elevators when selecting one for a call. Pending requests already assigned to that elevator could be re-queued or reassigned to another elevator. We might also expose a way to mark an elevator as failed/maintenance from the system.”

**What to add (conceptually):**
- **ElevatorState** (or enum): add **MAINTENANCE** or **OUT_OF_SERVICE**; elevator in this state doesn’t move and isn’t chosen by the scheduler.
- **ElevatorController**: when selecting elevator for a call, filter out elevators in MAINTENANCE/OUT_OF_SERVICE.
- Optional: method `setElevatorOutOfService(int elevatorId)` that sets that elevator’s state and optionally reassigns its pending stops to other elevators.
- No need to code it unless they ask; describing is usually enough.

---

## 4. “How do you make the system thread-safe?”

**What to say:**  
“We need to protect shared mutable state: the controller’s request queue, each elevator’s stop list and state, and the logic that assigns requests to elevators. The minimal change is to make the controller’s request submission and assignment **synchronized**, and ensure each elevator’s state and stop list are only updated under a lock (e.g. synchronized methods on the elevator or a lock held by the controller when it updates an elevator).”

**What to add (minimal):**
- **ElevatorController**: `synchronized` on `submitCallRequest`, `submitDestinationRequest`, and any method that picks an elevator and updates its stops.
- **Elevator**: `synchronized` on methods that modify state or stop list (e.g. `addStop`, `removeStop`, `setState`, `getCurrentFloor` if updated by multiple threads).
- If one thread runs the “movement loop” per elevator and the controller runs in another, use a thread-safe queue for commands to the elevator, or the same lock when controller adds a stop and movement loop reads/removes stops.

**In short:**
- **Concurrent requests** → synchronized (or lock) on controller request handling and assignment.
- **Different scheduling** → Strategy pattern for “which elevator.”
- **Fault tolerance** → MAINTENANCE/OUT_OF_SERVICE state; controller excludes such elevators.
- **Thread-safe** → synchronized (or ReentrantLock) on controller and elevator state/stop updates.
