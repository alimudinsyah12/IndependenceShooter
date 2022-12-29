package StartMenu.ModePlayer;

import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;

public class ModePlayerFrame extends JFrame {
    private ModePlayerPanel modePlayerPanel;

    public ModePlayerFrame(){
        this.setTitle("Independence Shooter"); //Title for the frame
        this.setSize(916,638); // set the size for the frame (match to the size of BG)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the abbility to close the program
        this.setLocationRelativeTo(null);
        this.setResizable(false); // the unabbility to resize the frame
        this.modePlayerPanel = new ModePlayerPanel(this);
        this.getContentPane().add(modePlayerPanel); // adding the MainPanel to the frame
        this.setVisible(true); // show the frame
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
    }
}
