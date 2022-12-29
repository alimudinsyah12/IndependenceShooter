/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.SinglePlayer;

import Game.keyInput.KeyInput;
import LeaderboardMenu.Leaderboard;
import LeaderboardMenu.LeaderboardDAO;
import Game.object.Bullet;
import Game.object.Effect;
import Game.object.Army;
import Sound.Sound;
import Game.object.Player;
import Game.object.Tank;
import Game.object.TankBullet;
import GameOver.GameOverFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author aimgs
 */
public class SinglePlayerPanel extends JComponent {
    private SinglePlayerFrame parentWindow;
    private Graphics2D g2;
    private BufferedImage image;
    private KeyInput keyInput;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    private int shotTime;
    private Image background;
    
    //backsound and Sound Effect
    private Sound bgMusic;
    private Sound shoot;
    private Sound gameOver;
    private Sound merdeka;
    private Sound takbir;
    private Sound tankShoot;
    private Sound waveWarning;

    
    //Game FPS
    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000/FPS;
    
    private int cLevel;
    private int pickPlayer1;
    private String name1;
    
    //GameObject
    private Player player;
    private List <Bullet> bullets;
    private List <Army> armies;
    private List<TankBullet>tBullets;
    private List<Tank>tanks;
    private List<Effect>boomEffects;
    private int score = 0;
    
    public SinglePlayerPanel(SinglePlayerFrame mainWindow)
    {
        this.parentWindow = mainWindow;
    }
    
