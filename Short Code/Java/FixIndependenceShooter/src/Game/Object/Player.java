/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;



import java.awt.geom.Area;
import java.awt.geom.Path2D;

/**
 *
 * @author aimgs
 */
public class Player extends PlayerParent {
    



    
    public Player(int setHp){
        super(setHp,setHp);
        this.setImage("/image/GameAsset/player1.png");
        Path2D p = new Path2D.Double();
        p.moveTo(30,20);
        p.lineTo(30,5);
        p.lineTo(getPLAYER_SIZE(), getPLAYER_SIZE()/2);
        p.lineTo(30, getPLAYER_SIZE()-10);
        p.lineTo(30, getPLAYER_SIZE());
        this.setPlayerShap (new Area(p));
    }
    

    @Override
    public void changeLocation(double x, double y){
        this.setX(x); 
        this.setY(y); 
        
         if(x<=-28){
           this.setX(-28);
       }
       if(x>=800){
           this.setX(800);
       }
       if(y<=-20){
           this.setY(-20);
       }
       if(y>=525){
          this.setY(525);
       }
    }

    

    
 
}
