/**
 * GunTower.java by Sam Reznikov
 * January 19, 2019
 * Represents and acts as a gun tower (a child of a tower)
 */

//Import necessary libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GunTower extends Tower {
  private double range; //range of gun tower
  private BufferedImage projectileImage; //image for projectile
  private Projectile projectile = null; //current projectile
  private int windowHeight; //game window height (to pass to projectile)
  private double damage; //damage of gun tower
  
  /**
   * GunTower
   * This constructor initializes all necessary values for a coin tower to be functional
   * @param Tower cost
   * @param Tower frequency
   * @param X coordinate of position
   * @param Y coordinate of position
   * @param Tower size
   * @param Tower images (all upgrade states)
   * @param Image used for projectile
   * @param Range of fire
   * @param Damage given to enemies per shot
   * @param Game Window Height (to pass to projectile)
   */
  public GunTower(int cost, int frequency, int xPos, int yPos, int size, ArrayList<BufferedImage> towerImages, 
                  BufferedImage projectileImage, double range, int damage, int windowHeight) { 
    super(cost, frequency, xPos, yPos, size, towerImages); //call parent constructor
    //initialize instance variables
    this.range = range;
    this.projectileImage = projectileImage;
    this.windowHeight = windowHeight;
    this.damage = damage;
  } //end of constructor
  
  /**
   * getDamage()
   * Returns the amount of damage that the tower inflicts per hit
   * @return Double value representing tower's damage
   */
  public double getDamage() {
    return this.damage; //return current damage
  } //end of getDamage()
  
  /**
   * use()
   * Looks for nearby enemies and fires a projectile at one in range
   * @param Current enemies in game
   * @param The player
   */
  @Override
  public void use(ArrayList<Enemy> enemies, Player p) {
    for (int i = enemies.size()-1; i >= 0; i--) { //loop through enemies backwards
      Enemy enemy = enemies.get(i); //get current enemy
      double enemyX = enemy.getX() + this.getSize()/2; //get x position of enemy image centre
      double enemyY = enemy.getY() + this.getSize()/2; //get y position of enemy image centre
      //calculate distance between tower and enemy
      double distance = Math.hypot(this.getX() + this.getSize()/2 -enemyX, this.getY() + this.getSize()/2 - enemyY); 
      
      if (distance <= range) { //if enemy is within range
        //create new projectile to fire at the enemy
        this.projectile = new Projectile(this.getX() + this.getSize()/2, this.getY() + this.getSize()/2, enemyX, enemyY, 
                                         10, projectileImage, windowHeight);
      } //end of in range check
    } //end of backwards loop through enemies
  } //end of use()
  
 /*
   * upgrade()
   * Upgrades the tower image and stats
   */
  @Override
  public void upgrade() {
    this.setUpgradeIdx(this.getUpgradeIdx() +1); //increment update index
    this.setImage(this.allImages.get(this.getUpgradeIdx())); //update tower image
    this.damage *= 1.4; //improve tower's damage
  } //end of upgrade()
  
  /**
   * getProjectile()
   * Returns the gun tower's current projectile
   * @return Tower's projectile, null if non-existent
   */
  public Projectile getProjectile() {
    return this.projectile; //return current projectile
  } //end of getProjectile()
  
  /**
   * resetProjectile()
   * Resets the tower's projectile (by setting it to null)
   */
  public void resetProjectile() {
    this.projectile = null; //reset projectile to null
  } //end of resetProjectile()
} //end of GunTower
