package multithreading;

/*
*
* 🔹 Java Thread Lifecycle (High-Level)
*
* 1. NEW
*    - A Thread object is created (e.g., new Thread()).
*    - No OS-level thread yet; thread is not started.
*
* 2. RUNNABLE
*    - After thread.start(), JVM calls start0() (native).
*    - OS thread is created; thread is eligible to run.
*    - Actual execution depends on OS scheduler.
*
* 3. RUNNING - 
*    - This state is not available in Java, it comes under RUNNABLE only
*
* 4. BLOCKED
*    - Thread is waiting to acquire a monitor lock (synchronized block).
*    - It cannot proceed until the lock is released.
*
* 5. WAITING
*    - Thread is waiting indefinitely for another thread’s signal.
*    - Entered via Object.wait() without timeout.
*    - Must be awakened by notify() or notifyAll().
*
* 6. TIMED_WAITING
*    - Thread is waiting but only for a specific time.
*    - Examples: Thread.sleep(ms), join(ms), wait(ms).
*
* 7. TERMINATED
*    - Thread has finished execution of run().
*    - It cannot be restarted once in this state.
*
* 🔹 Key Point:
* Threads move between these states based on code logic
* and OS scheduling. The JVM + OS cooperate to manage
* thread execution and synchronization.
*/
public class ThreadLifeCycle extends Thread{
	
	@Override
	public void run() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run Running");
	}	
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();
		System.out.println(threadLifeCycle.getState());
		
		threadLifeCycle.start();
		System.out.println("59"+threadLifeCycle.getState());
		//Thread.sleep(1000);
		threadLifeCycle.join(); // main waits here until child thread threadLifeCycle finishes
		System.out.println("61"+threadLifeCycle.getState());
		System.out.println(Thread.currentThread().getState());
		
	}
}


