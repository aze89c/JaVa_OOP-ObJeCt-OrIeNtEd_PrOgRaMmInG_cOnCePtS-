Method Overloading
/*In Java it is possible to define two or more methods within the same class that share
the same name, as long as their parameter declarations are different. When this is the case, the
methods are said to be overloaded, and the process is referred to as method overloading.
Method overloading is one of the ways that Java supports polymorphism. If you have never
used a language that allows the overloading of methods, then the concept may seem strange at
first. But as you will see, method overloading is one of Java’s most exciting and useful
features. When an overloaded method is invoked, Java uses the type and/or number of
arguments as its guide to determine which version of the overloaded method to actually call.
Thus, overloaded methods must differ in the type and/or number of their parameters. While
overloaded methods may have different turn types, the return type alone is insufficient to
distinguish two versions of a method. When Java encounters a call to an overloaded method,
it simply executes the version of the method whose parameters match
the arguments used in the call.*/
// Demonstrate method overloading.
class OverloadDemo {
void test() {
System.out.println("No parameters");
}
// Overload test for one integer parameter.
void test(int a) {
System.out.println("a: " + a);
}
// Overload test for two integer parameters.
void test(int a, int b) {
System.out.println("a and b: " + a + " " + b);
}
// overload test for a double parameter
double test(double a) {
System.out.println("double a: " + a);
return a*a;
}
}
class Overload {
public static void main(String args[]) {
OverloadDemo ob = new OverloadDemo();
double result;
// call all versions of test()
ob.test();
ob.test(10);
ob.test(10, 20);
result = ob.test(123.25);
System.out.println("Result of ob.test(123.25): " + result);
}
2
}