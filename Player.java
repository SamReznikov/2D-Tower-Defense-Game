/**
 * Player.java by Sam Reznikov
 * January 19, 2019
 * Represents the player and keeps his stats up to date
 */

public class Player {
  private int health; //player's health
  private int money; //player's money
  private int enemiesKilled = 0; //number of enemies killed
  
  /**
   * Player()
   * Sets health and money to given amounts
   * @param Player's initial health
   * @param Player's initial money
   */
  public Player(int health, int money) {  
    this.health = health; //initialize health
    this.money = money; //initialize money
  } //end of constructor
  
  /**
   * getEnemiesKilled()
   * Returns the number of enemies the player has killed so far
   * @return Integer value of enemies killed
   */
  public int getEnemiesKilled() {
    return this.enemiesKilled; //return enemies killed
  } //end of getEnemiesKilled()
  
  /**
   * setEnemiesKilled()
   * Sets enemies killed to given amount
   * @param New amount of enemies killed
   */
  public void setEnemiesKilled(int amount) {
    this.enemiesKilled = amount; //set enemies killed
  } //end of setEnemiesKilled()
  
  /**
   * getHealth()
   * Returns the amount of health the player has remaining
   * @return Remaining health
   */
  public int getHealth() {
    return this.health; //return health
  } //end of getHealth()
  
  /**
   * setHealth()
   * Sets health to given value
   * @param New health amount
   */
  public void setHealth(int amount) {
    this.health = amount; //set health
  } //end of setHealth()
  
  /**
   * getMoney()
   * Returns the amount of money the player has so far
   * @return Integer value of player's current money
   */
  public int getMoney() {
    return this.money; //return money
  } //end of getMoney()
  
  /**
   * setMoney()
   * Sets player's money to given value
   * @param New money amount
   */
  public void setMoney(int amount) {
    this.money = amount; //set money
  } //end of setMoney()
} //end of Player
