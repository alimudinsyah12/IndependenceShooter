/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author aimgs
 */
public class Tank extends EnemyParent{
    private final Image image;

    public Tank() {
        super(0, 0);
        this.image = new ImageIcon(getClass().getResource("/image/GameAsset/Tank.png")).getImage();
    }
    
    
    public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(getX(),getY());
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(getAngle() ), getENEMY_SIZE()/2, getENEMY_SIZE()/2);
        g2.drawImage(image, tran, null);
        g2.setTransform(oldTransform);

    }
}
