/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeaderboardMenu;

/**
 *
 * @author aimgs
 */
public class Leaderboard {
    private int No;
    private String Name;
    private int Score;
    private String level;

    public Leaderboard(int No,String Name, int Score,String level) {
        this.No = No;
        this.Name = Name;
        this.Score = Score;
        this.level=level;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    
}
