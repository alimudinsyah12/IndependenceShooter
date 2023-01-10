/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AboutMenu;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aimgs
 */
public class InsideAboutMenuFrame extends JFrame{
    private InsideAboutMenuPanel  insideAboutMenuPanel ; // the atribute
    private ImageIcon levelFrameBackground2; // the atribute
    private JLabel levelFrameLabel; // the atribute
    public InsideAboutMenuFrame(int noLoc){
        String [] backgroundLocation = {"/image/AboutBackground/soedirmanAbout.png","/image/AboutBackground/bungTomoAbout.png","/image/AboutBackground/pattimuraAbout.png","/image/AboutBackground/hasanuddinAbout.png","/image/AboutBackground/dipenogoroAbout.png",
                                        "/image/AboutBackground/portugueseAbout.png","/image/AboutBackground/dutchAbout.png","/image/AboutBackground/japanAbout.png","/image/Background/gameplay.png","/image/Background/author.png"};
        levelFrameBackground2 = new ImageIcon(this.getClass().getResource(backgroundLocation[noLoc-1]));
        levelFrameLabel = new JLabel(levelFrameBackground2);
        levelFrameLabel.setSize(900,600);

        this.setTitle("Independence Shooter"); //Title for the frame
        this.add(levelFrameLabel); // add my label to the frame
        this.setSize(916,638); // set the size for the frame (match to the size of BG)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the abbility to close the program
        this.setLocationRelativeTo(null);
        this.setResizable(false); // the unabbility to resize the frame
        this.insideAboutMenuPanel  = new InsideAboutMenuPanel (this,noLoc);
        this.getContentPane().add(insideAboutMenuPanel ); // adding the MainPanel to the frame
        this.setVisible(true); // show the frame
        
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
    }
}
