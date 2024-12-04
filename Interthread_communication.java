/*Inter thread communication
Java includes an elegant interprocess communication mechanism via the wait( ),
notify( ), and notifyAll( ) methods. These methods are implemented as final methods in
Object, so all classes have them. All three methods can be called only from within a
synchronized context. Although conceptually advanced from a computer science perspective,
the rules for using these methods are actually quite simple:
• wait( ) tells the calling thread to give up the monitor and go to sleep until some other thread
enters the same monitor and calls notify( ).
• notify( ) wakes up a thread that called wait( ) on the same object.
• notifyAll( ) wakes up all the threads that called wait( ) on the same object. One of the
threads will be granted access.*/
// A correct implementation of a producer and consumer.
class Q {
int n;
boolean valueSet = false;
synchronized int get() {
while(!valueSet)
try {
wait();
} catch(InterruptedException e) {
System.out.println("InterruptedException caught");
}
System.out.println("Got: " + n);
valueSet = false;
notify();
return n;
}
synchronized void put(int n) {
while(valueSet)
try {
wait();
} catch(InterruptedException e) {
System.out.println("InterruptedException caught");
}
this.n = n;
valueSet = true;
System.out.println("Put: " + n);
notify();
}
}
class Producer implements Runnable {
Q q;
Producer(Q q) {
19
this.q = q;
new Thread(this, "Producer").start();
}
public void run() {
int i = 0;
while(true) {
q.put(i++);
}
}
}
class Consumer implements Runnable {
Q q;
Consumer(Q q) {
this.q = q;
new Thread(this, "Consumer").start();
}
public void run() {
while(true) {
q.get();
}
}
}
class PCFixed {
public static void main(String args[]) {
Q q = new Q();
new Producer(q);
new Consumer(q);
System.out.println("Press Control-C to stop.");
}
}
/*Put: 1
Got: 1
Put: 2
Got: 2
Put: 3
Got: 3
Put: 4
Got: 4*/