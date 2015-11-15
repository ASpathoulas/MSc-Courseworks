/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ijp2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author aleksis
 */
/**
 * The class ImageFinder
 */
public class ImageFinder {
    /**
    * hashMapWithItems is the hashmap were the names of the items are loaded as
    * keys and the bufferedImages as values.
    */
    private HashMap<String,BufferedImage> hashMapWithItems;
    /**
    * hashMapWithCoordinates is the hashmap were the location with their 
    * coordinates in the map are loaded.
    */
    private HashMap<Location,ArrayList<Integer>> hashMapWithCoordinates;
    /**
    * hashMapWithArrows is the hashmap were the direction of the arrows are 
    * loaded with the buffered images of the arrows.
    */
    private HashMap<String,BufferedImage> hashMapWithArrows;
    
    /**
     * Location appletonTower is created
     */
    private Location appletonTower = new Location("Appleton Tower");
    /**
     * Location informaticsForum is created
     */
    private Location informaticsForum = new Location("Informatics Forum");
    /**
     * Location georgeSquare is created
     */    
    private Location georgeSquare = new Location("George Square");
    /**
     * Location businessSchool is created
     */    
    private Location businessSchool = new Location("Business School");
         
    /**
     * Location library is created
     */    
    private Location library = new Location("Library");
    /**
     * The four hashmaps are loaded with buffered images of all the images the 
     * application needs. Also the coordinates of the locations are set.
     */      
    public void loadImages(){
        appletonTower.setPath("north",turnToBuffered("/1front.jpg"));
        appletonTower.setPath("east",turnToBuffered("/1right.jpg"));
        appletonTower.setPath("south",turnToBuffered("/1back.jpg"));
        appletonTower.setPath("west",turnToBuffered("/1left.jpg"));
        
        informaticsForum.setPath("north",turnToBuffered("/2right.jpg"));
        informaticsForum.setPath("east",turnToBuffered("/2back.jpg"));
        informaticsForum.setPath("south",turnToBuffered("/2left.jpg"));
        informaticsForum.setPath("west",turnToBuffered("/2front.jpg"));
        
        georgeSquare.setPath("north",turnToBuffered("/3right.jpg"));
        georgeSquare.setPath("east",turnToBuffered("/3back.jpg"));
        georgeSquare.setPath("south",turnToBuffered("/3left.jpg"));
        georgeSquare.setPath("west",turnToBuffered("/3front.jpg"));
        
        businessSchool.setPath("north",turnToBuffered("/4right.jpg"));
        businessSchool.setPath("east",turnToBuffered("/4back.jpg"));
        businessSchool.setPath("south",turnToBuffered("/4left.jpg"));
        businessSchool.setPath("west",turnToBuffered("/4front.jpg"));
        
        library.setPath("north",turnToBuffered("/5front.jpg"));
        library.setPath("east",turnToBuffered("/5right.jpg"));
        library.setPath("south",turnToBuffered("/5back.jpg"));
        library.setPath("west",turnToBuffered("/5left.jpg"));
        
        hashMapWithItems = new HashMap<String,BufferedImage>();
        hashMapWithItems.put("Map",turnToBuffered("/myMap.png"));
        hashMapWithItems.put("Book",turnToBuffered("/book2.png"));
        hashMapWithItems.put("Laptop",turnToBuffered("/laptop1.png"));
        hashMapWithItems.put("Hat",turnToBuffered("/hat.png"));
        hashMapWithItems.put("Stop",turnToBuffered("/stopSign.png"));
        
        hashMapWithCoordinates = new HashMap<Location,ArrayList<Integer>>();
        hashMapWithCoordinates.put(appletonTower,new ArrayList<Integer>());
        hashMapWithCoordinates.get(appletonTower).add(0,50);
        hashMapWithCoordinates.get(appletonTower).add(1,155);
        hashMapWithCoordinates.put(informaticsForum,new ArrayList<Integer>());
        hashMapWithCoordinates.get(informaticsForum).add(0,105);
        hashMapWithCoordinates.get(informaticsForum).add(1,155);
        hashMapWithCoordinates.put(georgeSquare,new ArrayList<Integer>());
        hashMapWithCoordinates.get(georgeSquare).add(0,105);
        hashMapWithCoordinates.get(georgeSquare).add(1,100);
        hashMapWithCoordinates.put(businessSchool,new ArrayList<Integer>());
        hashMapWithCoordinates.get(businessSchool).add(0,105);
        hashMapWithCoordinates.get(businessSchool).add(1,50);
        hashMapWithCoordinates.put(library,new ArrayList<Integer>());
        hashMapWithCoordinates.get(library).add(0,165);
        hashMapWithCoordinates.get(library).add(1,50);       
        
        hashMapWithArrows = new HashMap<String,BufferedImage>();
        hashMapWithArrows.put("north",turnToBuffered("/myArrow1.PNG"));
        hashMapWithArrows.put("east",turnToBuffered("/myArrow4.PNG"));
        hashMapWithArrows.put("west",turnToBuffered("/myArrow2.PNG"));
        hashMapWithArrows.put("south",turnToBuffered("/myArrow3.PNG"));

        
        }
    
        
     /**
     * The exits for each location to another through a specific direction are created.
     */ 
    public void createExits(){
        appletonTower.setExit("north", informaticsForum);
        informaticsForum.setExit("west", georgeSquare);
        informaticsForum.setExit("south", appletonTower);
        georgeSquare.setExit("west", businessSchool);
        georgeSquare.setExit("east", informaticsForum);
        businessSchool.setExit("east", georgeSquare);
        businessSchool.setExit("north", library);
        library.setExit("south", businessSchool);
    }
     /**
     * The location is initialised.Happens only at the beginning of the 
     * application.
     */ 
    public Location getInitialLocation(){
        return appletonTower;
    }
     /**
     * The point of view is initialised.Happens only at the beginning of the 
     * application.
     */ 
    public String getInitialView(){
        return "north";
    }
     /**
     * The buffered images of the specific item is returned
     * 
     * @param objectImage the wanted item by the user
     * @return the path asked by the user
     */   
    public BufferedImage getObjectImage(String objectImage){
        return hashMapWithItems.get(objectImage);
    }
    
     /**
     * The x coordinate is returned for a specific location
     * 
     * @param currLocation the current location each time
     * @return the x-number of exact location
     */   
    public int getXLocationCoordinate(Location currLocation){
        return hashMapWithCoordinates.get(currLocation).get(0);
    }
    
     /**
     * The y coordinate is returned for a specific location
     * 
     * @param currLocation the current location each time
     * @return the y-number of exact location
     */   
    public int getYLocationCoordinate(Location currLocation){
        return hashMapWithCoordinates.get(currLocation).get(1);
    }
    
    /**
     * The arrow for the exact point of view is returned
     * 
     * @param pointOfView asked from the user
     * @return the buffered image of the the arrow looking at the direction 
     * asked.
     */   
    public BufferedImage getArrow(String pointOfView){
        return hashMapWithArrows.get(pointOfView);
    }
    
     /**
     * By turnToBuffered a path of an image is given and the buffered image
     * is returned
     * 
     * @param imagePath the path of the image that has to be turned to buffered.
     * @return the buffered image path given. 
     */ 
    public BufferedImage turnToBuffered(String imagePath){
        try {
            BufferedImage buffered =ImageIO.read(this.getClass().getResource(imagePath));
            return buffered;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
