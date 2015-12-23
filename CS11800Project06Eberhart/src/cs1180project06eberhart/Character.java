/**
 * This class defines Character behavior. Characters are sprites.
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
public class Character extends Sprite {
        
    protected Controller input;
    protected Image left;
    protected Image right;
    
    protected double health;
    protected double maxPositionX;
    protected double maxPositionY;
    protected double minPositionX;
    protected double minPositionY;
    protected double maxVelocityX;
    protected double maxVelocityY;
    protected double minVelocityX;
    protected double minVelocityY;
    
    //new character constructor
    public Character(Pane layer, Image image, Image left, Image right, double positionX, 
            double positionY, double velocityX, double velocityY, Controller input, double health) {
        
        this.layer = layer;
        this.image = image;
        this.positionX = positionX;
        this.positionY = positionY;
        this.imageView = new ImageView(image);
        this.imageView.relocate(positionX, positionY);
        
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.height = image.getHeight();
        this.width = image.getWidth();
        
        this.health = health;
        this.left = left;
        this.right = right;
        this.input = input;
        this.maxPositionX = layer.getScene().getWidth() - image.getWidth();
        this.maxPositionY = layer.getScene().getHeight() - image.getHeight();
        this.minPositionY = 0;
        this.minPositionX = 0;
        this.minVelocityX = -((layer.getScene().getWidth() / image.getWidth()) / 15);
        this.minVelocityY = -((layer.getScene().getHeight() / image.getHeight()) / 15);
        this.maxVelocityX = (layer.getScene().getWidth() / image.getWidth()) / 15;
        this.maxVelocityY = (layer.getScene().getHeight() / image.getHeight()) / 15;
        
        add();
    }
    
    //character constructor for loading saves
    public Character(Pane layer, Image image, Image left, Image right, double positionX, double positionY, double velocityX, double velocityY, Controller input) {
        
        super(layer, image, positionX, positionY, velocityX, velocityY);
        
        this.health = 10;
        this.left = left;
        this.right = right;
        this.input = input;
        this.maxPositionX = layer.getScene().getWidth() - image.getWidth();
        this.maxPositionY = layer.getScene().getHeight() - image.getHeight();
        this.minPositionY = 0;
        this.minPositionX = 0;
        this.minVelocityX = -((layer.getScene().getWidth() / image.getWidth()) / 15);
        this.minVelocityY = -((layer.getScene().getHeight() / image.getHeight()) / 15);
        this.maxVelocityX = (layer.getScene().getWidth() / image.getWidth()) / 15;
        this.maxVelocityY = (layer.getScene().getHeight() / image.getHeight()) / 15;
    }    

    /**
     * This method processes input for the character object and updates velocity.
     * 
     * Pre-conditions:  Input for a character needs to be checked.
     * Post-conditions: The input has been processed.
     * 
     */
    public void processInput() {       
        
        if(input.upPressed())        
        {
            this.velocityY -= .005;
        }
        else if(input.downPressed())
        {
            this.velocityY += .005;
        }
        else
            this.velocityY = 0;
        
        if(input.rightPressed())        
        {
            imageView.setImage(right);
            this.velocityX += .005;
        }
        else if(input.leftPressed())
        {
            imageView.setImage(left);
            this.velocityX -= .005;
        }
        else
        {
            imageView.setImage(image);
            this.velocityX = 0;
        }
        
    }

    /**
     * This is the move method for a character. It checks the bounds after moving.
     * 
     * Pre-conditions:  The character coordinates need to be moved.
     * Post-conditions: The character has moved.
     * 
     */
    @Override
    public void move() {
        
        super.move();
        
        checkBoundary();
    }
    
    /**
     * This method makes sure the character doesn't leave the screen.
     * 
     * Pre-conditions:  The character has moved and its position needs to be tested.
     * Post-conditions: The character has legal coordinates.
     * 
     */
    public void checkBoundary() {
        
        if(Double.compare(positionY, minPositionY) < 0)
            positionY = minPositionY;
        else if(Double.compare(positionY, maxPositionY) > 0)
            positionY = maxPositionY;
        
        if(Double.compare(positionX, minPositionX) < 0)
            positionX = minPositionX;
        else if(Double.compare(positionX, maxPositionX) > 0)
            positionX = maxPositionX;
        
        if(Double.compare(velocityX, minVelocityX) < 0)
            velocityX = minVelocityX;
        else if(Double.compare(velocityX, maxVelocityX) > 0)
            velocityX = maxVelocityX;
        
        if(Double.compare(velocityY, minVelocityY) < 0)
            velocityY = minVelocityY;
        else if(Double.compare(velocityY, maxVelocityY) > 0)
            velocityY = maxVelocityY;
    }
    
}
