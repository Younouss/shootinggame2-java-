package ObserverDesignPattern;


public class AlienObserver implements Observer {
    @Override
    public void update(SubjectEvent event) {
        event.getSubject();;
    }   
    @Override
    public String getGameFigure(){
        return("Alien");
    }
}