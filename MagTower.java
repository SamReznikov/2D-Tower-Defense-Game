/**
 * MagTower.java by Sam Reznikov
 * January 19, 2019
 * Represents and acts as a magic tower (a child of a tower)
 */

//Import necessary libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MagTower extends Tower {
  private double radius; //magic tower radius
  private double damage; //magic tower damage
  private ArrayList<Enemy> nearbyEnemies = new ArrayList<Enemy>(); //nearby enemies
  
  /**
   * MagTower
   * This constructor initializes all necessary values for a coin tower to be functional
   * @param Tower cost
   * @param Tower frequency
   * @param X coordinate of position
   * @param Y coordinate of position
   * @param Tower size
   * @param Tower images (all upgrade states)
   * @param Radius of fire effect
   * @param Damage taken by enemies per hit
   */
  public MagTower(int cost, int frequency, int xPos, int yPos, int size, 
                  ArrayList<BufferedImage> images, double radius, int damage) { 
    super(cost, frequency, xPos, yPos, size, images); //call parent constructor
    this.radius = radius; //initialize radius variable
    this.damage = damage; //initialize damage variable
  } //end of constructor()
  
  /**
   * getRadius()
   * Returns the magic tower's radius of effect
   * @return Double value of magic tower's radius
   */
  public double getRadius() {
    return this.radius; //return radius
  } //end of getRadius()
  
  /**
   * clearNearbyEnemies()
   * Removes all nearby enemies
   */
  public void clearNearbyEnemies() {
    for (Enemy enemy : this.nearbyEnemies) {
      if (enemy.getNearbyMagTowers().contains(this)) {
          enemy.removeMagTower(this); //remove tower from enemy's nearby enemies
        } //end of nearby enemy check
    } //end of loop through nearby enemies
  } //end of clearNearbyEnemies()
  
  /**
   * use()
   * Damage enemies within the tower's radius
   * @param All enemies in game
   * @param The player
   */
  public void use(ArrayList<Enemy> enemies, Player p) {
    for (Enemy enemy : enemies) { //loop through all enemies
      double enemyX = enemy.getX() + this.getSize()/2; //get enemy x coordinate
      double enemyY = enemy.getY() + this.getSize()/2; //get enemy y coordinate
      //calculate distance from tower to enemy
      double distance = Math.hypot((this.getX() + this.getSize()/2) - enemyX, (this.getY() + this.getSize()/2) -enemyY);
      
      if (distance <= this.radius) { //if enemy is within radius
        enemy.setHealth(enemy.getHealth() - this.damage); //decrease enemy health
        if (!enemy.getNearbyMagTowers().contains(this)) { //if enemy just entered radius
          //add enemy to nearby enemies, add tower to enemy's nearby mag towers
          enemy.addMagTower(this); 
          this.nearbyEnemies.add(enemy);
        } //end of recent enemy enter check
      } //end of within radius check
      else { //otherwise enemy is not in radius
        if (enemy.getNearbyMagTowers().contains(this)) { //if enemy just left radius
          enemy.removeMagTower(this); //remove tower from enemy's nearby towers
          this.nearbyEnemies.remove(enemy); //remove enemy from nearby enemies
        } //end of recent radius leave check
      } //end of out of bounds check
    } //end of loop through enemies
  } //end of use()
  
  /**
   * upgrade()
   * Upgrades the tower image and stats
   */
  public void upgrade() {
    this.setUpgradeIdx(this.getUpgradeIdx() +1); //increment upgrade index
    this.setImage(this.allImages.get(this.getUpgradeIdx())); //update tower image
    this.radius *= 1.2; //increase radius of tower
  } //end of upgrade()
} //end of MagTower
