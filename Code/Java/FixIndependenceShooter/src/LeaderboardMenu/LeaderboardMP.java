/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeaderboardMenu;

/**
 *
 * @author aimgs
 */
public class LeaderboardMP {
    private int No;
    private String Name;
    private String Name2;
    private int Score;
    private String level;

    public LeaderboardMP(int No,String Name,String Name2, int Score, String level) {
        this.No = No;
        this.Name = Name;
        this.Name2 = Name2;
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

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
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
