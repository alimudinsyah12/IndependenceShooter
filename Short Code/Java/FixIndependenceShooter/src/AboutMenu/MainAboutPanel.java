/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AboutMenu;

import AboutMenu.Enemy.AboutMenuEnemyFrame;
import AboutMenu.Player.AboutMenuPlayerFrame;
import MainMenu.MainMenuFrame;
import Sound.Sound;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aimgs
 */
public class MainAboutPanel extends JPanel implements ActionListener {
    private final String [] buttonLoc;
    private final JButton[] button;
    private Image background;
    private final MainAboutFrame parentWindow;
    private Sound bgMusicMenu;

    public MainAboutPanel(MainAboutFrame mainWindow){
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/Button/player.png","/image/Button/enemy.png","/image/Button/gameplay.png","/image/Button/autor.png","/image/Button/back.png"};
        this.button = new JButton[5]; // how much the button we want
        this.parentWindow = mainWindow;
        bgMusicMenu = new Sound("/Sound/mainMenuBS.mp3");
        //bgMusicMenu.resume();
        this.setFocusable(false);
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        background =new ImageIcon(getClass().getResource("/image/Background/about.png")).getImage();
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);
            if(i==4){
            button[i].setBounds(635 , 530, 250, 50); 
            }else{
                
            button[i].setBounds(325, 224 + i * 75, 250, 50);
            }
            this.add(button[i]);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if (obj == button[0]){
            new AboutMenuPlayerFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[1]){
            new AboutMenuEnemyFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[2]){
            new InsideAboutMenuFrame(9);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new InsideAboutMenuFrame(10);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[4]) {
            new MainMenuFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }
}
