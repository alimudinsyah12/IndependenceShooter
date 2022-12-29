/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameOver;


import MainMenu.MainMenuFrame;
import Game.MultiPlayer.MultiPlayerFrame;
import Game.SinglePlayer.SinglePlayerFrame;
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
import javax.swing.JTextField;

/**
 *
 * @author aimgs
 */
public class GameOverPanel extends JPanel implements ActionListener {
    private final String [] buttonLoc;
    private final JButton[] button;
    private final GameOverFrame parentWindow;
    private JTextField nameTextField;
    private Image background;
    private int score;
    private int highScore;
    private int level;
    private int firstPlayer;
    private int secondPlayer;
    private int pos;
    private String firstName;
    private String secondName;

    public GameOverPanel(GameOverFrame mainWindow,int highScore,int pos, int score, int level, int firstPlayer,String firstName, int secondPlayer,String secondName){
        this.setLayout(null);
        this.score=score;
        this.highScore=highScore;
        this.level=level;
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        this.pos=pos;
        this.firstName=firstName;
        this.secondName=secondName;
        this.buttonLoc =  new String[]{"/Image/Button/tryagain.png","/Image/Button/mainmenu.png","/Image/Button/exit.png"};
        this.button = new JButton[3]; // how much the button we want
        this.parentWindow = mainWindow;
        this.setFocusable(false);
        this.configureButton();
    }
    
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);   
            button[i].setBounds(60+(i*265), 515, 250, 50);
            this.add(button[i]);
        }
    }
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setFont(new Font("Arcade Normal", Font.BOLD, 15));
        if(pos==0){
          background =new ImageIcon(getClass().getResource("/image/Background/game over.png")).getImage(); 
          g2.drawImage(background, 0,0, null);
          g2.setColor(Color.black);
          g2.setFont(new Font("Arcade Normal", Font.BOLD, 20));
          g2.drawString(String.valueOf(highScore), 460, 365);
          g2.drawString(String.valueOf(score), 460, 412);
        }else{
            background =new ImageIcon(getClass().getResource("/image/Background/gameoverT10.png")).getImage();
            g2.drawImage(background, 0,0, null);
            if(secondPlayer==0){
                
                if(pos==1){
                 g2.drawString("Congratulations "+firstName+", You're On Position 1st!", 100, 315);
                }else if(pos==2){
                 g2.drawString("Congratulations "+firstName+", You're On Position 2nd!", 100, 315);    
                }else if(pos==3){
                 g2.drawString("Congratulations "+firstName+", You're On Position 3rd!", 100, 315);   
                }else {
                 g2.drawString("Congratulations "+firstName+", You're On Position "+String.valueOf(pos)+"th!", 100, 315);  
                }
                g2.setColor(Color.black);
                g2.setFont(new Font("Arcade Normal", Font.BOLD, 20));
                g2.drawString(String.valueOf(highScore), 460, 405);
                g2.drawString(String.valueOf(score), 460, 450);
                
            }else{
                
                g2.drawString("Congratulations "+firstName+" And "+ secondName, 170, 300);
        
                if(pos==1){
                 g2.drawString("You're On Position 1st!", 260, 335);
                }else if(pos==2){
                 g2.drawString("You're On Position 2nd!", 260, 335);  
                }else if(pos==3){
                 g2.drawString("You're On Position 3rd!", 260, 335);   
                }else {
                  g2.drawString("You're On Position "+String.valueOf(pos)+"th!", 260, 335);
                }
                g2.setColor(Color.black);
                g2.setFont(new Font("Arcade Normal", Font.BOLD, 20));
                g2.drawString(String.valueOf(highScore), 460, 405);
                g2.drawString(String.valueOf(score), 460, 450);
                
            }
            
        }

        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if(secondPlayer==0){
            if (obj == button[0]){
            new SinglePlayerFrame(level, firstPlayer, firstName);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[1]){
            new MainMenuFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]){
            System.exit(0);
        }
        }else{
            if (obj == button[0]){
            new MultiPlayerFrame(level, firstPlayer,firstName,secondPlayer,secondName);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[1]){
            new MainMenuFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]){
            System.exit(0);
        }
        }
    }
}
