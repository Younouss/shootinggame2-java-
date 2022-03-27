
package model;

import VisitorDesignPattern.Visitor;
import controller.Main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import view.GamePanel;

public class FlyingSaucer extends GameFigure{
    Rectangle2D.Double collisionBox = new Rectangle2D.Double();
    private  int width = 40;
    private  int height = 10;
    private final Color color = Color.yellow;
    private final int UNIT_TRAVEL = 5; // per frame
    private int direction = 1; // +1: to the right; -1 to the left

    public FlyingSaucer(float x, float y) {
        super(x, y);
        super.type = 1; 
      
    }
    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)(super.x - width/2), 
                (int)(super.y - height/2), 
                width, height);
    }

    @Override
    public void update() {
        if (direction > 0) {
            // moving to the right
            super.x += UNIT_TRAVEL;
            if (super.x + width/2 > GamePanel.width) {
                direction = -1;
            }
        } else {
            // moving to the left
            super.x -= UNIT_TRAVEL;
            if (super.x - width/2 <= 0) {
                direction = 1;
            }
        }
    }
    
    @Override
    public void deadBehavior(){
        int temp = width;
        width = height;
        height = temp;
        super.y += UNIT_TRAVEL;               
    } 
    @Override
    public Rectangle2D getCollisionBox() {
        collisionBox.setRect(super.x, super.y,  width * 0.9, height* 0.9);
        return collisionBox;
    }   

    @Override
    public void accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
