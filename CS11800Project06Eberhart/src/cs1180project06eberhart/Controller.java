/**
 * This class defines the keyboard input controls for the player.
 */

package cs1180project06eberhart;

import java.util.BitSet;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class Controller {
    
    private BitSet keyboard = new BitSet();
    
    protected Scene scene;
    
    protected KeyCode up = KeyCode.W;
    protected KeyCode down = KeyCode.S;
    protected KeyCode left = KeyCode.A;
    protected KeyCode right = KeyCode.D;
    protected KeyCode menu = KeyCode.Q;
    protected KeyCode quit = KeyCode.ESCAPE;
            
    //constructor for controller
    public Controller(Scene scene) {
        this.scene = scene;
    }

    /**
     * This method adds input listeners to the scene.
     * 
     * Pre-conditions:  Listeners need to be added.
     * Post-conditions: The scene has listeners.
     * 
     */
    public void addListener() {
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressed);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleased);
        
    }
    
    /**
     * This method removes input listeners from the scene.
     * 
     * Pre-conditions:  Listeners need to be removed.
     * Post-conditions: The scene no longer has listeners.
     * 
     */
    public void removeListener() {
        
        scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressed);
        scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleased);
        
    }
    
    /**
     * This is the event handler for key presses.
     * 
     * Pre-conditions:  A key has been pressed.
     * Post-conditions: The key input has been handled.
     * 
     */
    public EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {        
        @Override
        public void handle(KeyEvent e){
            keyboard.set(e.getCode().ordinal(), true);
        }
    };
    
    /**
     * This is the event handler for key releases.
     * 
     * Pre-conditions:  A key has been released.
     * Post-conditions: The key input has been handled.
     * 
     */
    public EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {        
        @Override
        public void handle(KeyEvent e){
            keyboard.set(e.getCode().ordinal(), false);
        }
    };
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean upPressed() {
        return (keyboard.get(up.ordinal()) && !keyboard.get(down.ordinal()));
    }
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean downPressed() {
        return (keyboard.get(down.ordinal()) && !keyboard.get(up.ordinal()));
    }
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean leftPressed() {
        return (keyboard.get(left.ordinal()) && !keyboard.get(right.ordinal()));
    }
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean rightPressed() {
        return (keyboard.get(right.ordinal()) && !keyboard.get(left.ordinal()));
    }
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean escPressed() {
        return keyboard.get(quit.ordinal());
    }
    
    /**
     * This method defines behavior for recognizing key input.
     * 
     * Pre-conditions:  A key has been pressed and needs to be processed.
     * Post-conditions: The key input has been registered.
     * 
     * @return boolean
     */
    public boolean menuPressed() {
        return keyboard.get(menu.ordinal());
    }
}
