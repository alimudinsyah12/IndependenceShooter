package StartMenu.ChoosePlayer;


import java.awt.Image;
import javax.swing.*;

public class ChoosePlayerFrame extends JFrame {
    private ChoosePlayerPanel choosePlayerPanel;

    public ChoosePlayerFrame(int level, int modePlayer, int firstPlayer, String firstName, int secondPlayer, String secondName){
        this.setTitle("Independence Shooter"); //Title for the frame
        this.setSize(916,638); // set the size for the frame (match to the size of BG)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the abbility to close the program
        this.setLocationRelativeTo(null);
        this.setResizable(false); // the unabbility to resize the frame
        this.choosePlayerPanel = new ChoosePlayerPanel(this,level,modePlayer,firstPlayer,firstName,secondPlayer,secondName);
        this.getContentPane().add(choosePlayerPanel); // adding the MainPanel to the frame
        this.setVisible(true); // show the frame
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
    }
}

