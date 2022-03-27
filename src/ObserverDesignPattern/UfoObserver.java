package ObserverDesignPattern;


public class UfoObserver implements Observer {
    @Override
    public void update(SubjectEvent event) {
        event.getSubject();;
    }   
    @Override
    public String getGameFigure(){
        return("UFO");
    }
}
