/* Java program that works as a simple calculator. Use a grid layout to
arrange buttons for the digits and for the +, -,*, % operations. Add a text field to display
the result.*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class calc extends Applet implements ActionListener
{
Panel p1,p2;
TextField t;
String v="";
String d="";
String s1;
int a=0;
int b=0;
int c=0;
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
public void init()
{
p1=new Panel();
p2=new Panel();
t=new TextField(25);
b1=new Button("1");
b2=new Button("2");
b3=new Button("3");
b4=new Button("4");
b5=new Button("5");
b6=new Button("6");
b7=new Button("7");
b8=new Button("8");
b9=new Button("9");
b10=new Button("0");
b11=new Button("+");
b12=new Button("-");
b13=new Button("*");
b14=new Button("/");
b15=new Button("=");
setLayout(new BorderLayout());
p1.setLayout(new BorderLayout());
p2.setLayout(new GridLayout(4,4));
46
add(p1,BorderLayout.NORTH);
add(p2,BorderLayout.SOUTH);
p1.add(t,BorderLayout.CENTER);
p2.add(b1);
p2.add(b2);
p2.add(b3);
p2.add(b4);
p2.add(b5);
p2.add(b6);
p2.add(b7);
p2.add(b8);
p2.add(b9);
p2.add(b10);
p2.add(b11);
p2.add(b12);
p2.add(b13);
p2.add(b14);
p2.add(b15);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);
b10.addActionListener(this);
b10.addActionListener(this);
b11.addActionListener(this);
b12.addActionListener(this);
b13.addActionListener(this);
b14.addActionListener(this);
b15.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
String s=new String(ae.getActionCommand());
if(s.equals("="))
{
47
b=Integer.parseInt(t.getText());
c=a+b;
switch(d.charAt(0))
{
case '+': c=a+b;
break;
case '-': c=a-b;
break;
case '*': c=a*b;
break;
case '/': c=a/b;
break;
default: c=0;
}
t.setText(String.valueOf(c));
}
else
{
if(s.equals("1")|s.equals("2")|s.equals("3")|s.equals("4")|s.equals("5")|s.equals("6")|s.eq
uals("7")|s.equals("8")|s.equals("9")|s.equals("0"))
{
v="";
v=v+s;
}
else if(s.equals("+"))
{
d=s;
a=Integer.parseInt(t.getText());
v="";
}
else if(s.equals("-"))
{
d=s;
a=Integer.parseInt(t.getText());
v="";
}
else if(s.equals("*"))
{
d=s;
a=Integer.parseInt(t.getText());
v="";
}
else if(s.equals("/"))
{
d=s;
a=Integer.parseInt(t.getText());
v="";
48
}
t.setText(v);
}
}
public void paint(Graphics g)
{
}
}