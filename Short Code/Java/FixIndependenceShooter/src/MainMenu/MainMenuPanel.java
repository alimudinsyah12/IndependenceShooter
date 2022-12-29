/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainMenu;

/**
 *
 * @author aimgs
 */

import AboutMenu.MainAboutFrame;
import HistoryMenu.HistoryFrame;
import LeaderboardMenu.LeaderboardFrame;
import Sound.Sound;
import StartMenu.ModePlayer.ModePlayerFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;

public class MainMenuPanel extends JComponent implements ActionListener {

    private final String [] buttonLoc;
    private final JButton[] button;
    private final MainMenuFrame parentWindow;
    private Sound bgMusicMenu;
    private Image background;

    public MainMenuPanel(MainMenuFrame mainWindow) {
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/Button/start.png","/image/Button/leaderboard.png","/image/Button/history.png","/image/Button/about.png","/image/Button/exit.png"};
        
        this.button = new JButton[5]; // how much the button we want
        this.setFocusable(false);
        this.parentWindow = mainWindow;
            bgMusicMenu = new Sound("/Sound/mainMenuBS.mp3");
            bgMusicMenu.playLoop();
        
        
        this.configureButton();

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        background =new ImageIcon(getClass().getResource("/image/Background/mainMenu.png")).getImage();
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);
            button[i].setBounds(46, 255 +(i*65), 250, 50);
            this.add(button[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == button[0]) {
            new ModePlayerFrame();
            bgMusicMenu.stop();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[1]) {
            new LeaderboardFrame();
            bgMusicMenu.stop();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]) {
            new HistoryFrame();
            bgMusicMenu.stop();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new MainAboutFrame();
            bgMusicMenu.stop();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        else if (obj == button[4]) {
            System.exit(0);
        }
    }
}

