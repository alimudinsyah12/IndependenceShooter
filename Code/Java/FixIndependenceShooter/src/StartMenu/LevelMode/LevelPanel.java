/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartMenu.LevelMode;

/**
 *
 * @author aimgs
 */


import StartMenu.ChoosePlayer.ChoosePlayerFrame;
import StartMenu.ModePlayer.ModePlayerFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPanel extends JPanel implements ActionListener {
    private final String [] buttonLoc;
    private final JButton[] button;
    private final LevelFrame parentWindow;
    private int mode;
    private Image background;
    
    public LevelPanel(LevelFrame mainWindow,int mode){
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/PlayerEnemyButton/portugueseFlag.png","/image/PlayerEnemyButton/dutchFlag.png","/image/PlayerEnemyButton/japanFlag.png","/image/Button/back.png"};
        this.button = new JButton[4]; // how much the button we want
        this.parentWindow = mainWindow;
        this.mode=mode;
        this.setFocusable(false);
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        background =new ImageIcon(getClass().getResource("/image/Background/levelPick.png")).getImage();
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);
            if(i==3){
            button[i].setBounds(615 , 515, 250, 50); 
            }else{
                
            button[i].setBounds(100 + (i * 252), 285, 195, 130);
            }
            this.add(button[i]);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if (obj == button[0]){
            new ChoosePlayerFrame(1,mode,0, "",0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[1]){
            new ChoosePlayerFrame(2,mode,0, "",0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[2]){
            new ChoosePlayerFrame(3,mode,0, "",0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new ModePlayerFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }

}