    public void start( int level, int firstPlayer, String firstName){
        width = getWidth();
        height = getHeight();
        background =new ImageIcon(getClass().getResource("/image/Background/backgroundGame.png")).getImage();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        cLevel=level;
        pickPlayer1=firstPlayer;
        name1=firstName;
        bgMusic = new Sound("/Sound/backsound.mp3");
        shoot = new Sound("/Sound/shoot.mp3");
        gameOver = new Sound("/Sound/gameOver.mp3");
        merdeka = new Sound("/Sound/merdeka.mp3");
        takbir = new Sound("/Sound/takbir.mp3");
        tankShoot = new Sound("/Sound/Explode.mp3");
        waveWarning = new Sound("/Sound/warning.mp3");
        bgMusic.playLoop();
        
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(start){
                    long startTime = System.nanoTime();
                    drawBackground();
                    drawGame();
                    drawWave();
                    gameOver();
                    render();
                    long time = System.nanoTime() - startTime;
                    if(time < TARGET_TIME){
                        long sleep = (TARGET_TIME - time)/1000000;
                        sleep(sleep);
                        //System.out.println(sleep);
                    }
                }}
            
        });
        
        initObjectGame();
        initKeyboard();
        initKeyboard3();
        initBullets();
        
            thread.start();
    }
    
    private void addArmy(){
        Random ran = new Random();
        int locationY=ran.nextInt(height-50)+25;
        int setterHp = 0;
        if(cLevel==1){
          setterHp=50;
        }else if(cLevel==2){
          setterHp=75;
        }else if(cLevel==3){
          setterHp=100;
        }
        Army army= new Army(setterHp);
        army.changeLocation(width,locationY);
        army.changeAngle(180);
        armies.add(army);
    }
    
    private void addArmy2(){
        Random ran = new Random();
        int locationY=ran.nextInt(height-50)+25;
        int locationAngle = ran.nextInt(0, 30);
        int setterHp = 0;
        if(cLevel==1){
          setterHp=50;
        }else if(cLevel==2){
          setterHp=75;
        }else if(cLevel==3){
          setterHp=100;
        }
        Army army= new Army(setterHp);
        army.changeLocation(width,locationY);
        army.changeAngle(locationAngle+180);
        armies.add(army);
    }
    
    private void addArmy3(){
        Random ran = new Random();
        int locationY=ran.nextInt(height-50)+25;
        int locationAngle = ran.nextInt(45, 60);
        int setterHp = 0;
        if(cLevel==1){
          setterHp=50;
        }else if(cLevel==2){
          setterHp=75;
        }else if(cLevel==3){
          setterHp=100;
        }
        Army army= new Army(setterHp);
        army.changeLocation(width,locationY);
        army.changeAngle(locationAngle+90);
        armies.add(army);
    }
    
    private void addTankBullet(){
        Random random = new Random();
        int locationY=random.nextInt(height-50)+25;
        int setterAp = 0;
        if(cLevel==1){
          setterAp=10;
        }else if(cLevel==2){
          setterAp=15;
        }else if(cLevel==3){
          setterAp=20;
        }
        TankBullet tBullet= new TankBullet(setterAp);  
        Tank tank = new Tank();
        tank.changeLocation(width-90, locationY+30);
        tank.changeAngle(180);
        tBullet.changeLocation(width-90,locationY);
        tBullet.changeAngle(180);
        tanks.add(tank);
        tBullets.add(tBullet);
        tankShoot.play();
        
        sleep(2000);
        tanks.remove(tank);
    }
    
    private void initObjectGame(){
        if(pickPlayer1==1){
            player = new Player(85);
        }else if(pickPlayer1==2){
            player = new Player(95);
        }else if(pickPlayer1==3){
            player = new Player(80);
        }else if(pickPlayer1==4){
            player = new Player(90);
        }else if(pickPlayer1==5){
            player = new Player(75);
        }
        
        player.changeLocation(25, 225);
        armies = new ArrayList<>();
        tanks = new ArrayList<>();
        tBullets = new ArrayList<>();
        boomEffects = new ArrayList<>();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(2000);
                while (start){
                    Random random = new Random();
                    int chooser = random.nextInt(1,4);
                    if(chooser==1){
                        addArmy();
                    }else if(chooser==2){
                        if(score>=10*cLevel){
                        addArmy2();
                        }else{
                        addArmy();
                        }
                    }else if(chooser==3){
                        if(score>=20*cLevel){
                        addArmy3();
                        }else{
                        addArmy();
                    }
                    }
                    
                    if(score>=10*cLevel&&score<30*cLevel){
                       sleep(3000/cLevel);  
                    }else if(score>=30*cLevel){
                       sleep(2000/cLevel);
                    }else{
                        sleep(4000/cLevel);
                    }
                     
                    
                    
                }
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start){
                    
                     if(score>=(30*cLevel)){
                        addTankBullet();  
                    }
                    sleep(4000/cLevel);
                }
            }
        }).start();
    }
    
    private void resetGame(){
        score=0;
        armies.clear();
        bullets.clear();
        tanks.clear();
        tBullets.clear();
        player.reset();
        
        bgMusic.play();
        player.changeLocation(25,225);
    }
    private void initKeyboard(){
        keyInput = new KeyInput();
        requestFocus();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key==KeyEvent.VK_A){
                    keyInput.setKey_a(true);
                }else if (key==KeyEvent.VK_D){
                    keyInput.setKey_d(true);
                }else if (key==KeyEvent.VK_S){
                    keyInput.setKey_s(true);
                }else if (key==KeyEvent.VK_W){
                    keyInput.setKey_w(true);
                }else if (key==KeyEvent.VK_SPACE){
                    keyInput.setKey_space(true);
                }
                else if (key==KeyEvent.VK_ENTER){
                    keyInput.setKey_enter(true);
                }  
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                int key = e.getKeyCode();
                if(key==KeyEvent.VK_A){
                    keyInput.setKey_a(false);
                }else if (key==KeyEvent.VK_D){
                    keyInput.setKey_d(false);
                }else if (key==KeyEvent.VK_S){
                    keyInput.setKey_s(false);
                }else if (key==KeyEvent.VK_W){
                    keyInput.setKey_w(false);
                }else if (key==KeyEvent.VK_SPACE){
                    keyInput.setKey_space(false);
                }else if (key==KeyEvent.VK_ENTER){
                    keyInput.setKey_enter(false);
                }
                
            }
        });
        
        new Thread(new Runnable(){
            @Override
            public void run(){

                while(start){
                    if(player.getAlive()){
                        double x = player.getX();
                        double y = player.getY();

                    if(keyInput.isKey_a()){
                        y--;
                    }
                    if(keyInput.isKey_d()){
                        y++;
                    }
                    if(keyInput.isKey_w()){
                        x++;
                    }
                    if(keyInput.isKey_s()){
                        x--;
                    }
                    if(keyInput.isKey_space()){
                     if (shotTime==0){
                         if(pickPlayer1==1){
                             bullets.add(0, new Bullet(player.getX()+20, player.getY()+18,player.getAngle(), 35, 3f));
                         }else if(pickPlayer1==2){
                             bullets.add(0, new Bullet(player.getX()+20, player.getY()+18,player.getAngle(), 25, 3f));
                         }else if(pickPlayer1==3){
                             bullets.add(0, new Bullet(player.getX()+20, player.getY()+18,player.getAngle(), 40, 3f));
                         }else if(pickPlayer1==4){
                             bullets.add(0, new Bullet(player.getX()+20, player.getY()+18,player.getAngle(), 30, 3f));
                         }else if(pickPlayer1==5){
                             bullets.add(0, new Bullet(player.getX()+20, player.getY()+18,player.getAngle(), 45, 3f));
                         }
                        
                        shoot.play();
                        }
                        shotTime++;
                        if(shotTime == 25){
                            shotTime = 0;
                        }
                    }else{
                        shotTime = 0;
                    }
                    player.changeLocation(x,y);
                    }
                    
                    for(int i = 0; i <armies.size(); i++){
                        Army army = armies.get(i);
                        if(army != null){
                            army.update();
                            if (!army.check(width, height)){
                                armies.remove(army);
                                //System.out.println("Removed");
                            }else{
                                if(player.getAlive()){
                                    checkPlayer(army);
                                }  
                            }
                            
                        }
                    }
                    
                    for(int i = 0; i <tBullets.size(); i++){
                        TankBullet tBullet = tBullets.get(i);
                        if(tBullets != null){
                            tBullet.update();
                            if (!tBullet.check(width, height)){
                                 tBullets.remove(tBullet);
                            }else{
                                if(player.getAlive()){
                                    checkPlayerFromBullet(tBullet);
                                }
                            }
                        }
                    }
                    sleep(5);
                }
            }
        }).start();
    }
    
    
    
    private void initKeyboard3(){
        keyInput = new KeyInput();
        requestFocus();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                 if (key==KeyEvent.VK_ENTER){
                    keyInput.setKey_enter(true);
                }else if (key==KeyEvent.VK_ESCAPE){
                    keyInput.setKey_esc(true);
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                int key = e.getKeyCode();
                if (key==KeyEvent.VK_ENTER){
                    keyInput.setKey_enter(false);
                }else if (key==KeyEvent.VK_ESCAPE){
                    keyInput.setKey_esc(false);
                }
            }
        });
        
        new Thread(new Runnable(){
            @Override
            public void run(){

                while(start){
                    if(!player.getAlive()){
                        if(keyInput.isKey_enter()){
                            resetGame();
                        }

                    }
                    
                    
                    sleep(5);
                }
            }
        }).start();
    }
    
    private void initBullets(){
        bullets = new ArrayList<>();
        new Thread(new Runnable(){
            @Override
            public void run(){
                while (start){
                    
                    for (int i = 0; i<bullets.size(); i++)
                    {
                        Bullet bullet = bullets.get(i);
                        if(bullet!= null){
                            bullet.update();
                            checkBullets(bullet);
                            if (!bullet.check(width, height)){
                                bullets.remove(bullet);
                            }
                        }else {
                            bullets.remove(bullet);
                        }
                    }
                    
                    for(int i = 0; i < boomEffects.size();i++){
                        Effect boomEffect = boomEffects.get(i);
                        if(boomEffect !=null ){
                            boomEffect.update();
                            if(!boomEffect.check()){
                                boomEffects.remove(boomEffect);
                            }
                        }else{
                            boomEffects.remove(boomEffect);
                        }
                    }
                    sleep(1);
                }
                
            }
        }).start();
    }
    

    private void checkBullets(Bullet bullet){
        for (int i=0;i<armies.size();i++){
            Army army= armies.get(i);
            if(army!=null){
                Area area = new Area(bullet.getShape());
                area.intersect(army.getShape());
                
                if (!area.isEmpty()){
                    boomEffects.add(new Effect(bullet.getCenterX(), bullet.getCenterY(), 3, 5, 60, 0.5f, new Color(230, 207, 105)));
                    
                    if(!army.updateHP(bullet.getSize())){
                        if(cLevel==1){
                           score++;
                          }else if(cLevel==2){
                            score+=2;
                          }else if(cLevel==3){
                            score+=3;
                          }
                        
                     armies.remove(army);
                     merdeka.play();
                     double x = army.getX() + Army.getENEMY_SIZE()/2;
                     double y = army.getY() + Army.getENEMY_SIZE()/2;
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.05f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.1f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.3f, new Color(230, 207, 105)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.5f, new Color(255, 70, 70)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.2f, new Color(255, 255, 255)));
                    }
                    
                    bullets.remove(bullet);
                }
            }
        }
    }
    
    
    private void checkPlayer(Army army){
            if(army!=null){
                Area area = new Area(player.getShape());
                area.intersect(army.getShape());
                
                if (!area.isEmpty()){
                    double armyHp = army.getHP();
                    if(!army.updateHP(player.getHP())){
                     armies.remove(army);
                       if(cLevel==1){
                           score++;
                          }else if(cLevel==2){
                            score+=2;
                          }else if(cLevel==3){
                            score+=3;
                          }
                     merdeka.play();
                     double x = army.getX() + Army.getENEMY_SIZE()/2;
                     double y = army.getY() + Army.getENEMY_SIZE()/2;
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.05f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.1f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.3f, new Color(230, 207, 105)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.5f, new Color(255, 70, 70)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.2f, new Color(255, 255, 255)));
                    }
                    
                    if(!player.updateHP((50+((cLevel-1)*25))/2)){
                     player.setAlive(false);
                     gameOver.play();
                     double x = player.getX() + Player.getPLAYER_SIZE()/2;
                     double y = player.getY() + Player.getPLAYER_SIZE()/2;
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.05f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.1f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.3f, new Color(230, 207, 105)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.5f, new Color(255, 70, 70)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.2f, new Color(255, 255, 255)));
                    }
                    
                }
            
        }
    }
    
    private void checkPlayerFromBullet(TankBullet tBullet){
            if(tBullet!=null){
                Area area = new Area(player.getShape());
                area.intersect(tBullet.getShape());
                
                if (!area.isEmpty()){
                    double attackPoint = tBullet.getHP();
                    if(!tBullet.updateHP(player.getHP())){
                     tBullets.remove(tBullet);
                     double x = tBullet.getX() + TankBullet.getENEMY_SIZE()/2;
                     double y = tBullet.getY() + TankBullet.getENEMY_SIZE()/2;
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.05f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.1f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.3f, new Color(230, 207, 105)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.5f, new Color(255, 70, 70)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.2f, new Color(255, 255, 255)));
                    }
                    
                   if(!player.updateHP(attackPoint)){
                     player.setAlive(false);
                     
                     if(!player.getAlive()){
                         gameOver.play();
                     }
                     else{
                        takbir.play(); 
                     }
                     
                     double x = player.getX() + Player.getPLAYER_SIZE()/2;
                     double y = player.getY() + Player.getPLAYER_SIZE()/2;
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.05f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 5, 3, 75, 0.1f, new Color(32, 178, 169)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.3f, new Color(230, 207, 105)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.5f, new Color(255, 70, 70)));
                     boomEffects.add(new Effect(x, y, 10, 3, 100, 0.2f, new Color(255, 255, 255)));
                    }
                }
            }
    }
    
    private void drawBackground(){
         g2.drawImage(background, 0,0, null);
         
    }

    private void drawGame(){
        
        if(player.getAlive()){
           player.draw(g2);
        }
        
        
        for (int i = 0; i< bullets.size(); i++){
            Bullet bullet  = bullets.get(i);
            if (bullet != null){
                bullet.draw(g2);
            }
        }

        
        for(int i = 0; i <armies.size(); i++){
            Army army = armies.get(i);
            if(army != null){
                army.draw(g2);
            }
        }
        
        for(int i = 0; i <tanks.size(); i++){
            Tank tank = tanks.get(i);
            if(tank != null){
                tank.draw(g2);
            }
        }
        
        for (int i = 0; i< tBullets.size(); i++){
            TankBullet tbullet  = tBullets.get(i);
            if (tbullet != null){
                tbullet.draw(g2);
            }
        }
        
        for (int i = 0; i< boomEffects.size();i++){
            Effect boomEffect = boomEffects.get(i);
            if(boomEffect != null){
                boomEffect.draw(g2);
            }
        }
        
        g2.setColor(Color.WHITE);
        g2.setFont(getFont().deriveFont(Font.BOLD,15f));
        g2.drawString("Score : " + score, 10, 20);
        
    }
    private void drawWave(){
        if(player.getAlive()){
        g2.setColor(Color.RED);
        
        if (score==(10*cLevel)-cLevel||score==(20*cLevel)-cLevel||score==(30*cLevel)-cLevel){
        waveWarning.play();
        }
        if(score==(10*cLevel)){
            g2.setFont(new Font("Arcade Normal",Font.BOLD,60));
            g2.drawString("Second Wave!",100,300);
            g2.setFont(new Font("Arcade Normal",Font.BOLD,25));
            g2.drawString("Watch Out Right Side!",205,340);
       }else if(score==(20*cLevel)){
           g2.setFont(new Font("Arcade Normal",Font.BOLD,60));
           g2.drawString("Third Wave!",120,300);
           g2.setFont(new Font("Arcade Normal",Font.BOLD,25));
           g2.drawString("Watch Out Also Left Side!",155,340);
        }else if(score==(30*cLevel)){
           g2.setFont(new Font("Arcade Normal",Font.BOLD,60));
           g2.drawString("Final Wave !",100,300);
           g2.setFont(new Font("Arcade Normal",Font.BOLD,25));
            g2.drawString("Watch Out! A Tank Is Coming!",115,340);
        }
        }
        
    }
    private void gameOver(){
        if(!player.getAlive()){
            bgMusic.stop();
            merdeka.stop();
            start=false;
            
            LeaderboardDAO dao = new LeaderboardDAO();
            Leaderboard hs = dao.getSP(1);
            Leaderboard ts = dao.getSP(10);
            int tenScore = ts.getScore();
            int highScore = hs.getScore();
            
            String tLevel="";
            if(cLevel==1){
               tLevel="PRT";
               }else if(cLevel==2){
               tLevel="NLD";
               }else if(cLevel==3){
               tLevel="JPN";
            }
            
            Leaderboard hsp = new Leaderboard(0, name1,score,tLevel);
            dao.saveHistorySP(hsp);
            
            if(score<tenScore){
                new GameOverFrame(highScore,0,score, cLevel, pickPlayer1,name1,0,"");
                parentWindow.setVisible(false);
                parentWindow.dispose();
                
            }else if(score>=tenScore){
                
              Leaderboard s = dao.getSP(11);
              s.setName(name1);
              s.setScore(score);
              if(cLevel==1){
               s.setLevel("PRT");
               }else if(cLevel==2){
               s.setLevel("NLD");
               }else if(cLevel==3){
               s.setLevel("JPN");
               }
              dao.updateSP(s);
            
            for(int i = 1;i<12;i++){
                for(int j = i+1;j<12;j++){
                    Leaderboard p = dao.getSP(i);
                    Leaderboard q = dao.getSP(j);
                    
                    if(p.getScore()<q.getScore()){
                        
                        int tempScore = p.getScore();
                        p.setScore(q.getScore());
                        q.setScore(tempScore);
                        
                        String tempName= p.getName();
                        p.setName(q.getName());
                        q.setName(tempName);
                        
                        String tempLevel= p.getLevel();
                        p.setLevel(q.getLevel());
                        q.setLevel(tempLevel);
                        
                        dao.updateSP(p);
                        dao.updateSP(q);
                    }
                }
            }
            
            int pos=0;
            for(int i=1;i<10;i++){
                Leaderboard t = dao.getSP(i);
                if(t.getName().equals(name1)&& t.getScore()==score){
                    pos=i;
                 }
                
            }
                new GameOverFrame(highScore,pos,score, cLevel, pickPlayer1,name1,0,"");
                parentWindow.setVisible(false);
                parentWindow.dispose();
            }
           
        }
    }
    private void render(){
       Graphics g = getGraphics();
       g.drawImage(image, 0, 0, null);
       g.dispose();
    }
    public void sleep(long speed){
        try{
            Thread.sleep(speed);
            
        }catch(InterruptedException ex){
            System.err.println(ex);
        }
    }
    
}
