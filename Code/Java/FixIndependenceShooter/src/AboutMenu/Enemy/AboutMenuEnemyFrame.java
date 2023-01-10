/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AboutMenu.Enemy;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author aimgs
 */
public class AboutMenuEnemyFrame extends JFrame {
    private AboutMenuEnemyPanel  aboutMenuEnemyPanel ; // the atribute
    public AboutMenuEnemyFrame(){
        this.setTitle("Independence Shooter"); //Title for the frame
        this.setSize(916,638); // set the size for the frame (match to the size of BG)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the abbility to close the program
        this.setLocationRelativeTo(null);
        this.setResizable(false); // the unabbility to resize the frame
        this.aboutMenuEnemyPanel  = new AboutMenuEnemyPanel (this);
        this.getContentPane().add(aboutMenuEnemyPanel ); // adding the MainPanel to the frame
        this.setVisible(true); // show the frame
        
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
    }
}
