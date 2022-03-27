package StateDesignPattern;

import model.GameFigure;
import static model.GameFigure.STATE_DONE;

public class StateDone implements State {
    public StateDone(GameFigure context) {
       context.state = STATE_DONE;
    }
    @Override
    public void goNext(GameFigure context) {
        context.setState(new StateAlive(context));
    }
    
}
