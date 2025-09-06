package multithreading;

/*
*
* 🔹 Java Thread Concepts & Methods — Quick Notes
*
* 1) User Thread
*    - Default type of thread created in Java (e.g., main thread, worker threads).
*    - JVM keeps running as long as at least one user thread is alive.
*
* 2) Daemon Thread
*    - Special background service thread (e.g., garbage collector).
*    - JVM exits when only daemon threads remain.
*    - Method: setDaemon(true) → instance method (called on a Thread object).
*    - Method: isDaemon() → instance method.
*
* 3) yield()
*    - Hints scheduler to pause current thread and allow others to run.
*    - Static method → called on Thread class (Thread.yield()).
*
* 4) interrupt()
*    - Politely asks a thread to stop.
*    - Method: interrupt() → instance method (called on a Thread object).
*    - Method: isInterrupted() → instance method (checks specific thread).
*    - Method: Thread.interrupted() → static method (checks & clears current thread’s interrupt flag).
*
* 5) join()
*    - Makes the calling thread wait until the target thread finishes.
*    - Method: join(), join(ms) → instance methods (called on a Thread object).
*
* 6) setPriority(int) / getPriority()
*    - Sets/gets a thread’s scheduling priority (1..10).
*    - Methods: setPriority(), getPriority() → instance methods.
*
* 7) setName(String) / getName()
*    - Sets/gets a thread’s human-friendly name.
*    - Methods: setName(), getName() → instance methods.
*
* 🔹 Key Point:
* - Instance methods → called on a specific Thread object (t1.start(), t1.join(), t1.interrupt(), etc.).
* - Static methods → called on the Thread class itself (Thread.sleep(), Thread.yield(), Thread.interrupted()).
* - User threads keep JVM alive; daemon threads do not.
* - yield() is only a hint, not a guarantee.
* - interrupt() sets a flag or throws InterruptedException if blocked.
* - join() is essential for thread coordination.
* - Priority and name help with scheduling hints and debugging clarity.
*/


public class ThreadEssentialMethods implements Runnable {
	
	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName() + " - " + Thread.currentThread().getPriority());
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r1 = new ThreadEssentialMethods();
		Runnable r2 = new ThreadEssentialMethods();
		
		Thread t1 = new Thread(r1);
		t1.setPriority(10);
		t1.setName("Phela Thread"); // name can also be passed in constructor of Thread(r1,name)
		Thread t2 = new Thread(r2);
		t2.setPriority(1);
		t2.setName("Doosra Thread"); // name can also be passed in constructor of Thread(r2,name)
		
		t1.start();
		t2.start();
		
		
		t1.sleep(2000); // this will still make main thread sleep because sleep is static method
		t1.interrupt();
		 
	}

}
