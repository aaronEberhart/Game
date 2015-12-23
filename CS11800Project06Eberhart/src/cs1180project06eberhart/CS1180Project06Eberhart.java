/**
 * This is the main method and start method for the game. It is minimal, passing the 
 * primary stage to other classes to perform animation and menu tasks.
 */
package cs1180project06eberhart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class CS1180Project06Eberhart extends Application { 
    
    
    /**
     * This is the start method for the game. It creates an object 
     * of the menu class and passes the stage to it.
     * 
     * Pre-conditions:  The program is starting.
     * Post-conditions: The program has begun.
     * 
     * @param primaryStage Stage
     */
    @Override
    public void start(Stage primaryStage) {
               
        StartMenuEtc start = new StartMenuEtc();
        Scene scene = start.startScene(primaryStage);
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
