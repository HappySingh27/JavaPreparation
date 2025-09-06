package multithreading;

/*
*
* 🔹 Java MultiThreading Synchronization Concepts — Quick Notes
*
* 1) Synchronization
*    - Mechanism to control access to shared resources in MultiThreading.
*    - Ensures only one thread at a time can access a critical section.
*    - Prevents data inconsistency and race conditions.
*
* 2) synchronized keyword
*    - Used to mark a method or a block of code as synchronized.
*    - When a thread enters a synchronized method/block, it acquires the lock
*      (monitor) of the object (or class, if static).
*    - Other threads must wait until the lock is released.
*    - Example: public synchronized void increment() { ... }
*
* 3) synchronized block
*    - A smaller section of code wrapped with synchronized(object) { ... }.
*    - Provides more fine-grained control than synchronizing the entire method.
*    - Improves performance by locking only the necessary part of the code.
*
* 4) Critical Section
*    - The part of code that accesses shared resources and must not be executed
*      by more than one thread at a time.
*    - Typically wrapped in synchronized methods or synchronized blocks.
*
* 5) Shared Resources
*    - Variables, objects, files, or data structures that multiple threads access.
*    - Example: shared counters, collections, database connections.
*    - Without synchronization, multiple threads may corrupt the state of shared data.
*
* 6) Race Condition
*    - A situation where the program output depends on the unpredictable timing
*      of threads.
*    - Occurs when multiple threads access and modify shared resources
*      without proper synchronization.
*    - Leads to inconsistent or incorrect results.
*
* 7) Mutual Exclusion (Mutex)
*    - A property of synchronization that ensures only one thread executes
*      a critical section at a time.
*    - Achieved using synchronized keyword in Java (locks/monitors).
*
* 🔹 Key Point:
* - Synchronization is essential to ensure thread safety when working with shared resources.
* - synchronized (methods or blocks) → enforce mutual exclusion.
* - Critical section → code where race conditions can occur.
* - Shared resources must be accessed carefully in MultiThreaded environments.
*/

// complete this class for by practicing
public class Synchronization {

}
