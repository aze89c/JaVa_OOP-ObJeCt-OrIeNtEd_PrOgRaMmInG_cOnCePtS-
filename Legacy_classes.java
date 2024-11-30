/*Legacy Classes
Early versions of java.util did not include the Collections Framework. Instead, it
defined several classes and an interface that provided an ad hoc method of storing objects.
When collections were added (by J2SE 1.2), several of the original classes were reengineered
to support the collection interfaces. Thus, they are fully compatible with the framework.
The legacy classes defined by java.util are shown here:
Dictionary Hashtable Properties Stack Vector
Vector implements a dynamic array. It is similar to ArrayList, but with two differences:
Vector is synchronized, and it contains many legacy methods that are not part of the
Collections
Vector is declared like this:
class Vector<E>
Here, E specifies the type of element that will be stored.
Here are the Vector constructors:
Vector( )
Vector(intsize)
Vector(int size, int incr)
Hashtable was part of the original java.util and is a concrete implementation of a ictionary.
However, with the advent of collections, Hashtable was reengineered to also implement the
Map interface. Thus, Hashtable is now integrated into the Collections Framework. It is so
Similar to HashMap, but is synchronized.
Like HashMap, Hashtable stores key/value pairs in a hash table. However, neither keys nor
values can be null. When using a Hashtable, you specify an object that is used as a key, and
the value that you want linked to that key. The key is then hashed, and the resulting hash code
is used as the index at which the value is stored within the table.
Hashtable was made generic by JDK 5. It is declared like this:
class Hashtable<K, V>*/
// Demonstrate various Vector operations.
import java.util.*;
class VectorDemo {
public static void main(String args[]) {
// initial size is 3, increment is 2
Vector<Integer> v = new Vector<Integer>(3, 2);
System.out.println("Initial size: " + v.size());
System.out.println("Initial capacity: " +
v.capacity());
v.addElement(1);
v.addElement(2);
v.addElement(3);
25
v.addElement(4);
System.out.println("Capacity after four additions: " +
v.capacity());
v.addElement(5);
System.out.println("Current capacity: " +
v.capacity());
v.addElement(6);
v.addElement(7);
System.out.println("Current capacity: " +
v.capacity());
v.addElement(9);
v.addElement(10);
System.out.println("Current capacity: " +
v.capacity());
v.addElement(11);
v.addElement(12);
System.out.println("First element: " + v.firstElement());
System.out.println("Last element: " + v.lastElement());
if(v.contains(3))
System.out.println("Vector contains 3.");
// Enumerate the elements in the vector.
Enumeration vEnum = v.elements();
System.out.println("\nElements in vector:");
while(vEnum.hasMoreElements())
System.out.print(vEnum.nextElement() + " ");
System.out.println();
}
}
/*The output from this program is shown here:
Initial size: 0
Initial capacity: 3
Capacity after four additions: 5
Current capacity: 5
Current capacity: 7
Current capacity: 9
First element: 1
Last element: 12
Vector contains 3.
Elementsin vector:
1 2 3 4 5 6 7 9 10 11 12*/
// Demonstrate a Hashtable.
import java.util.*;
class HTDemo {
public static void main(String args[]) {
Hashtable<String, Double> balance =
26
new Hashtable<String, Double>();
Enumeration<String> names;
String str;
double bal;
balance.put("John Doe", 3434.34);
balance.put("Tom Smith", 123.22);
balance.put("Jane Baker", 1378.00);
balance.put("Tod Hall", 99.22);
balance.put("Ralph Smith", -19.08);
// Show all balances in hashtable.
names = balance.keys();
while(names.hasMoreElements()) {
str = names.nextElement();
System.out.println(str + ": " +
balance.get(str));
}
System.out.println();
// Deposit 1,000 into John Doe's account.
bal = balance.get("John Doe");
balance.put("John Doe", bal+1000);
System.out.println("John Doe's new balance: " +
balance.get("John Doe"));
}
}
/*The output from this program is shown here:
Todd Hall: 99.22
Ralph Smith: -19.08
John Doe: 3434.34
Jane Baker: 1378.0
Tom Smith: 123.22
John Doe’s new balance: 4434.34
Dictionary*/
import java.util.*;
class DictionaryDemo {
public static void main(String args[]) {
// Create a hash map.
HashMap<String, Double> hm = new HashMap<String, Double>();
// Put elements to the map
hm.put("John Doe", new Double(3434.34));
hm.put("Tom Smith", new Double(123.22));
hm.put("Jane Baker", new Double(1378.00));
hm.put("Tod Hall", new Double(99.22));
hm.put("Ralph Smith", new Double(-19.08));
// Get a set of the entries.
Set<Map.Entry<String, Double>> set = hm.entrySet();
27
// Display the set.
for(Map.Entry<String, Double> me : set) {
System.out.print(me.getKey() + ": ");
System.out.println(me.getValue());
}
System.out.println();
// Deposit 1000 into John Doe's account.
double balance = hm.get("John Doe");
hm.put("John Doe", balance + 1000);
System.out.println("John Doe's new balance: " +
hm.get("John Doe"));
}
}