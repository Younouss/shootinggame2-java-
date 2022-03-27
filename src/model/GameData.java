package model;

import ObserverDesignPattern.GameScore;
import ObserverDesignPattern.UfoObserver;
import ObserverDesignPattern.BombObserver;
import ObserverDesignPattern.AlienObserver;
import ObserverDesignPattern.PlanetObserver;
import controller.Main;
import view.GamePanel;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import view.MainWindow;

public class GameData {

    private final int RADIUS = 6;
    public final List<GameFigure> enemyFigures;
    public final List<GameFigure> friendFigures;
    public Shooter shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 130);
    public int uTotal = 0;    
    public int uDestroyed = 0;
    public int uAlive = 0;
    public int bTotal = 0;
    public int bDestroyed = 0;
    public int bAlive = 0;
    public int aTotal = 0;
    public int aDestroyed = 0;
    public int aAlive = 0;
    UfoObserver ufo = new UfoObserver();
    BombObserver bomb = new BombObserver();
    AlienObserver alien = new AlienObserver();
    PlanetObserver planet = new PlanetObserver();   
    GameScore gameScore = new GameScore();
    public void displayUfoScore(){
        gameScore.attach(ufo); 
        gameScore.setGameScore();
    }
    public void displayBombScore(){
        gameScore.attach(bomb); 
        gameScore.setGameScore();
    }    
    public void displayAlienScore(){
        gameScore.attach(alien);
        gameScore.setGameScore();
    }    
    public final List<GameFigure> destroyedFigures = Collections.synchronizedList(
                new CopyOnWriteArrayList<GameFigure>()); 
    public GameData() {
        enemyFigures = Collections.synchronizedList(
                new CopyOnWriteArrayList<GameFigure>());
        friendFigures = Collections.synchronizedList(
                new CopyOnWriteArrayList<GameFigure>());

        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.

        friendFigures.add(shooter);
        
    }
    public void addUfo(int n) {   
        enemyFigures.add(new FlyingSaucer((int) (Math.random() * GamePanel.width), (int) (Math.random() * GamePanel.height)));           
    }
    
    public void addBomb(int n) {
        synchronized (enemyFigures) {
            for (int i = 0; i < n; i++) {
                float red = (float) Math.random();
                float green = (float) Math.random();
                float blue = (float) Math.random();
                // adjust if too dark since the background is black
                if (red < 0.5) {
                    red += 0.2;
                }
                if (green < 0.5) {
                    green += 0.2;
                }
                if (blue < 0.5) {
                    blue += 0.2;
                }
                enemyFigures.add(new Bomb(
                        (int) (Math.random() * GamePanel.width),
                        (int) (Math.random() * GamePanel.height),
                        RADIUS,
                        new Color(red, green, blue)));
            }
        }
    }
    public void addAlien(int n) {       
        enemyFigures.add(new Alien((int) (Math.random() * GamePanel.width), (int) (Math.random() * GamePanel.height)));    
    }  
    public void update() {
        
        // no enemy is removed in the program
        // since collision detection is not implemented yet.
        // However, if collision detected, simply set
        // f.state = GameFigure.STATE_DONE
        synchronized (enemyFigures) {
           // ArrayList<GameFigure> remove = new ArrayList<>();
            GameFigure f;
            for (int i = 0; i < enemyFigures.size(); i++) {
                f = enemyFigures.get(i);
                if (f.state == GameFigure.STATE_DONE) { 
                    //remove.add(f);
                    if(f.type == 1){
                        destroyedFigures.add(f);  
                        enemyFigures.remove(f);
                        uDestroyed += 1;
                        uAlive = uTotal - uDestroyed;
                        displayUfoScore();
                    }
                    if(f.type == 2){
                        destroyedFigures.add(f);     
                        enemyFigures.remove(f);                        
                        bDestroyed += 1;
                        bAlive = bTotal - bDestroyed;
                        displayBombScore();
                    }
                    if(f.type == 3){
                        destroyedFigures.add(f);  
                        enemyFigures.remove(f);
                        aDestroyed += 1;
                        aAlive = aTotal - aDestroyed;                       
                        displayAlienScore();
                    }
                    if(f.type == 4){
                        destroyedFigures.add(f);     
                        enemyFigures.remove(f); 
                        gameScore.attach(planet); 
                        gameScore.setGameScore();                        
                    }
                }
            }
            //enemyFigures.removeAll(remove);
            for (GameFigure g : enemyFigures) {
                g.update();
            }
        }
        synchronized(destroyedFigures){
            for (GameFigure f : destroyedFigures) {
                f.deadBehavior();
            }            
        }
        
        // missiles are removed if explosion is done
        synchronized (friendFigures) {
            ArrayList<GameFigure> remove = new ArrayList<>();
            GameFigure f;
            for (int i = 0; i < friendFigures.size(); i++) {
                f = friendFigures.get(i);
                if (f.state == GameFigure.STATE_DONE) {
                    remove.add(f);
                }
            }
            friendFigures.removeAll(remove);
            for (GameFigure g : friendFigures) {
                g.update();
            }
        }
    }
}
