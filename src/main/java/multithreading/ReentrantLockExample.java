package multithreading;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/*
======================================================
                ReentrantLock — Notes
======================================================

🔑 What it is:
- A class in java.util.concurrent.locks package.
- Provides explicit lock/unlock mechanism (extrinsic lock).
- More powerful and flexible than synchronized keyword (intrinsic lock).

------------------------------------------------------
Key Methods:
- lock()                  → acquires lock, waits indefinitely.
- unlock()                → releases lock (must always be in a finally).
- tryLock()               → tries to acquire immediately, returns true/false.
- tryLock(time, unit)     → tries to acquire within timeout, else fails.
- lockInterruptibly()     → acquires lock but allows interruption while waiting.

------------------------------------------------------
Advantages over synchronized:
- Can attempt acquisition with timeout → helps in deadlock prevention.
- Can be interruptible while waiting.
- Supports fairness policy → new ReentrantLock(true) = FIFO order.
- Explicit control over locking/unlocking.

------------------------------------------------------
Important Rules:
- Always release lock inside finally { lock.unlock(); }.
- Don’t hold locks during long or blocking operations (like I/O, long sleeps).
- Use tryLock(...) to avoid indefinite waiting.
- If InterruptedException is caught, restore interrupt status
  with Thread.currentThread().interrupt().

======================================================
*/

public class ReentrantLockExample {

    int balance=500;
    private final Lock lock = new ReentrantLock();

    public synchronized void withdrawAmountSynchronizedKeyword(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if(balance>=amount){

            try{
                Thread.sleep(10000);
            } catch (InterruptedException e){

            }
            System.out.println(amount + " " + "withdrawn");
            balance=balance-amount;
            System.out.println(Thread.currentThread().getName() + " withdrawl completed, remaining balance is " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }


    }

    public void withdrawAmountReentrantLock(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // simulate processing time
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " completed withdrawal. Remaining balance: " + balance);
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
/*
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.withdrawAmountSynchronizedKeyword(100);
            }
        };

        // Thread's task cannot be changed/reassigned after creation
        Thread t1 = new Thread(runnable1, "Thread 1");
        Thread t2 = new Thread(runnable1, "Thread 2");
        t1.start();
        t2.start();
*/
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.withdrawAmountReentrantLock(100);
            }
        };

        Thread t3 = new Thread(runnable2, "Thread 3");
        Thread t4 = new Thread(runnable2, "Thread 4");
        t3.start();
        t4.start();
    }

}
