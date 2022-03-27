package ObserverDesignPattern;


public class BombObserver implements Observer {
    @Override
    public void update(SubjectEvent event) {
        event.getSubject();;
    }   
    @Override
    public String getGameFigure(){
        return("Bomb");
    }
}
