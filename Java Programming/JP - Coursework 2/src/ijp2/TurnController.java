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

/**
 * The class TurnController
 */
public class TurnController {

    /**
    * view is a string used in order to set and return the vales of the new 
    * point of view 
    */
    private String view;

    /**
    * Returns the new value of view which depends on the previous and on the 
    * fact that the user turns right .
    * 
    * @return view the new value of view.
    */
    public String turnRight(String view){
        if (view == "north"){
            view = "east";
        }
        else if (view == "east"){
            view = "south";
        }
        else if (view == "south"){
            view = "west";
        }
        else {
           view = "north";
        }
        return view;
    }
    /**
    * Returns the new value of view which depends on the previous and on the 
    * fact that the user turns left .
    * 
    * @return view the new value of view.
    */
    public String turnLeft(String view){
        if (view == "north"){
            view = "west";
        }
        else if (view == "west"){
            view = "south";
        }
        else if (view == "south"){
            view = "east";
        }
        else{
            view = "north";
        }
        return view;
    }
    /**
    * Returns the new value of view which depends on the previous and on the 
    * fact that the user moves backwards.
    * 
    * @return view the new value of view.
    */
    public String moveBack(String view){
         if (view == "north"){
            view = "south";
        }
        else if (view == "west"){
            view = "east";
        }
        else if (view == "south"){
            view = "north";
        }
        else{
            view = "west";
        }
        return view;
    }
    }


