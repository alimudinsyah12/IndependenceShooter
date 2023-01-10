/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HistoryMenu;

import LeaderboardMenu.Leaderboard;
import LeaderboardMenu.LeaderboardDAO;
import LeaderboardMenu.LeaderboardMP;
import MainMenu.MainMenuFrame;
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
public class HistoryPanel extends JPanel implements ActionListener {
    private JButton backButton;
    private Graphics2D g2;
    private Image background;
    private Image portugueseFlag;
    private Image dutchFlag;
    private Image japanFlag;
    private final HistoryFrame parentWindow;
    public HistoryPanel(HistoryFrame mainWindow){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.backButton = new JButton();
        this.parentWindow = mainWindow;
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        background =new ImageIcon(getClass().getResource("/image/Background/history.png")).getImage();
        portugueseFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/portugueseMiniFlag.png")).getImage();
        dutchFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/dutchMiniFlag.png")).getImage();
        japanFlag =new ImageIcon(getClass().getResource("/image/PlayerEnemyButton/japanMiniFlag.png")).getImage();
        g2.drawImage(background, 0,0, null);
        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arcade Normal",Font.BOLD,13));
        g2.drawString("No",22,208);
        g2.drawString("Name",100,208);
        g2.drawString("Score",250,208);
        g2.drawString("LVL",340,208);
        
        g2.drawString("No",415,208);
        g2.drawString("Name 1",500,208);
        g2.drawString("Name 2",625,208);
        g2.drawString("Score",745,208);
        g2.drawString("LVL",840,208);
        LeaderboardDAO dao = new LeaderboardDAO();
        Leaderboard lstsp = dao.getLastSP();
        int lastsp=lstsp.getNo();
        //System.out.println(lastsp);
        LeaderboardMP lstmp = dao.getLastMP();
        int lastmp=lstmp.getNo();
        //System.out.println(lastmp);
        int j=0;
        int k=0;
        for(int i=lastsp;i>lastsp-10;i--){
            
             g2.setColor(Color.BLACK);
             g2.setFont(new Font("Arcade Normal",Font.PLAIN,12));
            
              Leaderboard q = dao.getHstSP(i); 
              
              g2.drawString(String.valueOf(i)+".",25,233+(j*30));
              
              if("".equals(q.getName())){
                 g2.drawString("No Name",100,233+(j*30)); 
              }else{
                  g2.drawString(q.getName(),100,233+(j*30));
              }
              
              g2.drawString(String.valueOf(q.getScore()),260,233+(j*30));
             
              if("PRT".equals(q.getLevel())){
                  g2.drawImage(portugueseFlag, 340,217+(j*30), null);
              }else if("NLD".equals(q.getLevel())){
                  g2.drawImage(dutchFlag, 340,217+(j*30), null);
              }else if("JPN".equals(q.getLevel())){
                  g2.drawImage(japanFlag, 340,217+(j*30), null);
              }
              
              j++;
            }
        
        for(int i=lastmp;i>lastmp-10;i--){
            
            LeaderboardMP r = dao.getHstMP(i); 
            g2.setColor(Color.BLACK);
              g2.setFont(new Font("Arcade Normal",Font.PLAIN,12));
              
              g2.drawString(String.valueOf(i)+".",415,233+(k*30));
              
              if("".equals(r.getName())){
             g2.drawString("No Name",500,233+(k*30)); 
              }else{
                 g2.drawString(r.getName(),500,233+(k*30)); 
              }
              
              if("".equals(r.getName2())){
                 g2.drawString("No Name",625,233+(k*30));
              }else{
                 g2.drawString(r.getName2(),625,233+(k*30));
              }
              
              g2.drawString(String.valueOf(r.getScore()),755,233+(k*30));
              
              if("PRT".equals(r.getLevel())){
                  g2.drawImage(portugueseFlag, 838,217+(k*30), null);
              }else if("NLD".equals(r.getLevel())){
                  g2.drawImage(dutchFlag, 838,217+(k*30), null);
              }else if("JPN".equals(r.getLevel())){
                  g2.drawImage(japanFlag, 838,217+(k*30), null);
              }
              
              k++;
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
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }


}
    

