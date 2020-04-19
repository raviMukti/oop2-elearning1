import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends Applet implements ActionListener {
    Font myFont = new Font("Arial", Font.BOLD, 20);
    Font myFont1 = new Font("Arial", Font.BOLD, 30);
    Font myFont2 = new Font("Arial", Font.BOLD, 55);
    int TRIES = 5,x;
    Label label1, label2, label3;
    Label label4, label5,label6,label7,label8;
    TextField input;
    Button cont,startGame;
    int randomNumber=0, guessNumber=0;
    Image gameOver;

    public void init() {

        randomNumber = (int) (20 * Math.random() + 1);
        play(getClass().getResource("sound1.wav"),"sound1.wav");

        setLayout(new GridLayout(15,1));
        setBackground(Color.lightGray);
        setSize(600,500);

        label1 = new Label("This is the Higher or Lower Game Applet!");
        label1.setFont(myFont);
        label1.setForeground(Color.red);
        label1.setAlignment(label1.CENTER);

        add(label1);
        label2 = new Label("Try to guess a random number from 1 to 20. You have 5 chances to guess the number.");
        label2.setAlignment(label2.CENTER);
        add(label2);

        input = new TextField(10);
        input.setFont(myFont1);
        add(input);

        input.selectAll();
        input.requestFocus();

        label3 = new Label("");
        label3.setAlignment(label3.CENTER);
        add(label3);
        label4 = new Label("");
        label4.setAlignment(label4.CENTER);
        label4.setFont(myFont);
        label4.setForeground(Color.yellow);
        add(label4);
        label5 = new Label("");
        label5.setAlignment(label5.CENTER);
        add(label5);
        label6 = new Label("");
        label6.setAlignment(label6.CENTER);
        add(label6);
        label7 = new Label("");
        label7.setAlignment(label7.CENTER);
        add(label7);

        cont = new Button("NEW GAME");
        cont.setEnabled(false);
        cont.setFont(myFont1);
        add(cont);

        label8 = new Label("");
        label8.setAlignment(label7.CENTER);
        label8.setFont(myFont);
        add(label8);

        input.addActionListener(this);
        cont.addActionListener(this);

    }

    public void printStat() {//a method to print the status of tries of the player
        if(TRIES>1) {
            label6.setText("You still have " + --TRIES + " tries.");
            label3.setText("Try to enter another number: ");
            label6.setFont(myFont);
        }

        else {
            getImage(getClass().getResource("gameover.jpg"),"gameover.jpg");
            label6.setText("Oops...You have NO MORE TRIES!");
            label8.setText("The random number is: " + randomNumber);
            label6.setFont(myFont);
            input.setEnabled(false);
            cont.setEnabled(true);
            cont.requestFocus();
            repaint();
        }
    }

    public void clear() {
        input.setText("");
    }

    public void paint(Graphics g) {

        if(randomNumber==guessNumber && TRIES>1) {
            g.setFont(myFont2);
            g.setColor(new Color(150,55,25));
            g.drawString("YOU WIN",170,400);
        }

        else if(TRIES==1) {
            g.setFont(myFont2);
            g.setColor(new Color(150,55,25));
            g.drawString("GAME OVER",130,400);
        }
        else {
            g.setFont(myFont2);
            g.setColor(new Color(150,55,25));
            g.drawString("GAME START",130,400);
        }
    }

    public void actionPerformed(ActionEvent e) {

        guessNumber = Integer.parseInt(input.getText());

        if(e.getSource()==cont) {

            randomNumber = (int) (20 * Math.random() + 1);//a method to random numbers from 1 to 50

            cont.setEnabled(false);
            input.setEnabled(true);
            label3.setText("");
            label4.setText("");
            label5.setText("");
            label6.setText("");
            label7.setText("");
            label8.setText("");
            TRIES = 5;
            play(getClass().getResource("SOUND1.wav"),"SOUND1.wav");
            clear();
            repaint();

        }

        if(e.getSource()==input) {
            if (randomNumber>guessNumber) {
                label4.setText("PLEASE ENTER HIGHER NUMBER THAN " + guessNumber + "!");
                printStat();
                play(getClass().getResource("mali.wav"),"mali.wav");
                input.selectAll();
                input.requestFocus();
            }
            else if (randomNumber<guessNumber) {
                label4.setText("PLEASE ENTER LOWER NUMBER THAN " + guessNumber + "!");
                printStat();
                play(getClass().getResource("mali.wav"),"mali.wav");//a code to play sounds in Applet
            }
            else {
                label4.setText("YOU'VE GOT THE RIGHT NUMBER...CONGRATULATIONS!");
                play(getClass().getResource("tama.wav"),"tama.wav");
                label3.setText("");
                label5.setText("");
                label6.setText("");
                label7.setText("");
                input.setEnabled(false);
                cont.setEnabled(true);
                TRIES = 5;
                repaint();
            }
        }
    }
}
