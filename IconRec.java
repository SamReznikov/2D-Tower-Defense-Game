/**
 * IconRec.java by Sam Reznikov
 * January 19, 2019
 * Represents a button in the game. Used by user to interact with the world and do things such as place towers
 */

//Import necessary libraries
import java.awt.Color;
import java.awt.image.BufferedImage;

public class IconRec {
  private int width; //width of button
  private int height; //height of button
  private int x; //x coordinate of button
  private int y; //y coordinate //of button
  private boolean clicked = false; //clicked state
  private Color color = Color.darkGray; //default color
  private String desc; //description
  private int cost; //button cost
  private boolean hovering = false; //hovering state
  private BufferedImage image; //button image
  
  /**
   * IconRec()
   * This constructor initializes all necessary values for a button to be functional
   * @param Button's width
   * @param Button's height
   * @param Button's X coordinate
   * @param Button's Y coordinate
   * @param Button's description (shown when hovered over)
   * @param Button's cost
   * @param Button's image
   */
  public IconRec(int width, int height, int xPos, int yPos, String description, int cost, BufferedImage image) { 
    //initialize instance variables
    this.width = width;
    this.height = height;
    this.x = xPos; //top left corner
    this.y = yPos; //top left corner
    this.desc = description;
    this.image = image;
    this.cost = cost;
  } //end of constructor
  
  /**
   * getHovering()
   * Returns the button's hover state
   * @return Boolean, true if the button is being hovered over, false otherwise.
   */
  public boolean getHovering() {
    return this.hovering; //return hovering state
  } //end of getHovering()
  
  /**
   * setHovering()
   * Sets the button's hover state to given value
   * @param New hover state
   */
  public void setHovering(boolean state) {
    this.hovering = state; //set hovering state
  } //end of setHovering()
  
  /**
   * getCost()
   * Returns the button's cost
   * @return Integer value representing the button's cost
   */
  public int getCost() {
    return this.cost; //get button cost
  } //end of getCost()
  
  /**
   * getDesc()
   * Returns the button's description
   * @return String holding the button's description
   */
  public String getDesc() {
    return this.desc; //return button description
  } //end of getDesc()
  
  /**
   * getImage()
   * Returns the button's image
   * @return The button's image
   */
  public BufferedImage getImage() {
    return this.image; //return button image
  } //end of getImage()
  
  /**
   * getWidth()
   * Returns the button's width
   * @return Integer value representing button width
   */
  public int getWidth() {
    return this.width; //return button width
  } //end of getWidth()
  
  /**
   * getHeight()
   * Returns the button's height
   * @return Integer value representing button height
   */
  public int getHeight() {
    return this.height; //return button height
  } //end of getHeight()
  
  /**
   * getX()
   * Returns the button's X coordinate
   * @return The button's X coordinate
   */
  public int getX() {
    return this.x; //return x coordinate
  } //end of getX()
  
  /**
   * getY()
   * Returns the button's Y coordinate
   * @return The button's Y coordinate
   */
  public int getY() {
    return this.y; //return y coordinate
  } //end of getY()
  
  /**
   * setClicked()
   * Sets button's clicked state to given clicked state
   * @param New clicked state
   */
  public void setClicked(boolean state) {
    if (state) { //if clicked
      this.color = Color.gray; //set color to gray
    } //end of clicked check
    else { //otherwise not clicked
      this.color = Color.darkGray; //set color to dark gray
    } //end of not clicked check
    this.clicked = state; //update clicked state
  } //end of setClicked()
  
  /**
   * isClicked()
   * Returns the button's clicked state
   * @return Boolean, true if the button is currently clicked, false otherwise.
   */
  public boolean isClicked() {
    return this.clicked; //return clicked state
  } //end of isClicked()
  
  /**
   * getColor()
   * Returns the button's color
   * @return Color value of button's color
   */
  public Color getColor() {
    return this.color; //return button color
  } //end of getColor()
} //end of IconRec
