/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeaderboardMenu;

import MainMenu.MainMenuFrame;
import Sound.Sound;
import java.awt.Color;
import java.awt.Font;
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
public class LeaderboardPanel extends JPanel implements ActionListener {
    private JButton backButton;
    private Graphics2D g2;
    private Image background;
    private Image portugueseFlag;
    private Image dutchFlag;
    private Image japanFlag;
    private Sound bgMusicLeaderboard;
    private final LeaderboardFrame parentWindow;
    public LeaderboardPanel(LeaderboardFrame mainWindow){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.backButton = new JButton();
        this.parentWindow = mainWindow;
        bgMusicLeaderboard = new Sound("/Sound/LeaderboardBacksound.mp3");
        bgMusicLeaderboard.playLoop();
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        background =new ImageIcon(getClass().getResource("/image/Background/leaderboard.png")).getImage();
        portugueseFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/portugueseMiniFlag.png")).getImage();
        dutchFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/dutchMiniFlag.png")).getImage();
        japanFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/japanMiniFlag.png")).getImage();
        g2.drawImage(background, 0,0, null);
        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arcade Normal",Font.BOLD,13));
        g2.drawString("No",22,220);
        g2.drawString("Name",70,220);
        g2.drawString("Score",215,220);
        g2.drawString("Level",305,220);
        
        g2.drawString("No",418,220);
        g2.drawString("Name 1",460,220);
        g2.drawString("Name 2",580,220);
        g2.drawString("Score",710,220);
        g2.drawString("Level",805,220);
        
        for(int i=0;i<10;i++){
             g2.setColor(Color.BLACK);
             g2.setFont(new Font("Arcade Normal",Font.PLAIN,12));
            LeaderboardDAO dao = new LeaderboardDAO();
              Leaderboard q = dao.getSP(i+1); 
              LeaderboardMP r = dao.getMP(i+1); 
              g2.drawString(String.valueOf(i+1)+".",25,249+(i*30));
              if("".equals(q.getName())){
                  g2.drawString("No Name",70,249+(i*30));  
              }else{
                  g2.drawString(q.getName(),70,249+(i*30));
              }
              
              g2.drawString(String.valueOf(q.getScore()),235,249+(i*30));
             
              if("PRT".equals(q.getLevel())){
                  g2.drawImage(portugueseFlag, 315,231+(i*30), null);
              }else if("NLD".equals(q.getLevel())){
                  g2.drawImage(dutchFlag, 315,231+(i*30), null);
              }else if("JPN".equals(q.getLevel())){
                  g2.drawImage(japanFlag, 315,231+(i*30), null);
              }
              
              g2.setColor(Color.BLACK);
              g2.setFont(new Font("Arcade Normal",Font.PLAIN,12));
              g2.drawString(String.valueOf(i+1)+".",418,249+(i*30));
              if("".equals(r.getName())){
                  g2.drawString("No Name",460,249+(i*30)); 
              }else{
                  g2.drawString(r.getName(),460,249+(i*30));
              }
              if("".equals(r.getName2())){
                  g2.drawString("No Name",580,249+(i*30));
              }else{
                  g2.drawString(r.getName2(),580,249+(i*30));
              }
              
              
              g2.drawString(String.valueOf(r.getScore()),725,249+(i*30));
              
              if("PRT".equals(r.getLevel())){
                  g2.drawImage(portugueseFlag, 810,231+(i*30), null);
              }else if("NLD".equals(r.getLevel())){
                  g2.drawImage(dutchFlag, 810,231+(i*30), null);
              }else if("JPN".equals(r.getLevel())){
                  g2.drawImage(japanFlag, 810,231+(i*30), null);
              }
              
            }
        
    }
    
    private void configureButton() // the method
    {
            ImageIcon im = new ImageIcon(this.getClass().getResource("/image/Button/back.png"));
            backButton = new JButton(im);
            backButton.addActionListener(this);
            backButton.setBounds(635, 535 , 250, 50);
            this.add(backButton);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj ==  backButton) {
            new MainMenuFrame();
            bgMusicLeaderboard.stop();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }


}
    

