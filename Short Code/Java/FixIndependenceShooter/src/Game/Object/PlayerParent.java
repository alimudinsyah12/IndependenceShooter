/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 *
 * @author aimgs
 */
public class PlayerParent extends HpRender{
    
    private static final double PLAYER_SIZE = 96;
    private double x;
    private double y;
    private float angle = 0f;
    private boolean alive = true;
    private Image image;
    private Area playerShap;

    
    public PlayerParent(int MAX_HP, int CURRENT_HP){
        super(new HP(MAX_HP,CURRENT_HP));
    }
    

    public void changeLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void changeAngle(float angle){
        if(angle < 0){
            angle=359;
        } else if (angle > 359) {
            angle = 0;
        }
        this.angle = angle;
    }
        public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(getX(),getY());
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(getAngle()), getPLAYER_SIZE()/2, getPLAYER_SIZE()/2);
        g2.drawImage(image, tran, null);
        hpRender(g2, getShape(), getY());
        g2.setTransform(oldTransform);
        
        //test shap
       //g2.setColor(new Color(12, 173, 84));
       //g2.draw(getShape());
       //g2.draw(getShape().getBounds());
    }
        
    public Area getShape(){
        AffineTransform afx = new AffineTransform();
        afx.translate(getX(),getY());
        afx.rotate(Math.toRadians(getAngle()), getPLAYER_SIZE()/ 2, getPLAYER_SIZE()/ 2);
        return  new Area(afx.createTransformedShape(playerShap));
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public float getAngle() {
        return angle;
    }
    
    public Image getImage() {
        return image;
    }
    public static double getPLAYER_SIZE() {
        return PLAYER_SIZE;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setImage(String image){
        this.image =new ImageIcon(getClass().getResource(image)).getImage();
    }

    public void setPlayerShap(Area playerShap) {
        this.playerShap = playerShap;
    }

    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void reset(){
        alive = true;
        resetHP();
        angle = 0;
    }
    
 
}
