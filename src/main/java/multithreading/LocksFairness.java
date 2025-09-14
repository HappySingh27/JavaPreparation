package multithreading;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
  ===== Lock Fairness Notes =====

  ❓ What is Lock Fairness?
  ✅ When multiple threads compete for a lock (such as a mutex, monitor, or ReentrantLock object),
     fairness describes how the lock decides which waiting thread gets access next.
  ✅ A Fair Lock ensures threads acquire the lock in the order they requested it,
     similar to a queue where each thread waits for its turn.
  ✅ An Unfair Lock allows the runtime scheduler to decide which thread gets the lock,
     often giving preference to threads that are already running or newly arrived,
     which may cause some threads to starve.

  ❓ Why does Fairness matter in multithreading?
  ✅ Fair locks prevent starvation, ensuring that no thread waits indefinitely,
     which is important for predictable performance in systems where every thread matters.
  ✅ Unfair locks can improve throughput because the scheduler may allow a thread
     that is already active on the CPU to acquire the lock, avoiding context switches
     and improving overall speed.
  ✅ Choosing between a fair and an unfair lock depends on the application:
     if avoiding starvation is critical, use a fair lock (for example, a ReentrantLock created with fairness set to true).
     If maximum performance is more important and occasional waiting is acceptable,
     an unfair lock (the default in many classes) can be used.
*/

public class LocksFairness {

    Lock lockFairness = new ReentrantLock(true);

    public void accessResource() throws InterruptedException{
        if(lockFairness.tryLock(2000, TimeUnit.MILLISECONDS)){
            try{
                System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                Thread.sleep(500);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }finally {
                System.out.println(Thread.currentThread().getName() + " released the lock");
                lockFairness.unlock();
            }
        }


    }

    public static void main(String[] args){
        final LocksFairness locksFairness = new LocksFairness();

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try{
                    locksFairness.accessResource();
                }catch(InterruptedException e){

                }

            }
        };

        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");
        Thread t3 = new Thread(runnable, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
