package VisitorDesignPattern;

/*
 * Participant: Element
 */

public interface GameElement {
    
    void accept(Visitor v);
    
}
