/**
 * Tile.java by Sam Reznikov
 * January 19, 2019
 * Represents a tile on the map that the player may or may not be able to interact with
 */

//import libraries
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
  private Tower tower = null; //tower on tile
  private BufferedImage image; //tile image
  private int type; //1 for path, 2 for obstacle, 0 for normal land
  private int x; //x coordinate
  private int y; //y coordinate
  
  /**
   * Tile()
   * This constructor initializes necessary values for a tile to be functional
   * @param The type of tile
   * @param All images of tile type
   * @param The X coordinate of tile
   * @param The Y coordinate of tile
   */
  public Tile(int type, ArrayList<BufferedImage> allImages, int xPos, int yPos) { 
    //initialize instance variables
    this.type = type;
    int range = allImages.size();
    int idx = (int)(Math.random() * ((range-1) + 1)); //randomize index
    this.image = allImages.get(idx); //use random index to randomize tile image
    this.x = xPos;
    this.y = yPos;
  } //end of constructor
  
  /**
   * addTower()
   * Assigns a tower to this tile
   * @param Tower to add
   */
  public void addTower(Tower newTower) {
    if (tower == null) { //if no tower on tile
      this.tower = newTower; //add the new tower
    } //end of null check
  } //end of addTower()
  
  /**
   * getTower()
   * Returns the tile's assigned tower
   * @return The tile's tower
   */
  public Tower getTower() {
    return this.tower; //return the tile's tower
  } //end of addTower()
  
  /**
   * removeTower()
   * Removes the tile's tower (sets to null)
   */
  public void removeTower() {
    this.tower = null; //set tile's tower to null
  } //end of removeTower()
  
  /**
   * getType()
   * Returns the tile type
   * @return Tile type
   */
  public int getType() {
    return this.type; //return tile type
  } //end of getType()
  
  /**
   * getX()
   * Returns tile's X coordinate
   * @return Tile's X coordinate
   */
  public int getX() {
    return this.x; //return x coord
  } //end of getX()
  
  /**
   * getY()
   * Returns tile's Y coordinate
   * @return Tile's Y coordinate
   */
  public int getY() {
    return this.y; //return y coord
  } //end of getY()
  
  /**
   * getImage()
   * Returns the tile image
   * @return The tile's image
   */
  public BufferedImage getImage() {
    return this.image; //return tile image
  } //end of getImage()
} //end of Tile
