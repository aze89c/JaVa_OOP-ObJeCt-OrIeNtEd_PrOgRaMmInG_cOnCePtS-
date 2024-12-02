/*AWT Controls
It is important to state at the outset that there are two varieties of applets. The first are those
based directly on the Applet class described in this chapter. These applets use the Abstract
Window Toolkit (AWT) to provide the graphic user interface (or use no GUI at all). This style
of applet has been available since Java was first created.
The second type of applets are those based on the Swing class JApplet. Swing applets use the
Swing classes to provide the GUI. Swing offers a richer and often easier-to-use user interface
than does the  AWT.
All applets are subclasses (either directly or indirectly) of Applet. Applets are not stand-alone
programs. Instead, they run within either a web browser or an applet viewer. The illustrations
shown in this chapter were created with the standard applet viewer, called appletviewer,
provided by the JDK.
It is important to understand the order in which the various methods shown in the skeleton are
called. When an applet begins, the following methods are called, in this sequence:
1. init( )
2. start( )
3. paint( )
When an applet is terminated, the following sequence of method calls takes place:
1. stop( )
2. destroy( )*/
// Demonstrate color.
import java.awt.*;
import java.applet.*;
/*
<applet code="ColorDemo" width=300 height=200>
</applet>
*/
public class ColorDemo extends Applet {
// draw lines
public void paint(Graphics g) {
Color c1 = new Color(255, 100, 100);
Color c2 = new Color(100, 255, 100);
Color c3 = new Color(100, 100, 255);
g.setColor(c1);
g.drawLine(20, 10, 20, 50);
g.setColor(c2);
35
g.drawLine(40, 10, 40, 50);
g.setColor(c3);
g.drawLine(60,10, 60, 50);

g.setColor(Color.red);

g.drawOval(30, 90, 40, 40);

g.fillOval(80, 90, 40, 40);

g.setColor(Color.blue);

g.drawRect(130, 90, 40, 40);

g.fillRect(190, 90, 40, 40);
g.setColor(Color.cyan);
g.drawRoundRect(100, 150, 50, 50, 15, 15);
g.fillRoundRect(170, 150, 50, 50, 15, 15);
}
}