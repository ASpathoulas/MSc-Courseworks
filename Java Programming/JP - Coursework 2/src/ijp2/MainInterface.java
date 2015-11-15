/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ijp2;

/**
 *
 * @author Alexandros Spathoulas
 */
public interface MainInterface {

    /**
     * Enables the back button if there is an exit at the "opposite" point of view the
     * user is looking at. Otherwise the button is disabled.
     *
     * @param myLocation the current location where the user is.
     * @param myView the current point of view where the user is looking at.
     */
    void backButtonEnable(Location myLocation, String myView);

    /**
     * Enables the forward button if there is an exit at the point of view the
     * user is looking at. Otherwise the button is disabled.
     *
     * @param myLocation the current location where the user is.
     * @param myView the current point of view where the user is looking at.
     */
    void forwardButtonEnable(Location myLocation, String myView);
    
}
