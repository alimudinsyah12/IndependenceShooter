/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import javax.swing.ImageIcon;

/**
 *
 * @author aimgs
 */
public class TankBullet extends EnemyParent{
    private final Image image;
    private final Area enemyShap;

    public TankBullet(int setAp) {
        super(setAp, setAp);
        this.image = new ImageIcon(getClass().getResource("/image//GameAsset/tankBullet.png")).getImage();
        Path2D p = new Path2D.Double();
        p.moveTo(40, 40);
        p.lineTo(40, 20);
        p.lineTo(70, 31);
        p.lineTo(40, 40);
        p.lineTo(70, 20);
        enemyShap= new Area(p);
        this.setSpeed(1.5f);
    }
    @Override
        public void update(){
        this.setX(getX()+Math.cos(Math.toRadians(getAngle()))*getSpeed());
        this.setY(getY()+Math.sin(Math.toRadians(getAngle()))*getSpeed());
    }
    
    public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(getX(),getY());
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(getAngle() ), getENEMY_SIZE()/2,getENEMY_SIZE()/2);
        g2.drawImage(image, tran, null);
        Shape shap=getShape();
        hpRender(g2, shap, getY());
        g2.setTransform(oldTransform);
        
        //test
        //g2.setColor(Color.red);
        //g2.draw(shap);
        //g2.draw(shap.getBounds2D());
    }
    
    public Area getShape(){
        AffineTransform afx = new AffineTransform();
        afx.translate(getX(),getY());
        afx.rotate(Math.toRadians(getAngle()), getENEMY_SIZE() / 2, getENEMY_SIZE() / 2);
        return  new Area(afx.createTransformedShape(enemyShap));
    }
    public boolean check (int width, int height){
        Rectangle size = getShape().getBounds();
        if (getX() <= -size.getWidth() || getY() < -size.getHeight() || getX()> width ||getY()> height){
            return false;
        }
        else {
            return true;
        }
    }
}
