/**
 * This class defines behavior for rock sprites.
 */

package cs1180project06eberhart;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class Rock extends Sprite {
    
    protected double maxPositionX;
    protected double maxPositionY;
    protected double minPositionX;
    protected double minPositionY;
    
    //rock constructor
    public Rock(Pane layer, Image image, double positionX, double positionY, double velocityX, double velocityY) {
        
        super(layer, image, positionX, positionY, velocityX, velocityY);
        
        this.maxPositionX = layer.getScene().getWidth();
        this.maxPositionY = layer.getScene().getHeight();
        this.minPositionY = -image.getHeight();
        this.minPositionX = -image.getWidth();
    }
    
    /**
     * This is the move method for a rock. It checks the bounds after moving.
     * 
     * Pre-conditions:  The rock coordinates need to be moved.
     * Post-conditions: The rock has moved.
     * 
     */
    @Override
    public void move() {
        
        super.move();
        
        checkBoundary();
    }
    
    /**
     * This method makes sure the rock doesn't move too far off the screen.
     * 
     * Pre-conditions:  The rock has moved and its position needs to be tested.
     * Post-conditions: The rock has legal coordinates.
     * 
     */
    public void checkBoundary() {
        
        if(Double.compare(positionY, minPositionY) < 0)
            this.positionY = maxPositionY;
        else if(Double.compare(positionY, maxPositionY) > 0)
            this.positionY = minPositionY;
        
        if(Double.compare(positionX, minPositionX) < 0)
            this.positionX = maxPositionX;
        else if(Double.compare(positionX, maxPositionX) > 0)
            this.positionX = minPositionX;
    }
    
}
