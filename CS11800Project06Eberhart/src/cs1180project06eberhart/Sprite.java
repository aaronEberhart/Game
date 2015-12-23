/**
 * This abstract class defines basic sprite methods.
 */

package cs1180project06eberhart;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public abstract class Sprite {
    
    protected Image image;
    protected ImageView imageView;
    protected Pane layer;
    protected double positionX;
    protected double positionY;
    protected double velocityX;
    protected double velocityY;
    protected double height;
    protected double width;
    
    //sprite no-arg constuctor
    public Sprite() {
        
    }
    
    //sprite construcor
    public Sprite(Pane layer, Image image, double positionX, double positionY, double velocityX, double velocityY) {
        
        this.layer = layer;
        this.image = image;
        this.imageView = new ImageView(image);
        this.imageView.relocate(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.height = image.getHeight();
        this.width = image.getWidth();
        
        add();
    }
    
    /**
     * This method moves the sprite's position based on its velocity.
     * 
     * Pre-conditions:  The sprite needs to use its velocity to update position.
     * Post-conditions: The position has been updated.
     * 
     */
    public void move() {
        positionX += velocityX;
        positionY += velocityY;
    }
    
    /**
     * This method adds the sprite to the pane.
     * 
     * Pre-conditions:  The sprite needs to be added to the pane.
     * Post-conditions: The sprite is on the pane.
     * 
     */
    public final void add() {
        this.layer.getChildren().add(this.imageView);
    }
    
    /**
     * This method moves the sprite image to it's current x,y coordinates.
     * 
     * Pre-conditions:  The sprite image has moved and needs to be updated.
     * Post-conditions: The sprite has been relocated.
     * 
     */
    public void redraw() {
        this.imageView.relocate(positionX, positionY);
    }
    
    /**
     * This method checks to see if the sprite image bounds have intersected
     * the other sprite passed as a parameter.
     * 
     * Pre-conditions:  The program needs to test to see if two sprites have collided.
     * Post-conditions: The test has been performed.
     * 
     * @param sprite Sprite
     * @return boolean
     */
    public boolean testCollisiion(Sprite sprite) {
        return (sprite.positionX + sprite.width >= this.positionX 
                && sprite.positionY + sprite.height >= this.positionY
                && this.positionX + this.width >= sprite.positionX 
                && this.positionY + this.height >= sprite.positionY);
    }

    
}
