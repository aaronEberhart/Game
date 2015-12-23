/**
 * This class defines a save object.
 */

package cs1180project06eberhart;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class Save {
    
    protected double health;
    protected double positionX;
    protected double positionY;
    protected double velocityX;
    protected double velocityY;
    protected boolean hasSaved;
    
    //save no-arg constructor
    public Save() {
        this.hasSaved = false;
    }
    
    //save constuctor
    public Save(Character guy) {
        
        this.health = guy.health;
        this.positionX = guy.positionX;
        this.positionY = guy.positionY;
        this.velocityX = guy.velocityX;
        this.velocityY = guy.velocityY;
        
        this.hasSaved = true;        
                
    }
    

}
