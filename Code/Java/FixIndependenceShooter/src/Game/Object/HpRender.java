/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author aimgs
 */
public class HpRender {
    private final HP hp;

    public HpRender(HP hp){
        this.hp = hp;
    }
    
    protected void hpRender(Graphics2D g2, Shape shape, double y){
        if(hp.getCurrentHp() != hp.getMAX_HP()){
        double hpY = shape.getBounds().getY() - y - 10;
        g2.setColor(new Color(70, 70, 70));
        g2.fill(new Rectangle2D.Double(0, hpY, PlayerParent.getPLAYER_SIZE(), 2));
        g2.setColor(new Color(210, 0, 0));
        double hpSize=hp.getCurrentHp()/hp.getMAX_HP()*PlayerParent.getPLAYER_SIZE();
        g2.fill(new Rectangle2D.Double(0, hpY, hpSize, 2 ));
        }
    }
    
    public boolean updateHP(double cutHP){
        hp.setCurrentHp(hp.getCurrentHp() - cutHP);
        return hp.getCurrentHp() > 0;
    }
    public double getHP(){
        return hp.getCurrentHp();
    }
    public void resetHP(){
        hp.setCurrentHp(hp.getMAX_HP());
    }
    
}
