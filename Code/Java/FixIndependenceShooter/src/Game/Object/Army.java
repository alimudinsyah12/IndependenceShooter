/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;


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
public class Army extends EnemyParent{
    private final Image image;
    private final Area enemyShap;

    public Army(int setHp) {
        super(setHp,setHp);
        String loc = null;
        if(setHp==50){
            loc="/image/gameAsset/portugueseArmy.png";
            this.setSpeed(0.25f);
        }else if(setHp==75){
            loc="/image/gameAsset/dutchArmy.png";
            this.setSpeed(0.30f);
        }else if(setHp==100){
            loc="/image/gameAsset/japanArmy.png";
            this.setSpeed(0.40f);
        }
        this.image = new ImageIcon(getClass().getResource(loc)).getImage();
        Path2D p = new Path2D.Double();
        p.moveTo(30, 20);
        p.lineTo(30, 5);
        p.lineTo(getENEMY_SIZE(), getENEMY_SIZE()/2);
        p.lineTo(30, getENEMY_SIZE()-10);
        p.lineTo(30, getENEMY_SIZE());
        enemyShap= new Area(p);
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
        tran.rotate(Math.toRadians(getAngle() ), getENEMY_SIZE()/2, getENEMY_SIZE()/2);
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
        if (getX() <= -size.getWidth() || getY() < -size.getHeight() || getX() > width || getY() > height){
            return false;
        }
        else {
            return true;
        }
    }
}
