/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.MultiPlayer;
import java.awt.BorderLayout;
import java.awt.Image; 
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
/**
 *
 * @author aimgs
 */
public class MultiPlayerFrame extends JFrame {
    private MultiPlayerPanel  multiPlayerPanel ; // the atribute
    public MultiPlayerFrame(int level, int firstPlayer,String firstName, int secondPlayer,String secondName){
        setTitle("Independence Shooter");
        setSize(916, 638);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        MultiPlayerPanel mpp = new MultiPlayerPanel(this);
        add(mpp);
        addWindowListener (new WindowAdapter(){
            @Override
            public void windowOpened(WindowEvent e){
                mpp.start(level, firstPlayer,firstName,secondPlayer,secondName);
            }
        });
        setVisible(true);
        
        
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
        
        
    }
}
