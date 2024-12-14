/*Java applet program for handling mouse & key events
Events
In the delegation model, an event is an object that describes a state change in a source.
It can be generated as a consequence of a person interacting with the elements in a graphical
user interface. Some of the activities that cause events to be generated are pressing a button,
entering a character via the keyboard, selecting an item in a list, and clicking the mouse.
Many other user operations could also be cited as examples.
Events may also occur that are not directly caused by interactions with a user interface. For
example, an event may be generated when a timer expires, a counter exceeds a value, a
software or hardware failure occurs, or an operation is completed. You are free to define
events that are appropriate for your application.
Event Sources
Asource is an object that generates an event. This occurs when the internal state of that object
changes in some way. Sources may generate more than one type of event. Asource must
register listeners in order for the listeners to receive notifications about a specific type of
event. Each type of event has its own registration method. Here is the general form:
public void addTypeListener(TypeListener el)
Here, Type is the name of the event, and el is a reference to the event listener. For example,
the method that registers a keyboard event listener is called addKeyListener( ). The method
that registers a mouse motion listener is called addMouseMotionListener( ). When an event
occurs, all registered listeners are notified and receive a copy of the event object. This is
known as multicasting the event. In all cases, notifications are sent only to listeners that
register to receive them.
Event Listeners
Alistener is an object that is notified when an event occurs. It has two major requirements.
First, it must have been registered with one or more sources to receive notifications about
specific types of events. Second, it must implement methods to receive and process these
notifications. The methods that receive and process events are defined in a set of interfaces
found in java.awt.event. For example, the MouseMotionListener interface defines two
methods to receive notifications when the mouse is dragged or moved. Any object may
receive and process one or both of these events if it provides an implementation of this
interface
The AWT defines windows according to a class hierarchy that adds functionality and
specificity with each level. The two most common windows are those derived from Panel,
which is used by applets, and those derived from Frame, which creates a standard application
window. Much of the functionality of these windows is derived from their parent classes.
Thus, a description of the class hierarchies relating to these two classes is fundamental to their
understanding. Figure 23-1 shows the class hierarchy for Panel and Frame. Let’s look at each
of these classes now.
Component
At the top of the AWT hierarchy is the Component class. Component is an abstract class
that encapsulates all of the attributes of a visual component. All user interface elements that
are displayed on the screen and that interact with the user are subclasses of Component. It
37
defines over a hundred public methods that are responsible for managing events, such as
mouse and keyboard input, positioning and sizing the window, and repainting. (You already
used many of these methods when you created applets in Chapters 21 and 22.) A Component
object is responsible for remembering the current foreground and background colors and the
currently selected text font.
Container
The Container class is a subclass of Component. It has additional methods that allow other
Component objects to be nested within it. Other Container objects can be stored inside of a
Container (since they are themselves instances of Component). This makes for a
multileveled containment system. A container is responsible for laying out (that is,
positioning) any components that it contains. It does this through the use of various layout
managers*/
// Demonstrate the mouse event handlers.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code="MouseEvents" width=300 height=100>
</applet>
*/
public class MouseEvents extends Applet
implements MouseListener, MouseMotionListener {
String msg = "";
int mouseX = 0, mouseY = 0; // coordinates of mouse
public void init() {
addMouseListener(this);
addMouseMotionListener(this);
}
// Handle mouse clicked.
public void mouseClicked(MouseEvent me) {
// save coordinates
mouseX = 0;
mouseY = 10;
msg = "Mouse clicked.";
repaint();
}
// Handle mouse entered.
public void mouseEntered(MouseEvent me) {
// save coordinates
38
mouseX = 0;
mouseY = 10;
msg = "Mouse entered.";
repaint();
}
// Handle mouse exited.
public void mouseExited(MouseEvent me) {
// save coordinates
mouseX = 0;
mouseY = 10;
msg = "Mouse exited.";
repaint();
}
// Handle button pressed.
public void mousePressed(MouseEvent me) {
// save coordinates
mouseX = me.getX();
mouseY = me.getY();
msg = "Down";
repaint();
}
// Handle button released.
public void mouseReleased(MouseEvent me) {
// save coordinates
mouseX = me.getX();
mouseY = me.getY();
msg = "Up";
repaint();
}
// Handle mouse dragged.
public void mouseDragged(MouseEvent me) {
// save coordinates
mouseX = me.getX();
mouseY = me.getY();
msg = "*";
showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
repaint();
}
// Handle mouse moved.
39
public void mouseMoved(MouseEvent me) {
// show status
showStatus("Moving mouse at " + me.getX() + ", " + me.getY());
}
// Display msg in applet window at current X,Y location.
public void paint(Graphics g) {
g.drawString(msg, mouseX, mouseY);
}
}
Key Event Handling
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class KeyEventDemo extends Applet implements KeyListener
{
String msg="";
public void init()
{
addKeyListener(this);
}
public void keyPressed(KeyEvent k)
{
showStatus("KeyPressed");
}
public void keyReleased(KeyEvent k)
{
showStatus("KeyRealesed");
}
public void keyTyped(KeyEvent k)
{
msg = msg+k.getKeyChar();
repaint();
}
public void paint(Graphics g)
{
g.drawString(msg, 20, 40);
}}