package Checkers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {

    int x;
    int y;
    Image image;
    int width;
    int height;
    String name;
    
    /* Two constructors for setting up initial values and for easy
     * initialization.
     */
    public Sprite() {
        x = y = 0;
        width = height = 0;
        image = null;
    }
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        width = height = 0;
        image = null;
    }
    
    // Setter and getter methods for the X attribute
    public void setX(int x) { this.x = x; }
    public int getX() { return x; }
    
    // Setter and getter methods for the Y attribute
    public void setY(int y) { this.y = y; }
    public int getY() { return y; }
    
    /* Setter and getter method for the image attribute.
     * The setter method has the additional task of assigning the width
     * and height variables based on the image.
     */
    public void setImage(Image img) {
        image = img;
        width =image.getWidth(null);
        height = image.getHeight(null);
    }
    
    public void scaleSprites(int scale) {
    	Image temp=image.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(temp);
		image=icon.getImage();
    }
    
    public Image getImage() { return image; }
    public int getWidth() {return width; }
    public int getHeight() { return height; }
}
