# Parking Lot — Interview follow-up questions

## 1. “What if two cars try to take the same slot?”

**What to say:**  
“Right now two threads could both see the same slot as available and both assign it. We need to make slot assignment atomic: only one thread can run the ‘find slot + mark occupied’ logic at a time.”

**What to add (conceptually):**
- Make **assignSlot** (and usually **releaseSlot**) **synchronized** so the whole “find available slot + mark occupied” (or “mark available”) happens as one atomic step.
- Alternatively: use a **ReentrantLock** on the parking lot (or per slot) and lock around the same logic.

**Minimal code idea:**
- In **ParkingLot**, declare: `public synchronized Ticket assignSlot(Vehicle vehicle) { ... }` and `public synchronized void releaseSlot(Ticket ticket) { ... }` (keep the rest of the method body the same).
- That way two threads can’t run assignSlot (or releaseSlot) at the same time, so two cars can’t get the same slot.

---

## 2. “How would you support multiple floors?”

**What to say:**  
“We’d introduce a **Floor** entity. Each floor has an id/name and a list of **ParkingSlot**s. **ParkingLot** then holds a list of **Floor**s instead of a flat list of slots. To find a slot we iterate over floors and then over that floor’s slots (e.g. first available for the vehicle type). Slot could hold a reference to its floor or a floorId for display/routing. Assign and release stay the same; we just change how we search for an available slot.”

**What to add (if they want code):**
- **Floor**: id/name, `List<ParkingSlot> slots`.
- **ParkingLot**: `List<Floor> floors`; in **findAvailableSlot** loop over floors, then over each floor’s slots.
- **ParkingSlot** (optional): `floorId` or `Floor floor` for “which floor is this on.”
- No need to code it unless they ask; describing this is usually enough.

---

## 3. “How do you make it thread-safe?”

**What to say:**  
“We need to protect shared mutable state: the list of slots and their status, and the ticket counter. The minimal change is to make **assignSlot** and **releaseSlot** **synchronized** so that finding a slot and marking it occupied (or marking it available) is atomic. If we add observers, we’d either make the observer list thread-safe (e.g. copy before iterating) or document that observers are registered at startup only.”

**What to add (minimal):**
- **assignSlot**: `public synchronized Ticket assignSlot(Vehicle vehicle) { ... }`
- **releaseSlot**: `public synchronized void releaseSlot(Ticket ticket) { ... }`
- **ticketCounter** is only updated inside assignSlot, which is now synchronized, so it’s covered.
- Optionally **processExit** can stay unsynchronized if it just calls **releaseSlot** (which is synchronized), or you make **processExit** synchronized if you want the whole exit to be one critical section.

**In short:**
- **Same slot** → make assign/release **synchronized** (or use a lock).
- **Multiple floors** → describe **Floor** + slot–floor mapping; code only if they ask.
- **Thread-safe** → same as first: **synchronized** on **assignSlot** and **releaseSlot** (and optionally **processExit**), and explain that this makes slot assignment and release atomic.
