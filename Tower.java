/**
 * Tower.java by Sam Reznikov
 * January 19, 2019
 * Represents a tower in the game that the player may use to prevent oncoming enemies from reaching the castle
 */

//import necessary libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public abstract class Tower {
  private int cost; //tower cost
  private int[] uCosts; //tower upgrade costs
  private int frequency; //tower frequency
  private int freqCount = 0; //tower frequency count
  private int x; //tower x coordinate
  private int y; //tower y coordinate
  private int size; //tower size
  private int upgradeIdx = 0; //tower upgrade index
  private BufferedImage image; //tower image
  ArrayList<BufferedImage> allImages; //all tower images (all upgrade phases)
  
  /**
   * Tower()
   * This constructor initializes necessary values for a tower to be functional
   * @param The tower's cost
   * @param The tower's use frequency
   * @param The tower's X coordinate
   * @param The tower's Y coordinate
   * @param The tower's size
   * @param All tower images (all upgrade states)
   */
  public Tower(int cost, int frequency, int xPos, int yPos, int size, ArrayList<BufferedImage> images) { 
    //initialize instance variables
    this.cost = cost;
    uCosts = new int[] {(int)(cost*0.8), (int)(cost*0.9)};
    this.frequency = frequency;
    this.x = xPos;
    this.y = yPos;
    this.size = size;
    this.allImages = images;
    this.image = images.get(this.upgradeIdx);
  } //end of constructor
  
  /**
   * getCost()
   * Returns the tower's cost
   * @return Integer value of tower's price
   */
  public int getCost() {
    return this.cost; //return tower cost
  } //end of getCost()
  
  /**
   * getUCosts()
   * Returns all upgrade costs for the tower
   * @return Integer array of upgrade costs
   */
  public int[] getUCosts() {
    return this.uCosts; //return upgrade costs
  } //end of getUCosts()
  
  /**
   * getSize()
   * Returns the tower size
   * @return Tower size
   */
  public int getSize() {
    return this.size; //return size
  } //end of getSize()
  
  /**
   * getImage()
   * Returns the tower's current image
   * @return Tower's image
   */
  public BufferedImage getImage() {
    return this.image; //return image
  } //end of getImage()
  
  /**
   * setImage()
   * Sets tower's image to given image
   * @param New tower image
   */
  public void setImage(BufferedImage image) {
    this.image = image; //set image
  } //end of setImage()
  
  /**
   * getFreqCount()
   * Gets the tower's frequency count (used for delaying uses)
   * @return Integer value of frequency count
   */
  public int getFreqCount() {
    return this.freqCount; //return frequency count
  } //end of getFreqCount()
  
  /**
   * getFreq()
   * Returns the tower's overall frequency
   * @return Integer value of tower frequency
   */
  public int getFreq() {
    return this.frequency; //return frequency
  } //end of getFreq()
  
  /**
   * setFreqCount()
   * Sets the tower's frequency count to given value
   * @param New frequency count
   */
  public void setFreqCount(int newCount) {
    this.freqCount = newCount; //set frequency count
  } //end of setFreqCount()
  
  /**
   * getX()
   * Returns tower's X coordinate
   * @return Tower's X coordinate
   */
  public int getX() {
    return this.x; //return x coordinate
  } //end of getX()
  
  /**
   * getY()
   * Returns tower's Y coordinate
   * @return Tower's Y coordinate
   */
  public int getY() {
    return this.y; //return y coordinate
  } //end of getY()
  
  /**
   * getUpgradeIdx()
   * Returns the tower's upgrade index
   * @return Tower's upgrade index
   */
  public int getUpgradeIdx() {
    return this.upgradeIdx; //return upgrade index
  } //end of getUpgradeIdx()
  
  /**
   * setUpgradeIdx()
   * Sets the tower's upgrade index to the given value
   * @param New upgrade index            
   */
  public void setUpgradeIdx(int idx) {
    this.upgradeIdx = idx; //set upgrade index
  } //end of setUpgradeIdx()
  
  /**
   * use()
   * Activates and uses the tower's ability
   * @param All enemies in game
   * @param The player
   */
  public abstract void use(ArrayList<Enemy> e, Player player); 
  
  /**
   * upgrade()
   * Upgrades tower image and stats
   */
  public abstract void upgrade();
} //end of Tower
