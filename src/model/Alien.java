
package model;
import VisitorDesignPattern.Visitor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import view.GamePanel;

public class Alien extends GameFigure {
    Rectangle2D.Double collisionBox = new Rectangle2D.Double();
    private  int width = 20;
    private  int height = 20;
    private final Color color = Color.green;
    public Alien(float x, float y) {
        super(x, y);
        super.state = STATE_ALIVE;    
        this.type = 3;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect((int)(super.x - width/2), 
                (int)(super.y - height/2), 
                width, height);
    }
    int cloneWidth = width;
    @Override
    public void update() {
        if(width > 0){
            width = 0;
            return;
        }
        if(width == 0){
            width = cloneWidth;
            return;
        }                       
    }

    @Override
    public Rectangle2D getCollisionBox() {
        collisionBox.setRect(super.x, super.y,  width, height);
        return collisionBox;
    }

    @Override
    public void deadBehavior() {
        width -= 1;
        height -= 1;       
    }

    @Override
    public void accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
