/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeaderboardMenu;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author aimgs
 */
public class LeaderboardDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;
    
    public LeaderboardDAO(){
        url = "jdbc:mysql://localhost/isld";
        uname = "root";
        pass = "Apotoxin4869";
        setConnectionAndStatement();
    }
    
    public void setConnectionAndStatement(){
        try {
            con = DriverManager.getConnection(url, uname, pass);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }

    
    public Leaderboard getSP(int No){
        Leaderboard leaderboard = null;
        
        try{
            query = "SELECT * FROM singleplayer WHERE No = '%d'";
            query = String.format(query, No);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboard = new Leaderboard(
                rs.getInt("No"),
                rs.getString("Name"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboard == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboard;
    }
    
    public LeaderboardMP getMP(int No){
        LeaderboardMP leaderboardMP = null;
        
        try{
            query = "SELECT * FROM multiplayer WHERE No = '%d'";
            query = String.format(query, No);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboardMP = new LeaderboardMP(
                rs.getInt("No"),
                rs.getString("Name1"),
                rs.getString("Name2"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboardMP == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboardMP;
    }
    
    public Leaderboard getHstSP(int No){
        Leaderboard leaderboard = null;
        
        try{
            query = "SELECT * FROM historysingleplayer WHERE NoID = '%d'";
            query = String.format(query, No);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboard = new Leaderboard(
                rs.getInt("NoID"),
                rs.getString("Name"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboard == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboard;
    }
    
    public LeaderboardMP getHstMP(int No){
        LeaderboardMP leaderboardMP = null;
        
        try{
            query = "SELECT * FROM historymultiplayer WHERE NoID = '%d'";
            query = String.format(query, No);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboardMP = new LeaderboardMP(
                rs.getInt("NoID"),
                rs.getString("Name1"),
                rs.getString("Name2"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboardMP == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboardMP;
    }
    
    public Leaderboard getLastSP(){
        Leaderboard leaderboard = null;
        
        try{
            query = "SELECT * FROM historysingleplayer ORDER BY NoID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboard = new Leaderboard(
                rs.getInt("NoID"),
                rs.getString("Name"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboard == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboard;
    }
    
    public LeaderboardMP getLastMP(){
        LeaderboardMP leaderboardMP = null;
        
        try{
            query = "SELECT * FROM historymultiplayer ORDER BY NoID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                leaderboardMP = new LeaderboardMP(
                rs.getInt("NoID"),
                rs.getString("Name1"),
                rs.getString("Name2"),
                rs.getInt("Score"),
                rs.getString("Enemy"));
            }
            
            if(leaderboardMP == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboardMP;
    }
    
    public void saveHistorySP (Leaderboard leaderboard){
        try {
            query = "INSERT INTO historysingleplayer (Name,Score,Enemy) VALUES ('%s', '%d', '%s')";
            query = String.format(query, 
                    leaderboard.getName(),
                    leaderboard.getScore(),
                    leaderboard.getLevel());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        }catch (SQLException ex) {
            System.err.print("Error inserting data " + ex.getMessage());
            System.exit(1);
        }
    }
    public void saveHistoryMP (LeaderboardMP leaderboardMP){
        try {
            query = "INSERT INTO historymultiplayer(Name1,Name2,Score,Enemy) VALUES ('%s', '%s', '%d', '%s')";
            query = String.format(query, 
                    leaderboardMP.getName(),
                    leaderboardMP.getName2(),
                    leaderboardMP.getScore(),
                    leaderboardMP.getLevel());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        }catch (SQLException ex) {
            System.err.print("Error inserting data " + ex.getMessage());
            System.exit(1);
        }
    }

    
    public void updateMP(LeaderboardMP leaderboardMP){
        try{
            query = "UPDATE multiplayer SET Name1 = '%s',Name2 = '%s', Score='%d',Enemy ='%s'"
                    +"WHERE No = '%d'";
            query = String.format(
            query,
                    leaderboardMP.getName(),
                    leaderboardMP.getName2(),
                    leaderboardMP.getScore(),
                    leaderboardMP.getLevel(),
                    leaderboardMP.getNo());
            stmt.executeUpdate(query);
            System.out.println("Berhasil mengupdate data!");
        }catch(SQLException ex){
            System.err.print(("Error updating data: "+ex.getMessage()));
            System.exit(1);
        }
    }
    public void updateSP(Leaderboard leaderboard){
        try{
            query = "UPDATE singleplayer SET Name = '%s', Score='%d',Enemy ='%s'"
                    +"WHERE No = '%d'";
            query = String.format(
            query,
                    leaderboard.getName(),
                    leaderboard.getScore(),
                    leaderboard.getLevel(),
                    leaderboard.getNo());
            stmt.executeUpdate(query);
            System.out.println("Berhasil mengupdate data!");
        }catch(SQLException ex){
            System.err.print(("Error updating data: "+ex.getMessage()));
            System.exit(1);
        }
    }
    

}
