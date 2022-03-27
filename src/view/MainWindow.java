package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
    public static JTextField uStats;
    public static JTextField bStats;
    public static JTextField aStats;
     public static JTextField planetStatus;   
    public static JButton addBombButton;
    public static JButton addUfoButton;    
    public static JButton quitButton;
    public static JButton addAlienButton;

    
    public MainWindow() {
        Container c = getContentPane();
        c.add(Main.gamePanel, "Center");
        JPanel southPanel = new JPanel();
        addBombButton = new JButton("Add 10");
        southPanel.add(addBombButton);
        addUfoButton = new JButton("Add UFO");
        southPanel.add(addUfoButton);        
        addAlienButton = new JButton("Add Alien");
        southPanel.add(addAlienButton);                
        quitButton = new JButton("Quit");
        southPanel.add(quitButton);
        c.add(southPanel, "South");
        uStats = new JTextField("UFO’s: total = xxx, destroyed = xxx, alive = xxx");   
        uStats.setEditable(false);       
        bStats = new JTextField("Bomb's: total = xxx, destroyed = xxx, alive = xxx"); 
        bStats.setEditable(false); 
        aStats = new JTextField("Alien's: total = xxx, destroyed = xxx, alive = xxx"); 
        aStats.setEditable(false);    
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3, 1));
        northPanel.add(uStats);
        northPanel.add(bStats);
        northPanel.add(aStats);       
        c.add(northPanel, "North");
        ButtonListener buttonListener = new ButtonListener();
        addBombButton.addActionListener(buttonListener);
        addUfoButton.addActionListener(buttonListener);   
        addAlienButton.addActionListener(buttonListener);
        quitButton.addActionListener(buttonListener);
        MouseController mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        KeyController keyListener = new KeyController();
        Main.gamePanel.addKeyListener(keyListener);
        Main.gamePanel.setFocusable(true);
        northPanel.setFocusable(false);
        addUfoButton.setFocusable(false); 
        addBombButton.setFocusable(false);  
        addAlienButton.setFocusable(false);
        quitButton.setFocusable(false);
        uStats.setFocusable(false);         
        bStats.setFocusable(false);  
        aStats.setFocusable(false);
    }
}
