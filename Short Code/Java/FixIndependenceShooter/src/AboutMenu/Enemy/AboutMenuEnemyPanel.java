/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AboutMenu.Enemy;

import AboutMenu.InsideAboutMenuFrame;
import AboutMenu.MainAboutFrame;
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
public class AboutMenuEnemyPanel extends JPanel implements ActionListener {
    private final String [] buttonLoc;
    private final JButton[] button;
    private final AboutMenuEnemyFrame parentWindow;
    private Image background;
    public AboutMenuEnemyPanel(AboutMenuEnemyFrame mainWindow){
        this.setLayout(null);
        this.buttonLoc =  new String[]{"/image/Button/portugisbutton.png","/image/Button/belandabutton.png","/image/Button/jepangbutton.png","/image/Button/back.png"};
        this.button = new JButton[4]; // how much the button we want
        this.parentWindow = mainWindow;
        this.setFocusable(false);
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        background =new ImageIcon(getClass().getResource("/image/Background/enemy.png")).getImage();
        g2.drawImage(background, 0,0, null);
    }
    private void configureButton() // the method
    {
        for (int i = 0; i < button.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(buttonLoc[i]));
            button[i] = new JButton(im);
            button[i].addActionListener(this);
            if(i==3){
            button[i].setBounds(635 , 530, 250, 50); 
            }else{
                
            button[i].setBounds(323, 218 + i * 98, 250, 50);
            }
            this.add(button[i]);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();

        if (obj == button[0]){
            new InsideAboutMenuFrame(6);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }else if (obj == button[1]){
            new InsideAboutMenuFrame(7);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[2]){
            new InsideAboutMenuFrame(8);
            parentWindow.setVisible(false);
            parentWindow.dispose();
        } else if (obj == button[3]) {
            new MainAboutFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }
}
