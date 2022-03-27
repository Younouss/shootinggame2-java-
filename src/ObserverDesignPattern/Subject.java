package ObserverDesignPattern;


public interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);    
    public void notifyEvent();    
    public SubjectEvent getState();
    void setState(SubjectEvent s); 
}
