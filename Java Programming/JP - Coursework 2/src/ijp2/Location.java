/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ijp2;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JLabel;
/**
 *
 * @author aleksis
 */

/**
 *
 * The Class Location
 */
public class Location {
    /**
    * description is a string which contains the description of each location
    */
    private String description;
    /**
    * exits is a hashmap used to store exits for each location and for each 
    * direction.
    */
    private HashMap<String,Location> exits;
    /**
    * drawingsHashMap is a hashmap used to store the label of each item for 
    * each location.
    */
    private HashMap<String,JLabel> drawingsHashMap;
    /**
    * sumOfDistanceForObjects is an integer used to store the value of the 
    * position that the next item should be drawn
    */
    private int sumOfDistanceForObjects;
    
    private HashMap<String,BufferedImage> imagesOfCurrentLocation;
    
    /**
    * The constructor is used in order when a new  location is created new 
    * hashmaps to be created for the specific location.
    * 
    * @param description is about a string which contains information about the location
    */
    public Location(String description){

        drawingsHashMap = new HashMap<>();
        this.description=description;
        exits = new HashMap<>();
        imagesOfCurrentLocation = new HashMap<>();
    }
    /**
    * An exit is set for each location through a specific direction
    * 
    * @param direction the direction through it the user can change locations
    * @param neighbor the location the user can move to through the direction
    */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }
    /**
    * The location that the user goes to from a specific direction is returned.
    * 
    * @param direction the direction that the user wants to go through.
    * @return the new location the user has been moved to.
    */
    public Location getExit(String direction){
        return exits.get(direction);
    }
    /**
    * The location 's description is returned
    * 
    * @return the description of the location
    */
    public String getDescription(){
        return description;
    }
    
    /**
    * For each location in a hashmap the items are inserted with their JLabels 
    * 
    * @param picture the string with the name of the item
    * @param pictureLabel the label of the item called picture
    */
    public void setObjectPictures(String picture,JLabel pictureLabel){
        drawingsHashMap.put(picture,pictureLabel);
    }
    /**
    * The hash map with the items included is returned
    * 
    * @return the hashmap with the items for each location
    */
    public HashMap<String,JLabel> getItemsPictures(){
        return drawingsHashMap;
    }
    /**
    * An item is removed from the hashmap for the current location.
    * 
    * @param nameLabel the name of the item that must be removed
    */
    public void removeLabel(String nameLabel){
        drawingsHashMap.remove(nameLabel);
    }
    /**
    * The position that the next item should be drawn is returned
    * 
    * @return the value of the position of the next item
    */
    public int getSumOfDistanceForObjects() {
        return sumOfDistanceForObjects;
    }
    
    /**
    * The position that the next item should be drawn for each location
    * is set.
    * 
    * @param sumOfDistanceForObjects the position where the previous item ends
    */
    public void setSumOfDistanceForObjects(int sumOfDistanceForObjects) {
        this.sumOfDistanceForObjects = sumOfDistanceForObjects;
    }
    /**
    * The bufferedImages of the currentLocation are loaded in a hashmap called 
    * imagesOfCurrentLocation according to the point of view
    * (north,east,south,west).
    * 
    * @param direction the direction the image corresponds to.
    * @param myBufferedImage image for the current location and given direction.
    */
    public void setPath(String direction, BufferedImage myBufferedImage) 
    {
        imagesOfCurrentLocation.put(direction, myBufferedImage);
    }
    
    /**
    * The user gets the bufferedImage that corresponds to the direction he wants 
    * to look at.
    * 
    * @param direction the direction the user wants to look at
    * @return the correct bufferedImage for the direction given
    */
    public BufferedImage getImage(String direction){
        return imagesOfCurrentLocation.get(direction);
    }
}
