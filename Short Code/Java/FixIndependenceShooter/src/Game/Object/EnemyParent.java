/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.object;

/**
 *
 * @author aimgs
 */
public class EnemyParent extends HpRender{
    
    private static final double ENEMY_SIZE = 96;
    private double x;
    private double y;
    private float speed;
    private float angle = 0f;
   
    public EnemyParent(int MAX_HP, int CURRENT_HP){
        super(new HP(MAX_HP,CURRENT_HP));
    }
    

    public void changeLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void update(){
        x += Math.cos(Math.toRadians(angle))*speed;
        y += Math.sin(Math.toRadians(angle))*speed;
    }

    public void changeAngle(float angle){
        if(angle < 0){
            angle=359;
        } else if (angle > 359) {
            angle = 0;
        }
        this.angle = angle;
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

    public static double getENEMY_SIZE() {
        return ENEMY_SIZE;
    }

    public float getSpeed() {
        return speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }


    
 
}
