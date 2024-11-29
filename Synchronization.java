/*Synchroinzation
When two or more threads need access to a shared resource, they need some way to
ensure that the resource will be used by only one thread at a time. The process by which this
is achieved is called synchronization. As you will see, Java provides unique, language-level
support for it. Key to synchronization is the concept of the monitor (also called a semaphore).
A monitor is an object that is used as a mutually exclusive lock, or mutex. Only one thread
can own a monitor at a given time. When a thread acquires a lock, it is said to have entered
the monitor All other threads attempting to enter the locked monitor will be suspended until
the first thread exits the monitor. These other threads are said to be waiting for the monitor. A
thread that owns a monitor can reenter the same monitor if it so desires.
You simply put calls to the methods defined by this class inside
a synchronized block.
This is the general form of the synchronized statement:
synchronized(object) {
// statements to be synchronized
}
// This program uses a synchronized block.*/
class Callme {
void call(String msg) {
System.out.print("[" + msg);
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
System.out.println("Interrupted");
}
System.out.println("]");
}
}
class Caller implements Runnable {
String msg;
Callme target;
Thread t;
public Caller(Callme targ, String s) {
target = targ;
msg = s;
t = new Thread(this);
t.start();
}
// synchronize calls to call()
public void run() {
17
synchronized(target) { // synchronized block
target.call(msg);
}
}
}
class Synch1 {
public static void main(String args[]) {
Callme target = new Callme();
Caller ob1 = new Caller(target, "Hello");
Caller ob2 = new Caller(target, "Synchronized");
Caller ob3 = new Caller(target, "World");
// wait for threads to end
try {
ob1.t.join();
ob2.t.join();
ob3.t.join();
} catch(InterruptedException e) {
System.out.println("Interrupted");
}
}
}