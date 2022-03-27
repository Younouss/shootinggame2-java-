package ObserverDesignPattern;

import controller.Main;
import view.MainWindow;

public class SubjectEvent {
    private Subject subject; 
    public SubjectEvent(Subject subject, String gameFigure) {
        if(gameFigure == "UFO"){
            MainWindow.uStats.setText("UFO’s: total ="+Main.gameData.uTotal+", destroyed = "+Main.gameData.uDestroyed+", alive = "+Main.gameData.uAlive);       
        }
        if(gameFigure == "Bomb"){   
            MainWindow.bStats.setText("Bomb’s: total ="+Main.gameData.bTotal+", destroyed = "+Main.gameData.bDestroyed+", alive = "+Main.gameData.bAlive);                     
        }    
        if(gameFigure == "Alien"){
            MainWindow.aStats.setText("Alien’s: total ="+Main.gameData.aTotal+", destroyed = "+Main.gameData.aDestroyed+", alive = "+Main.gameData.aAlive);                      
        }   
       if(gameFigure == "Planet"){    
            MainWindow.planetStatus.setText("Planet status: Destroyed");        
       }    
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }    
}
