 
//import ijp.Photo;
//import ijp.PhotoFinder;
//import ijp.FlickrPhotoFinder;
//import ijp.PhotoViewer;
//import ijp.MyPhotoController;
//import ijp.PhotoController;
import org.junit.Test;

/**
 *
 * @author  Paul Anderson <dcspaul@ed.ac.uk>
 * @version %I%, %G%
 */
public class MyPhotoControllerTest extends junit.framework.TestCase implements PhotoViewer {

    private PhotoController controller;
    private String displayedPhotoSubject;

    @Override
    public void setController(PhotoController controller) {
        // ignored
    }

    @Override
    public void setButtonLabel(int n, String caption) {
        // ignored
    }

    @Override
    public void show(Photo photo) {

        // this method will be called by the controller under test
        // when it is wants to display a photo on the screen.
        // we pretend to be the viewer and just save the subject
        // of the photo, so that we can check it later.
        displayedPhotoSubject = photo.getSubject();
    }

    @Override
    /**
     * This method is called by the controller to displays the window and
     * starts accepting user interaction.
     */
    public void open() {

       
         // First Test
         // Button 1 is pressed by the user to ckeck if the photo desplayed belong to the subject above.
         

        controller.buttonPressed(1);
        assertEquals(displayedPhotoSubject, "university edinburgh informatics forum building");     
        
        
        //  Second Test
        //  Button 3 is pressed 19 times in order to check if the photos are loaded again after they are all shown. 
        

        for(int i=0;i<19;i++){
            controller.buttonPressed(3);
        }
        assertEquals(displayedPhotoSubject, "edinburgh royal mile");     
    }

    @Test
    public void test1() {

        // The finder for locating photos on Flickr 
        PhotoFinder finder = new FlickrPhotoFinder();

        // set the Flickr API key
        // you must obtain and fill in this key before the program will work
        // obtain your own key from here: http://bit.ly/8B4ql0
        finder.setAPIKey("a126d73f44b4a71d1beecf8be500fccd");

        // create a new controller
        // this object will pretend to be the viewer
        controller = new MyPhotoController(finder, this);

        // start the controller
        controller.start();
    }
}
