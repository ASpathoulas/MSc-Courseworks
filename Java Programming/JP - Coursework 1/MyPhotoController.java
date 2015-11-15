 
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
/**
 * The skeleton code for IJP Assignment 1 - for you to modify. This "starter"
 * skeleton includes a simple demonstration of the photo viewer which will
 * display a single photograph.
 *
 * @author  Paul Anderson <dcspaul@ed.ac.uk>
 * @version %I%, %G%
 */
public class MyPhotoController implements PhotoController {

    /** The finder for locating photos on Flickr */
    private PhotoFinder finder;
    /** the viewer for displaying photos in a window */
    private PhotoViewer viewer;
    /** size equals to 20 and represents the numbers of photos needed which cannot be changed */
    private static final int size = 20;
    /** an new array called photoArray is created which belongs to class Photo */
    private Photo photoArray[] = new Photo[size];
    /** Subjects is an array which contains all the subjects needed to present photos of */
    private String[] subjects = {"university edinburgh informatics forum building", 
                                "university edinburgh appleton tower", 
                                "edinburgh royal mile"};
    
    // An instance of class Random is created. The specific instance generates random numbers.
    private Random random = new Random();
    // A hashmap is created to correspond integer with arraylists of integers
    private HashMap<Integer,ArrayList<Integer>> mapWithSubjectsAndImages;
    // Another hashmap called counters to correspond integers with integers
    private HashMap<Integer, Integer> counters;
    // an array of integers is created
    private int[] randomNumOfPhotosPerSubject;
    
    /** 
    * Constructor method
    * The array called randomNumOfPhotosPerSubject is created and its subject is the length of the subjects.
    * For example, of 3 subjects subjects.length=3.
    * The hashmaps called mapWithSubjectsAndImages and counters are also created. 
    * The hashmap's key's are integers and the values are an arraylist of integers and an integer respectively.        
    * In the for-loop above, the keys of the two hashmaps correspond for mapWithSubjectsAndImages to an arraylist with integers 
    * and for couters to zero.
    * 
    * @param finder the photo finder object to locate images on Flickr
    * @param viewer the photo viewer object to display images in a window
    */
    public MyPhotoController(PhotoFinder finder, PhotoViewer viewer) {
        this.finder = finder;
        this.viewer = viewer;
        randomNumOfPhotosPerSubject = new int[subjects.length];
  
        mapWithSubjectsAndImages = new HashMap<Integer,ArrayList<Integer>>();
        counters = new HashMap<Integer, Integer>();

        for (int i = 0; i < subjects.length; i++){
            mapWithSubjectsAndImages.put(i + 1 ,new ArrayList<Integer>());
            counters.put(i + 1, 0);
        }
        
    }
    
    /** 
     * A new method called findRandomNumOfPhotosPerSubject is created in order to find the random number of photos for each subject.
     * The first element of the array given when the method is called equals to 1 plus a random number between 0 and size-subject.length
     * Plus 1 is used in order to avoid the situation in which a subjects gets 0 photos.
     * In the for-loop above, random numbers of photos are created for each subject except the first which is already created.
     * In the second for-loop, the last subject gets the numbers of photos which are left 
     * from size 20 after the removal of the other subject's photos. 
     * 
     * @param randomNumOfPhotosPerSubject list of integers which represents the random number of photos for each subject
     */
    private void findRandomNumOfPhotosPerSubject(int[] randomNumOfPhotosPerSubject){
        randomNumOfPhotosPerSubject[0] = random.nextInt(size - subjects.length) + 1;
        for(int i = 1; i < subjects.length - 1; i++){
            randomNumOfPhotosPerSubject[i] = random.nextInt(size - subjects.length + 1 - randomNumOfPhotosPerSubject[i-1]) + 1;
        }
        randomNumOfPhotosPerSubject[subjects.length - 1] = size;
        for(int i = 0; i < subjects.length - 1; i++){
            randomNumOfPhotosPerSubject[subjects.length - 1] = randomNumOfPhotosPerSubject[subjects.length - 1] - randomNumOfPhotosPerSubject[i];
        }
    }

