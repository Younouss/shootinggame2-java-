package VisitorDesignPattern;

import controller.Animator;
import model.Alien;
import model.Bomb;
import model.FlyingSaucer;
import model.Missile;
import model.Shooter;

/*
 * ConcreteVisitor
 */
public class AfterCollisionVisitor implements Visitor {

    @Override
    public void visit(Shooter e) {
        Animator.processCollisions();
    }

    @Override
    public void visit(Missile e) {
        Animator.processCollisions();
    }

}
