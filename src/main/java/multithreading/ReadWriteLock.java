package multithreading;


/*
  ===== ReadWriteLock Notes =====

  ❓ What is a ReadWriteLock?
  ✅ A ReadWriteLock is a special type of lock that maintains two separate locks:
     - A readLock, which can be held simultaneously by multiple reader threads
       as long as there is no writer.
     - No writer is allowed, until a reader is holding a lock
     - A writeLock, which is exclusive, meaning only one thread can hold it at a time,
       and no readers are allowed while a writer holds the lock.

  ❓ Why do we use a ReadWriteLock instead of a normal Lock?
  ✅ Normal Lock (for example, ReentrantLock) allows only one thread inside the critical section at a time.
  ✅ With ReadWriteLock:
     - Multiple readers can access the shared resource at the same time,
       improving performance when reads are frequent and writes are rare.
     - Writers get exclusive access to ensure data consistency when modifying the resource.

  ❓ Which classes implement ReadWriteLock in Java?
  ✅ The main implementation is ReentrantReadWriteLock.
  ✅ ReentrantReadWriteLock provides:
     - readLock() → returns the lock to be used by readers.
     - writeLock() → returns the lock to be used by writers.
     - both readLock() and writeLock() are backed by the same ReentrantReadWriteLock instance,
       so they share state and are aware of each other — if a thread acquires one,
       the other will know and behave accordingly.
     - Both locks support lock(), unlock(), tryLock(), and lockInterruptibly() methods.

  ❓ How does fairness work with ReentrantReadWriteLock?
  ✅ It can be created in fair or unfair mode, just like ReentrantLock.
  ✅ In fair mode, threads acquire read or write locks in the order they requested.
  ✅ In unfair mode (default), throughput may be higher but starvation is possible.

  ❓ When should you use ReadWriteLock?
  ✅ Use it when the resource is read far more often than it is written.
  ✅ Example: Caches, in-memory databases, or data structures where many threads
     need to read simultaneously, but only a few threads occasionally update.
*/

public class ReadWriteLock {
}
