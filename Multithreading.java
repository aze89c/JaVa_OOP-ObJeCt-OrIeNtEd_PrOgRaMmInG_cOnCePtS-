/*Multithreading
The Java run-time system depends on threads for many things, and all the class
libraries are designed with multithreading in mind. In fact, Java uses threads to enable the
entire environment to be asynchronous. This helps reduce inefficiency by preventing the
waste of CPU cycles.
The benefit of Java’s multithreading is that the main loop/polling mechanism is eliminated.
One thread can pause without stopping other parts of your program. For example, the idle
time created when a thread reads data from a network or waits for user input can be utilized
elsewhere. Multithreading allows animation loops to sleep for a second between each frame
without causing the whole system to pause. When a thread blocks in a Java program, only the
single thread that is blocked pauses. All other threads continue to run.
Threads exist in several states. A thread can be running. It can be ready to run as soon as it
gets CPU time. Arunning thread can be suspended, which temporarily suspends its activity.
Asuspended thread can then be resumed, allowing it to pick up where it left off. A thread can
be blocked when waiting for a resource. At any time, a thread can be terminated, which halts
its execution immediately. Once terminated, a thread cannot be resumed.
In the most general sense, you create a thread by instantiating an object of type Thread.
Java defines two ways in which this can be accomplished:
• You can implement the Runnable interface.
• You can extend the Thread class, itself.*/
// Create a second thread.
class NewThread implements Runnable {
Thread t;
NewThread() {
// Create a new, second thread
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
try {
for(int i = 5; i > 0; i--) {
System.out.println("Child Thread: " + i);
Thread.sleep(500);
}
} catch (InterruptedException e) {
System.out.println("Child interrupted.");
}
System.out.println("Exiting child thread.");
}
14
}
class ThreadDemo {
public static void main(String args[]) {
new NewThread(); // create a new thread
try {
for(int i = 5; i > 0; i--) {
System.out.println("Main Thread: " + i);
Thread.sleep(1000);
}
} catch (InterruptedException e) {
System.out.println("Main thread interrupted.");
}
System.out.println("Main thread exiting.");
}
}
Child thread: Thread[Demo Thread,5,main]
Main Thread: 5
Child Thread: 5
Child Thread: 4
Main Thread: 4
Child Thread: 3
Child Thread: 2
Main Thread: 3
Child Thread: 1
Exiting child thread.
Main Thread: 2
Main Thread: 1
Main thread exiting.
// Create a second thread by extending Thread
class NewThread extends Thread {
NewThread() {
// Create a new, second thread
super("Demo Thread");
System.out.println("Child thread: " + this);
start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
try {
for(int i = 5; i > 0; i--) {
System.out.println("Child Thread: " + i);
Thread.sleep(500);
}
} catch (InterruptedException e) {
System.out.println("Child interrupted.");
}
15
System.out.println("Exiting child thread.");
}
}
class ExtendThread {
public static void main(String args[]) {
new NewThread(); // create a new thread
try {
for(int i = 5; i > 0; i--) {
System.out.println("Main Thread: " + i);
Thread.sleep(1000);
}
} catch (InterruptedException e) {
System.out.println("Main thread interrupted.");
}
System.out.println("Main thread exiting.");
}
}