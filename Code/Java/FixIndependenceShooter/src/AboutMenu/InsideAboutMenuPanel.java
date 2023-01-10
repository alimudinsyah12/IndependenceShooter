/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AboutMenu;

import AboutMenu.Enemy.AboutMenuEnemyFrame;
import AboutMenu.Player.AboutMenuPlayerFrame;
import Sound.Sound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aimgs
 */
public class InsideAboutMenuPanel extends JPanel implements ActionListener {
    
    private JButton button;
    private final InsideAboutMenuFrame parentWindow;
    private int noLoc;
    private Sound bgMusicEnemy;
    private Sound bgMusicPlayer;
    public InsideAboutMenuPanel(InsideAboutMenuFrame mainWindow, int noLoc){
        this.setLayout(null);
        this.button = new JButton(); // how much the button we want
        this.parentWindow = mainWindow;
        this.noLoc=noLoc;
        String []loc={"/Sound/portugueseAnthem.mp3","/Sound/dutchAnthem.mp3","/Sound/japanAnthem.mp3"};
        if(noLoc==1||noLoc==2||noLoc==3||noLoc==4||noLoc==5){
            bgMusicPlayer = new Sound("/Sound/gugurBunga.mp3");
            bgMusicPlayer.playLoop();
        }else if(noLoc==6||noLoc==7||noLoc==8){
            bgMusicEnemy = new Sound(loc[noLoc-6]);
            bgMusicEnemy.playLoop();
        }
        
        
        this.setFocusable(false);
        this.configureButton();
    }
    
    private void configureButton() // the method
    {
            ImageIcon im = new ImageIcon(this.getClass().getResource("/image/Button/back.png"));
            button = new JButton(im);
            button.addActionListener(this);
            button.setBounds(635 , 540, 250, 50); 
            this.add(button);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if(noLoc==1||noLoc==2||noLoc==3||noLoc==4||noLoc==5){
            if (obj == button){
            bgMusicPlayer.stop();
            new AboutMenuPlayerFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        }else if(noLoc==6||noLoc==7||noLoc==8){
            if (obj == button){
            bgMusicEnemy.stop();
            new AboutMenuEnemyFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        }else if(noLoc==9||noLoc==10){
            if (obj == button){
            new MainAboutFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        }
    }
}
