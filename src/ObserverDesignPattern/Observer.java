package ObserverDesignPattern;


public interface Observer {
    void update(SubjectEvent event);
    String getGameFigure();
}
