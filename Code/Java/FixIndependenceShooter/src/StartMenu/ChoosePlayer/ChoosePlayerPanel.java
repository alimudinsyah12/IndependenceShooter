package StartMenu.ChoosePlayer;


import Game.MultiPlayer.MultiPlayerFrame;
import Game.SinglePlayer.SinglePlayerFrame;
import StartMenu.LevelMode.LevelFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePlayerPanel extends JPanel implements ActionListener {
    
    private final String [] buttonLoc;
    private final JButton[] button;
    private int level;
    private int modePlayer;
    private int firstPlayer;
    private int secondPlayer;
    private String firstName;
    private String secondName;
    private JTextField nameTextField;
    private final ChoosePlayerFrame parentWindow;
    private Image background;
    
    public ChoosePlayerPanel(ChoosePlayerFrame mainWindow,int level,int modePlayer, int firstPlayer,String firstName,int secondPlayer, String secondName){
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/PlayerEnemyButton/bungTomoPlayer.png","/image/PlayerEnemyButton/dipenogoroPlayer.png","/image/PlayerEnemyButton/hasanuddinPlayer.png","/image/PlayerEnemyButton/pattimuraPlayer.png","/image/PlayerEnemyButton/soedirmanPlayer.png","/image/Button/Back.png"};
        this.button = new JButton[6]; // how much the button we want
        this.setFocusable(false);
        
        this.level = level;
        this.modePlayer=modePlayer;
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        this.firstName=firstName;
        this.secondName=secondName;
        this.parentWindow = mainWindow;
        
        this.nameTextField = new JTextField(10);
        this.nameTextField.setBounds(468,163,250,50);
        this.nameTextField.setFont(new Font("Arcade Normal", Font.BOLD, 25));
        this.nameTextField.setBackground(Color.black);
        this.nameTextField.setForeground(Color.white);
        
        this.configureButton();
        this.add(this.nameTextField);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(firstPlayer==0){
            background =new ImageIcon(getClass().getResource("/image/Background/1stPlayerPick.png")).getImage();
        }else{
            background =new ImageIcon(getClass().getResource("/image/Background/2ndPlayerPick.png")).getImage();
        }
        
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);
            if(i==5){
                button[i].setBounds(615 , 515, 250, 50);
            }else{
               button[i].setBounds(35+(i*175), 250, 130, 200); 
               button[i].setBackground(new Color(224,189,156));
            }
            
            this.add(button[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(modePlayer==1){
            if (obj == button[0]) {
            new SinglePlayerFrame(level,1,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[1]) {
            new SinglePlayerFrame(level,2,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]){
            new SinglePlayerFrame(level,3,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new SinglePlayerFrame(level,4,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[4]) {
            new SinglePlayerFrame(level,5,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[5]) {
            new LevelFrame(modePlayer);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        }else if(modePlayer==2){
            if(firstPlayer==0){
                if (obj == button[0]) {
            new ChoosePlayerFrame(level,modePlayer,1,this.nameTextField.getText(),0,"");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[1]) {
            new ChoosePlayerFrame(level,modePlayer,2, this.nameTextField.getText(),0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]){
            new ChoosePlayerFrame(level,modePlayer,3, this.nameTextField.getText(),0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new ChoosePlayerFrame(level,modePlayer,4, this.nameTextField.getText(),0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[4]) {
            new ChoosePlayerFrame(level,modePlayer,5, this.nameTextField.getText(),0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[5]) {
            new LevelFrame(modePlayer);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
            }else{
                if (obj == button[0]) {
            new MultiPlayerFrame(level,firstPlayer,firstName,1,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[1]) {
            new MultiPlayerFrame(level,firstPlayer,firstName,2,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[2]){
            new MultiPlayerFrame(level,firstPlayer,firstName,3,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new MultiPlayerFrame(level,firstPlayer,firstName,4,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[4]) {
            new MultiPlayerFrame(level,firstPlayer,firstName,5,this.nameTextField.getText());
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[5]) {
            new ChoosePlayerFrame(level,modePlayer,0, "",0, "");
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
            }
        }
    }


}
