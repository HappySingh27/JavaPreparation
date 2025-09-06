package multithreading;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("run");	
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		myThread.start(); // ✅ creates a new thread, calls run() in that new thread
		myThread.run();   // ❌ just a normal method call, runs in main thread
	}

}
