/**
 * CoinTower.java by Sam Reznikov
 * January 19, 2019
 * Represents and acts as a coin tower (a child of a tower)
 */

//import necessary libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CoinTower extends Tower {
  private double amount; //amount of coins to earn per use
  private int spriteIdx = 0; //sprite index
  private int spriteCount = 0; //sprite counter
  
  /**
   * CoinTower()
   * This constructor initializes all necessary values for a coin tower to be functional
   * @param Tower cost
   * @param Tower frequency
   * @param X coordinate of position
   * @param Y coordinate of position
   * @param Tower size
   * @param Tower images (all upgrade states)
   * @param Amount of gold earned per use
   */
  public CoinTower (int cost, int frequency, int xPos, int yPos, int size, ArrayList<BufferedImage> images, double amount) { 
    super(cost, frequency, xPos, yPos, size,  images); //call parent constructor
    this.amount = amount; //initialize amount
  }  //end of constructor
  
  /**
   * use()
   * Gives the player an appropriate amount of gold
   * @param Current enemies in game
   * @param The player
   */
  @Override
  public void use(ArrayList<Enemy> enemies, Player p) {
    p.setMoney((int)(p.getMoney() + this.amount));  //give the player money
  } //end of use()
  
  /**
   * upgrade()
   * Upgrades the tower image and stats
   */
  @Override
  public void upgrade() {
    this.setUpgradeIdx(this.getUpgradeIdx() +1); //update upgrade index
    this.setImage(this.allImages.get(this.getUpgradeIdx())); //update tower image
    this.amount *= 1.4; //increase amount earned per use
  } //end of upgrade()
  
  /**
   * setSpriteCount()
   * Sets sprite count to a given value
   * @param New sprite count
   */
  public void setSpriteCount(int amount) {
    this.spriteCount = amount; //set sprite count to amount
  } //end of setSpriteCount()
  
  /**
   * getSpriteCount()
   * Returns current sprite count
   * @return Integer value of current sprite count
   */
  public int getSpriteCount() {
    return this.spriteCount; //return sprite count
  } //end of getSpriteCount()
  
  /**
   * getSpriteIdx()
   * Returns current sprite index
   * @return Integer value of current sprite index
   */
  public int getSpriteIdx() {
    return this.spriteIdx; //return sprite index
  } //end of getSpriteIdx()
  
  /**
   * updateSpriteIdx()
   * Updates sprite index for the coin animation to work
   */
  public void updateSpriteIdx() {
    this.spriteIdx++; //increment sprite index
    if(this.spriteIdx >= 6) { //if out of bounds
      this.spriteIdx = 0; //reset sprite index
    } //end of reset sprite index check
  } //end of updateSpriteIdx()
} //end of CoinTower
