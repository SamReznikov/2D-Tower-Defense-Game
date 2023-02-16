/**
 * Enemy.java by Sam Reznikov
 * January 19, 2019
 * Represents and acts like an enemy who's goal is to reach the castle at the right of the screen no matter the cost
 */

//Import necessary libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
  private ArrayList<ArrayList<BufferedImage>> allImages; //list of 4 lists (1 for each direction) of enemy movement sprites
  private BufferedImage currImage; //current enemy image
  private boolean fireState = false; //current fire state
  private ArrayList<MagTower> nearbyMagTowers = new ArrayList<MagTower>(); //nearby magic towers
  private double health; //current health
  private double defHealth; //default health
  private double speed; //current speed
  private double x; //x coordinate of enemy
  private double y; //y coordinate of enemy
  private int row; //current row in tilemap
  private int col; //current column in tilemap 
  private int dir; //Direction:  1 - right, -1 - left, -2 - down, 2 - up
  private int dirIdx = 3; //use for spritesheet row
  private int spriteIdx = 0; //use for spritesheet column
  private int fireIdx = 0; //used for fire sprite
  private int fireCount = 0; //used for updating fire sprite  
  private int moveCount = 0; //use for checking if centered with tiles
  private int spriteCount = 0; //use for updating sprites depending on speed
  
  /**
   * Enemy()
   * This constructor initializes all necessary values of an enemy to be functional
   * @param Enemy's health
   * @param Enemy's speed
   * @param Enemy's direction
   * @param Enemy's X coordinate
   * @param Enemy's Y coordinate 
   * @param Enemy's row on tilemap
   * @param Enemy's column on tilemap
   * @param All images of the enemy (all sprites, organized into 4 lists, on for each direction)
   */
  public Enemy(double health, double speed, int direction, int xPos, int yPos, int row, int col, 
               ArrayList<ArrayList<BufferedImage>> allImages) { 
    //set instance variables to corresponding values
    this.health = health;
    this.defHealth = health;
    this.speed = speed;
    this.dir = direction;
    this.x = xPos;
    this.y = yPos;
    this.row = row;
    this.col = col;
    this.allImages = allImages;
    currImage = allImages.get(this.dirIdx).get(0);
  } //end of constructor
  
  /**
   * removeMagTower()
   * Removes given magic tower from list of nearby magic towers
   * @param Tower to remove
   */
  public void removeMagTower(MagTower tower) {
    this.nearbyMagTowers.remove(tower); //remove the given tower from nearby magic towers
  } //end of removeMagTower()
  
  /**
   * addMagTower()
   * Adds given magic tower to list of nearby magic towers
   * @param Tower to add
   */
  public void addMagTower(MagTower tower) {
    this.nearbyMagTowers.add(tower); //add given tower to nearby magic towers
  } //end of addMagTower()
  
  /**
   * getNearbyMagTowers()
   * Returns nearby magic towers
   * @return ArrayList of nearby magic towers
   */
  public ArrayList<MagTower> getNearbyMagTowers() {
    return this.nearbyMagTowers; //return nearby magic towers
  } //end of getNearbyMagTowers()
  
  /**
   * getFireIdx()
   * Returns the fire sprite index
   * @return Integer value of fire sprite index
   */
  public int getFireIdx() {
    return this.fireIdx; //return fire sprite index
  } //end of getFireIdx()
  
  /**
   * updateFireIdx()
   * Updates fire sprite index for animation to work
   */
  public void updateFireIdx() {
    this.fireIdx++; //increment fire sprite index
    if (this.fireIdx >= 32) { //if out of bounds
      this.fireIdx = 0; //reset fire sprite index
    } //end of out of bounds check
  } //end of updateFireIdx()
  
  /**
   * getFireCount()
   * Returns fire count used for updating fire sprite
   * @return Integer value of fire count
   */
  public int getFireCount() {
    return this.fireCount; //return fire sprite count
  } //end of getFireCount()
  
  /**
   * setFireCount()
   * Sets fire count to given value
   * @param New fire count
   */
  public void setFireCount(int count) {
    this.fireCount = count; //set fire sprite count
  } //end of setFireCount()
  
  /**
   * isOnFire()
   * Returns whether the enemy is on fire or not
   * @return Boolean, true if enemy is set aflame, false otherwise.
   */
  public boolean isOnFire() {
    return this.fireState; //return enemy fire state
  } //end of isOnFire()
  
  /**
   * setFireState()
   * Sets enemy's fire state to given boolean value
   * @param New fire state (on fire or not)
   */
  public void setFireState(boolean state) {
    this.fireState = state; //set enemy fire state
  } //end of setFireState()
  
  /**
   * getDefHealth()
   * Returns the enemy's default health
   * @return The enemy's default health
   */
  public double getDefHealth() {
    return this.defHealth; //return default enemy health
  } //end of getDefHealth()
  
  /**
   * updateSpriteIdx()
   * Updates enemy's sprite index for walking animation to work
   */
  public void updateSpriteIdx() {
    if (spriteIdx == this.allImages.get(0).size()-1) { //if out of bounds
      spriteIdx = -1; //reset sprite index
    } //end of out of bounds check
    spriteIdx ++; //increment sprite index
  } //end of updateSpriteIdx
  
  /**
   * move()
   * Update enemy position by using its speed and direction
   */
  public void move() {
    this.currImage = this.allImages.get(this.dirIdx).get(this.spriteIdx); //update current image
    //check for direction and update position accordingly
    if (this.dir == -1) {
      this.x -= speed;
    } //end of left check
    else if (this.dir == 1) {
      this.x += speed;
    } //end of right check   
    else if (this.dir == -2) {
      this.y += speed;
    } //end of down check  
    else {
      this.y -= speed;
    } //end of up check
  } //end of move()
  
  /**
   * getCurrImage()
   * Returns enemy's current image
   * @return The enemy's current image
   */
  public BufferedImage getCurrImage() {
    return this.currImage; //return current image
  } //end of getCurrImage()
  
  /**
   * setDirection()
   * Sets direction to given value
   * @param Integer value of new direction
   */
  public void setDirection(int direction) {
    if (direction == 1) { //if right
      this.dirIdx = 3; //set direction index to right
    } //end of right check
    else if (direction == -1) { //if left
      this.dirIdx = 1; //set direction index to left
    } //end of left check
    else if (direction == 2) { //if up
      this.dirIdx = 0; //set direction index to up
    } //end of up check
    else { //if down
      this.dirIdx = 2; //set direction index to down
    } //end of down check
    this.dir = direction; //update direction
  } //end of setDirection()
  
  /**
   * getDirection()
   * Returns the enemy's current direction
   * @return Integer value representing the enemy's current direction
   */
  public int getDirection() {
    return this.dir; //return direction
  } //end of getDirection()
  
  /**
   * getX()
   * Returns the enemy's X coordinate
   * @return Enemy's X coordinate
   */
  public double getX() {
    return this.x; //return x position
  } //end of getX()
  
  /**
   * getY()
   * Returns the enemy's Y coordinate
   * @return Enemy's Y coordinate
   */
  public double getY() {
    return this.y; //return y position
  } //end of getY()
  
  /**
   * getRow()
   * Returns enemy's row in tilemap
   * @return Integer value of enemy's tilemap row
   */
  public int getRow() {
    return this.row; //return current row in tilemap
  } //end of getRow()
  
  /**
   * getCol()
   * Returns enemy's column in tilemap
   * @return Integer value of enemy's tilemap column
   */
  public int getCol() {
    return this.col; //return current column in tilemap
  } //end of getCol()
  
  /**
   * setRow()
   * Sets the enemy's tilemap row to given value
   * @param Enemy's new tilemap row
   */
  public void setRow(int row) {
    this.row = row; //set current row in tilemap
  } //end of setRow()
  
  /**
   * setCol()
   * Sets the enemy's tilemap column to given value
   * @param Enemy's new tilemap column
   */
  public void setCol(int col) {
    this.col = col; //set current column in tilemap
  } //end of setCol()
  
  /**
   * getSpeed()
   * Returns the enemy's current speed
   * @return Double value representing enemy's speed
   */
  public double getSpeed() {
    return this.speed; //return speed
  } //end of getSpeed()
  
  /**
   * getHealth()
   * Returns the enemy's current health
   * @return Double value representing enemy's health
   */
  public double getHealth() {
    return this.health; //return health
  } //end of getHealth()
  
  /**
   * setHealth()
   * Sets enemy's current health to given amount
   * @param New health amount
   */
  public void setHealth(double amount) {
    this.health = amount; //set health
  } //end of setHealth()
  
  /**
   * getMoveCount()
   * Returns the enemy's move count (used for pathfinding algorithm)
   * @return Integer value of enemy's move count
   */
  public int getMoveCount() {
    return this.moveCount; //return move count
  } //end of getMoveCount()
  
  /**
   * setMoveCount()
   * Sets the enemy's mvoe count to given value
   * @param New move count
   */
  public void setMoveCount(int moveCount) {
    this.moveCount = moveCount; //set move count
  } //end of setMoveCount()
  
  /**
   * getSpriteCount()
   * Returns the enemy's current sprite count
   * @return Integer value representing enemy's current sprite count
   */
  public int getSpriteCount() {
    return this.spriteCount; //return sprite count
  } //end of getSpriteCount()
  
  /**
   * setSpriteCount()
   * Sets enemy's sprite count to given value
   * @param New sprite count
   */
  public void setSpriteCount(int spriteCount) {
    this.spriteCount = spriteCount; //set sprite count
  } //end of setSpriteCount()  
} //end of Enemy
