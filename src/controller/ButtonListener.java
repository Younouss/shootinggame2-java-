package controller;

import ObserverDesignPattern.UfoObserver;
import ObserverDesignPattern.GameScore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ObserverDesignPattern.BombObserver;
import view.MainWindow;

public class ButtonListener implements ActionListener {
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == MainWindow.addBombButton) {
            Main.gameData.addBomb(10);        
            Main.gameData.bTotal += 10;
            Main.gameData.bAlive += 10;
            Main.gameData.displayBombScore();
        }
        if (ae.getSource() == MainWindow.addUfoButton) {
            Main.gameData.addUfo(1);  
            Main.gameData.uTotal+=1;
            Main.gameData.uAlive += 1;   
            Main.gameData.displayUfoScore();
        }
        if (ae.getSource() == MainWindow.addAlienButton) {
            Main.gameData.addAlien(1);  
            Main.gameData.aTotal+=1;
            Main.gameData.aAlive += 1;              
            Main.gameData.displayAlienScore();
        } 
        else if (ae.getSource() == MainWindow.quitButton) {
            if (Main.animator.running) {
                Main.animator.running = false;
            } else {
                System.exit(0);
            }
        }
    }

}
