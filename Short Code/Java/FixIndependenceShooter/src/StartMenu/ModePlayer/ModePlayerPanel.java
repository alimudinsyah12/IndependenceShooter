package StartMenu.ModePlayer;



import MainMenu.MainMenuFrame;
import StartMenu.LevelMode.LevelFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;
public class ModePlayerPanel extends JPanel implements ActionListener {
    private JButton[] Button;
    private String buttonLoc[];
    private Image background;
    private final ModePlayerFrame parentWindow;

    public ModePlayerPanel(ModePlayerFrame mainWindow){
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/Button/singlePlayer.png","/image/Button/multiPlayer.png","/image/Button/back.png"};
        this.Button = new JButton[3];
        this.parentWindow = mainWindow;
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        background =new ImageIcon(getClass().getResource("/image/Background/playerMode.png")).getImage();
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton(){
        for (int i = 0; i<Button.length; i++){
            ImageIcon img = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            Button[i] = new JButton(img);
            Button[i].addActionListener(this);
            if(i==2){
            Button[i].setBounds(615 , 515, 250, 50); 
            }else{
                
            Button[i].setBounds(325, 275 + i * 89, 250, 50);
            }
            this.add(Button[i]);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == Button[0]) {
            new LevelFrame(1);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == Button[1]) {
            new LevelFrame(2);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == Button[2]) {
            new MainMenuFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }
}
