/**
 * Projectile.java by Sam Reznikov
 * January 19, 2019
 * Represents and acts as a projectile fired by a gun tower towards a nearby enemy
 */

//import necessary libraries
import java.awt.image.BufferedImage;

public class Projectile {
  private double x; //x coordinate
  private double y; //y coordinate
  private double xVel = 0; //x velocity
  private double yVel = 0; //y velocity
  private double xDest; //x destination coordinate
  private double yDest; //y destination coordinate
  private int speed; //speed of projectile
  private double angle; //angle of projectile
  private BufferedImage image; //projectile image
  
  /**
   * Projectile()
   * This constructor initializes all necessary values for a projectile to be functional
   * @param Projectile's X coordinate
   * @param Projectile's Y coordinate
   * @param Projectile's destination X coordinate
   * @param Projectile's destination Y coordinate
   * @param Projectile's speed
   * @param Projectile's image
   * @param Window Height (used to find target)
   */
  public Projectile(double xPos, double yPos, double xDest, double yDest, int speed, BufferedImage image, int windowHeight) { 
    //initialize instance variables
    this.x = xPos;
    this.y = yPos;
    this.xDest = xDest;
    this.yDest = yDest;
    this.speed = speed;
    this.image = image;
    this.setAngle(windowHeight);
    this.calcVel();
  } //end of constructor
  
  /**
   * getImage()
   * Returns the projectile's image
   * @return The projectile's image
   */
  public BufferedImage getImage() {
    return this.image; //return projectile's image
  } //end of getImage()
  
  /**
   * setAngle()
   * Sets angle of launch by using window height and target coordinates
   * @param The game window height
   */
  public void setAngle(int windowHeight) {
    //calculate angle based on position and destination
    double targetY = windowHeight - this.yDest;
    double currY = windowHeight - this.y;
    this.angle = -1 * Math.atan2(targetY - currY, this.xDest - this.x);
  } //end of setAngle()
  
  /**
   * getAngle()
   * Returns angle of launch
   * @return Double value representing angle of launch
   */
  public double getAngle() { 
    return this.angle; //return angle
  } //end of getAngle()
  
  /**
   * calcVel()
   * Calculates the projectile X and Y velocities
   */
  public void calcVel() {
    //calculate the x and y velocity according to speed and angle
    this.yVel = Math.sin(this.angle)*speed;
    this.xVel = Math.cos(this.angle)*speed;
  } //end of calcVel()
  
  /**
   * update()
   * Updates projectile's position by using its velocities
   */
  public void update() {
    //update x and y coordinates using the corresponding velocities
    this.x += this.xVel;
    this.y += this.yVel;
  } //end of update()
  
  /**
   * getXDest()
   * Returns X destination coordinate
   * @return X destination coordinate
   */
  public double getXDest() {
    return this.xDest; //return x destination coordinate
  } //end of getXDest()
  
  /**
   * getYDest()
   * Returns Y destination coordinate
   * @return Y destination coordinate
   */
  public double getYDest() {
    return this.yDest; //return y destination coordinate
  } //end of getYDest()
  
  /**
   * getX()
   * Returns projectile's X coordinate
   * @return Projectile's X coordinate
   */
  public double getX() {
    return this.x; //return x coordinate
  } //end of getX()
  
  /**
   * getY()
   * Returns projectile's Y coordinate
   * @return Projectile's Y coordinate
   */
  public double getY() {
    return this.y; //return y coordinate
  } //end of getY()
} //end of Projectile class
