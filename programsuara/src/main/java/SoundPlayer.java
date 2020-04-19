import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoundPlayer extends Applet implements ActionListener{

    Button play, stop;
    AudioClip audioClip;

    private static final String PLAY = "PLAY";
    private static final String STOP = "STOP";

    public void init(){
        play = new Button();
        play.setLabel(PLAY);
        play.setActionCommand(PLAY);
        play.addActionListener(this);
        add(play);

        stop = new Button();
        stop.setLabel(STOP);
        stop.setActionCommand(STOP);
        stop.addActionListener(this);
        add(stop);

        audioClip = getAudioClip(getClass().getResource("smb_warning.wav"), "smb_warning.wav");
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(PLAY)){
            audioClip.play();
        }else if(e.getActionCommand().equals(STOP)){
            audioClip.stop();
        }else{
            audioClip.stop();
        }

    }

}
