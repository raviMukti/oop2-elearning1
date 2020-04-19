import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppletListener extends Applet implements MouseListener, KeyListener {

    int xpos, ypos;
    int rect1xco,rect1yco,rect1width,rect1height;
    boolean mouseEntered;
    boolean rect1Clicked;
    char ch;
    String s = "";

    public void init()
    {
        // Assign values to the rectanagle coordinates.
        rect1xco = 20;
        rect1yco = 20;
        rect1width = 100;
        rect1height = 50;

        // Add the MouseListener to your applet
        addMouseListener(this);
        addKeyListener(this);
    }

    public void paint(Graphics graphics){
        // Rectangle's color
        graphics.setColor(Color.green);

        graphics.fillRect(rect1xco,rect1yco,rect1width,rect1height);

        graphics.setColor(Color.red);

        // When the user clicks this will show the coordinates of the click
        // at the place of the click.
        graphics.drawString("("+xpos+","+ypos+")",xpos,ypos);

        // If the click was in the rectangle show this message
        if (rect1Clicked) graphics.drawString("You clicked in the Rectangle",20,120);
            // else this one
        else graphics.drawString("You clicked outside of the rectangle",20,120);

        if (mouseEntered) graphics.drawString("Mouse is in the applet area",20,160);
        else graphics.drawString("Mouse is outside the Applet area",20,160);

        showStatus("You typed " + ch + " character");
    }

    public void keyTyped(KeyEvent e) {
        ch = e.getKeyChar();
        if(ch == 'a')
            s = "a for apple";
        else if(ch == 'e')
            s = "e for elephant";
        else if(ch == 'i')
            s = "i for igloo";
        else if(ch == 'o')
            s = "o for ox";
        else if(ch == 'u')
            s = "u for umbrella";
        else
            s = "Type only vowels a, e, i, o, u only";

        repaint();
    }

    public void keyPressed(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void mouseClicked(MouseEvent me) {
        // Save the coordinates of the click lke this.
        xpos = me.getX();
        ypos = me.getY();

        // Check if the click was inside the rectangle area.
        if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco &&
                ypos < rect1yco+rect1height)  rect1Clicked = true;
            // if it was not then rect1Clicked is false;
        else
            rect1Clicked = false;
        //show the results of the click
        repaint();
    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {
        // Will draw the "inside applet message"
        mouseEntered = true;
        repaint();
    }

    public void mouseExited(MouseEvent mouseEvent) {
        // will draw the "outside applet message"
        mouseEntered = false;
        repaint();
    }
}
