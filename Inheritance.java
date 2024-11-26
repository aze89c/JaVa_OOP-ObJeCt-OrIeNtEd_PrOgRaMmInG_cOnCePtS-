Inheritance
/*In the terminology of Java, a class that is inherited is called a superclass. The class that does
the inheriting is called a subclass.
To inherit a class, you simply incorporate the definition of one class into another by using the
extends keyword. To see how, let’s begin with a short example. The following program
creates a superclass called A and a subclass called B. Notice how the keyword extends is used
to create a subclass of A.
However, you can build hierarchies that contain as many layers of inheritance as you like. As
mentioned, it is perfectly acceptable to use a subclass as a superclass of another.
For example, given three classes called A, B, and C, C can be a subclass of B, which is a
subclass of A. When this type of situation occurs, each subclass inherits all of the traits found
in all of its superclasses. In this case, C inherits all aspects of B and A.*/
// This program uses inheritance to extend Box.
class Box {
double width;
double height;
double depth;
// construct clone of an object
Box(Box ob) { // pass object to constructor
width = ob.width;
height = ob.height;
depth = ob.depth;
}
// constructor used when all dimensions specified
Box(double w, double h, double d) {
width = w;
height = h;
depth = d;
}
// constructor used when no dimensions specified
Box() {
width = -1; // use -1 to indicate
height = -1; // an uninitialized
depth = -1; // box
}
// constructor used when cube is created
Box(double len) {
width = height = depth = len;
}
// compute and return volume
double volume() {
5
return width * height * depth;
}
}
// Here, Box is extended to include weight.
class BoxWeight extends Box {
double weight; // weight of box
// constructor for BoxWeight
BoxWeight(double w, double h, double d, double m) {
width = w;
height = h;
depth = d;
weight = m;
}
}
class DemoBoxWeight {
public static void main(String args[]) {
BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
double vol;
vol = mybox1.volume();
System.out.println("Volume of mybox1 is " + vol);
System.out.println("Weight of mybox1 is " + mybox1.weight);
System.out.println();
vol = mybox2.volume();
System.out.println("Volume of mybox2 is " + vol);
System.out.println("Weight of mybox2 is " + mybox2.weight);
}
}
