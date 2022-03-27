package VisitorDesignPattern;

import model.Alien;
import model.Bomb;
import model.FlyingSaucer;
import model.Missile;
import model.Shooter;

/*
 * Participant: Visitor
 */

public interface Visitor {
    
    void visit(Shooter e);
    void visit(Missile e);
}
