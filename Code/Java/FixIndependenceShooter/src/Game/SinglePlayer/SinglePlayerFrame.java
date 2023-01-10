/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.SinglePlayer;
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
public class SinglePlayerFrame extends JFrame {
    private SinglePlayerPanel  singlePlayerPanel ; // the atribute
    public SinglePlayerFrame(int level, int firstPlayer, String firstName){
        this.setTitle("Independence Shooter");
        this.setSize(916, 638);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        SinglePlayerPanel spp = new SinglePlayerPanel(this);
        this.add(spp);
        addWindowListener (new WindowAdapter(){
            @Override
            public void windowOpened(WindowEvent e){
                spp.start(level, firstPlayer,firstName);
            }
        });
        setVisible(true);
        
        
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
        
        
    }
}
