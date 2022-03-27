package ObserverDesignPattern;


public class PlanetObserver implements Observer {
    @Override
    public void update(SubjectEvent event) {
        event.getSubject();
    }   
    @Override
    public String getGameFigure(){
        return("Planet");
    }
}
