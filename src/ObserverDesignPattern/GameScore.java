
package ObserverDesignPattern;

import controller.Main;
import java.util.ArrayList;
import model.FlyingSaucer;
import view.GamePanel;
import view.MainWindow;

public class GameScore implements Subject{
    private final ArrayList<Observer> enemy;
    String gameFigure = new String();
    public GameScore() {
        enemy = new ArrayList<Observer>();
    }    
    public void setGameScore() {
        this.setState(new SubjectEvent((this), gameFigure));        
        notifyEvent();
    }    
    private SubjectEvent state;   
    @Override
    public void attach(Observer o) {  
        enemy.add(o);  
        gameFigure = o.getGameFigure();
    }
    @Override
    public void detach(Observer o) {   
        enemy.remove(o);
    }    
    @Override
    public SubjectEvent getState() {
        return state;
    }
    @Override
    public void setState(SubjectEvent state) {
        this.state = state;
    }        
    @Override
    public void notifyEvent() {
        for (Observer o: enemy) {
            o.update(this.getState());
        }    
    } 
}
