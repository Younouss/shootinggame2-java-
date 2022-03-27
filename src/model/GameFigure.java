package model;

import StateDesignPattern.State;
import StateDesignPattern.StateAlive;
import VisitorDesignPattern.Visitor;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import VisitorDesignPattern.GameElement;

public abstract class GameFigure implements CollisionBox, GameElement {

    // public for a faster access during animation
    public float x;
    public float y;
    public int state;
    public static final int STATE_ALIVE = 1;
    public static final int STATE_DYING = 2;
    public static final int STATE_DONE = 0;
    private State contextState = new StateAlive(this);  
    public int type;
    public GameFigure(float x, float y) {
        this.x = x;
        this.y = y;
    }
    // how to render on the canvas
    public abstract void render(Graphics2D g);

    // changes per frame
    public abstract void update();
    
    public abstract void deadBehavior();
    
    public void setState(State state) {
        this.contextState = state;
    }
    public void pull() {    
        contextState.goNext(this);
    }	
}