    /**
     * Starts the controller by displaying the viewer window and accepting user
     * interaction. The skeleton code first labels (and hence enables) one
     * button in the viewer.
     * Firstly, method findRandomNum OfPhotosPerSubject is called  for the number of subjects.
     * Secondly an other method called loadPhotos is called. Its work is to load the photoArray with 20 photos.
     * The value of each button is set.
     * Viewer starts.
     */
    @Override
    public void start() {
        findRandomNumOfPhotosPerSubject(randomNumOfPhotosPerSubject);
        loadPhotos();
        
        viewer.setButtonLabel(1, "Informatics Building");
        viewer.setButtonLabel(2, "Appleton Tower");
        viewer.setButtonLabel(3, "Royal Mile");
        viewer.open();
    }

    /**
     * Handles the selection buttons in the interface.
     * The object photo of class Photo is created.
     * The switch button calls for each press the method findPhoto for the specific subject.
     * If the photo found in the switch is not null, then it appears.
     *
     * @param n the button pressed number
     */
    @Override
    public void buttonPressed(int n) {
        Photo photo = new Photo();
        switch(n){
            case 1: photo = findPhoto(n);
                    break;
            case 2: photo = findPhoto(n);
                    break;
            case 3: photo = findPhoto(n);
                    break;
            default: exitButtonPressed();
                    break;
        }

        if (photo != null) {
            viewer.show(photo);
        }
    }

    /**
     * Handles the "Close" button on the interface window. Exits the
     * application.
     */
    @Override
    public void exitButtonPressed() {
        System.exit(0);
    }
    /** 
     * LoadPhotos is the method which loads the photoArray.
     * The first for-loop is about the subject. For example, if i equals to 0 the load is for the first subject.
     * The second for-loop is about the number of photos of each subject which is chosen before randomly.
     * The counter is used in order to ensure that each time an image is loaded 
     * the next one must be loaded in the exact next position of the arraylist.
     * When the procedure is finished counter maust equals to 20.
     * The for-loop calls shuffleArrayList for each subject which shuffles each subject's list of photos in order to be shown randomly.
     * 
     */
    public void loadPhotos(){    
        int counter = 0;
        for (int i = 0; i < subjects.length; i++){
            for(int j = 0; j < randomNumOfPhotosPerSubject[i]; j++){
               photoArray[counter] = finder.find(subjects[i], j + 1);
               mapWithSubjectsAndImages.get(i+1).add(counter);
               counter++;
            }
        }
        // 
        for (int i = 0; i < subjects.length; i++){
            shuffleArrayList(mapWithSubjectsAndImages.get(i+1));
        }
    }
    /** shuffleArrayList is the method used before to shuffle the sequence of photos
     * 
     * @param arrayList is the parameter used in order to declare a list to be shuffled
     */
    private void shuffleArrayList(ArrayList<Integer> arrayList){
        Collections.shuffle(arrayList);   
    }
    /** FindPhoto is a method which gets the button pressed and presents a random image for the subject that corresponds to it.
     * The if-loop above re-loads and re-shuffles the images if they have all been shown
     * If the photo for the specific press is not null then is shown.
     * It is important to mention that when a photo is shown the counter increases by one to move to the next image
     * 
     * @param subjectIndex the key to find from the button pressed tha appropriate photo
     * @returns the photo which corresponds to the parameters
     * 
     */
    public Photo findPhoto(int subjectIndex){
        if(counters.get(subjectIndex) == randomNumOfPhotosPerSubject[subjectIndex - 1]){
            counters.put(subjectIndex, 0);
            shuffleArrayList(mapWithSubjectsAndImages.get(subjectIndex));
        }
        if (photoArray[mapWithSubjectsAndImages.get(subjectIndex).get(counters.get(subjectIndex))]!=null){
            counters.put(subjectIndex, counters.get(subjectIndex) + 1);
            return photoArray[mapWithSubjectsAndImages.get(subjectIndex).get(counters.get(subjectIndex) - 1)];
        } 
        else{
            System.out.println("The image was not found !!!");
        }
        return null;
    }
    
}
