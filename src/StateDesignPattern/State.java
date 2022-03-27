package StateDesignPattern;

import model.GameFigure;


public interface State {
	void goNext(GameFigure context);    
}
