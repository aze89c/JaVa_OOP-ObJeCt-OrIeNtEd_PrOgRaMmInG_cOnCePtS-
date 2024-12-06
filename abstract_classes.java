/*Abstract Class and Interface
You can require that certain methods be overridden by subclasses by specifying the
abstract type modifier. These methods are sometimes referred to as subclasser responsibility
because they have no implementation specified in the superclass. Thus, a subclass must
override them—it cannot simply use the version defined in the superclass. To declare an
abstract method, use this general form:
abstract type name(parameter-list);
As you can see, no method body is present.
Any class that contains one or more abstract methods must also be declared abstract. To
declare a class abstract, you simply use the abstract keyword in front of the class keyword at
the beginning of the class declaration. There can be no objects of an abstract class. That is, an
abstract class cannot be directly instantiated with the new operator.
Interfaces
are syntactically similar to classes, but they lack instance variables, and their methods are
declared without any body. In practice, this means that you can define interfaces that don’t
make assumptions about how they are implemented. Once it is defined, any number of classes
can implement an interface. Also, one class can implement any number of interfaces.
To implement an interface, a class must create the complete set of methods defined by the
interface. However, each class is free to determine the details of its own implementation. By
providing the interface keyword, Java allows you to fully utilize the “one interface, multiple
methods” aspect of polymorphism.
An interface is defined much like a class. This is the general form of an interface:
access interface name {
return-type method-name1(parameter-list);
return-type method-name2(parameter-list);
type final-varname1 = value;
type final-varname2 = value;
// ...
return-type method-nameN(parameter-list);
type final-varnameN = value;
}*/
// Using abstract methods and classes.
abstract class Figure {
double dim1;
double dim2;
Figure(double a, double b) {
dim1 = a;
dim2 = b;
}
// area is now an abstract method
9
abstract double area();
}
class Rectangle extends Figure {
Rectangle(double a, double b) {
super(a, b);
}
// override area for rectangle
double area() {
System.out.println("Inside Area for Rectangle.");
return dim1 * dim2;
}
}
class Triangle extends Figure {
Triangle(double a, double b) {
super(a, b);
}
// override area for right triangle
double area() {
System.out.println("Inside Area for Triangle.");
return dim1 * dim2 / 2;
}
}
class AbstractAreas {
public static void main(String args[]) {
// Figure f = new Figure(10, 10); // illegal now
Rectangle r = new Rectangle(9, 5);
Triangle t = new Triangle(10, 8);
Figure figref; // this is OK, no object is created
figref = r;
System.out.println("Area is " + figref.area());
figref = t;
System.out.println("Area is " + figref.area()); } }
Interface Program
interface Callback {
void callback(int param);
}
class Client implements Callback {
// Implement Callback's interface
public void callback(int p) {
System.out.println("callback called with " + p);
}
}
class TestIface {
public static void main(String args[]) {
Callback c = new Client();
c.callback(42); } }
10
