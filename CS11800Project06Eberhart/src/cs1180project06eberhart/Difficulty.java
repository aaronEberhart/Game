/**
 * This class defines the difficulty object.
 */

package cs1180project06eberhart;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class Difficulty {
    
    private int difficulty;
    
    //difficulty constructor
    public Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Accessor for difficulty.
     * 
     * Pre-conditions:  The program needs the difficulty.
     * Post-conditions: The difficulty is returned.
     * 
     * @return difficulty int
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Mutator for difficulty.
     * 
     * Pre-conditions:  The program needs to change the difficulty.
     * Post-conditions: The difficulty is changed.
     * 
     * @param difficulty integer
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

}
