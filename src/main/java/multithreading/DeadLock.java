package multithreading;

/*
 * 1. Deadlock is a situation in multithreading where two or more threads are blocked forever,
 *    waiting for each other to release a resource.
 *    This typically occurs when two or more threads have circular dependencies on a set of locks.
 *
 * 2. A synchronized method will acquire the intrinsic lock of the object or class it belongs to,
 *    instance methods lock the current object (this), while static synchronized methods lock the class object.
 *    Only one thread can hold the lock at a time, forcing others to wait until it is released,
 *    which ensures thread safety but may lead to deadlock if multiple locks create circular dependencies.
 *
 */

/*
 * 1. If a class is declared 'public', the file name must match that class name.
 *    Example: public class DeadLock { } → File must be DeadLock.java
 * 2. A .java file can contain multiple classes, but only ONE can be public.
 * 3. If there is a public class, the file name must equal the public class name.
 * 4. If no class is public, the file name can be anything (flexible naming allowed).
 * 5. Other classes in the same file (non-public) have package-private (default) access.
 *
 */
public class DeadLock {



    public static void main(String[] args){

    }
}

 class Pen{

    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + "and trying to use Paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.print(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper{

    public synchronized void writeWithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + "and trying to use Pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.print(Thread.currentThread().getName() + " finished using paper " + this);
    }
}
