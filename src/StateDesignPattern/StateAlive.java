package StateDesignPattern;

import model.GameFigure;
import static model.GameFigure.STATE_ALIVE;

public class StateAlive implements State {

    public StateAlive(GameFigure context) {
        context.state = STATE_ALIVE;
    } 
    @Override
    public void goNext(GameFigure context) {
        context.setState(new StateDone(context));        
    }
    
}
