package multithreading;

public class MyThreadRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("run method of Runnable class");
		
	}
	
	public static void main(String[] args) {	
	   /*
		* 🔹 Thread.start() Flow (High-Level)
		*
		* 1. thread.start() → defined in Java (Thread.java).
		*    - Checks thread state.
		*    - Calls private native method start0().
		*
		* 2. start0() → 'native' means implemented in C/C++ inside JVM (not Java code).
		*    - Declared in Java, but body exists in JVM's libjvm (C/C++).
		*    - JVM uses JNI mechanism to connect Java ↔ native code.
		*
		* 3. Native code (C/C++) → uses OS APIs (pthread_create on Linux/Mac, CreateThread on Windows)
		*    to actually create a new OS-level thread.
		*
		* 4. New OS thread → JVM runtime schedules it → calls Thread.run().
		*    - If Runnable target exists, target.run() is executed in the new thread.
		*
		* 🔹 Key Point: 
		* Native methods in Java (like start0) act as bridges into the JVM’s C/C++ code.
		* This is how Java leverages low-level system resources while keeping Java code platform-independent.
		*/
		
		/*
		 *
		 * 🔹 Thread vs Runnable — Why Runnable is Preferred
		 *
		 * 1. Thread class
		 *    - If we extend Thread, our task is tied directly to the thread object.
		 *    - We cannot extend any other class (Java allows only single inheritance).
		 *    - Reusability is poor: the task cannot easily be reused in thread pools or other contexts.
		 *    - ✅ When to use: Only if you want to customize thread behavior itself
		 *      (e.g., override start(), set up thread-specific fields, or for very quick demos/tests).
		 *
		 * 2. Runnable interface
		 *    - Runnable separates "what to do" (task) from "how to run it" (Thread).
		 *    - A class can implement Runnable and still extend another class.
		 *    - The same Runnable can be reused in multiple Threads, Executors, or even run synchronously.
		 *    - ✅ When to use: Almost always. Runnable (or Callable) is the standard way
		 *      to define tasks for Threads, Executors, and thread pools.
		 *
		 * 🔹 Key Point:
		 * We prefer Runnable mainly to avoid violating single inheritance
		 * and to make tasks reusable and flexible across different execution contexts.
		 */

		Thread thread = new Thread(new MyThreadRunnable());
		thread.start();
	}
	

}
