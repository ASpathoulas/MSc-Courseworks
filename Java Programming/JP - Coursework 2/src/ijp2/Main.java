/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ijp2;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandros Spathoulas
 */
    /**
     * The Class Main.
     */
    public class Main extends javax.swing.JFrame implements MainInterface{
    /**
     * CurrentLocation is the location that the user is at the exact moment.
     */
    private Location currentLocation;
    /**
     * CurrentView is the point of view that the user is looking at the exact 
     * moment.
     */
    private String currentView;
    /**
     * finder is an object of the class ImageFinder where all the paths of the 
     * images are stored.
     */
    private ImageFinder finder;
    /**
     * controller is an object of the class TurnController.
     */
    private TurnController controller;
    /**
     * objectLabel is an object of the class JLabel. In fact it is a label which 
     * will be used in order to contain an image.
     */
    private JLabel objectLabel;
    /**
     * myObject is a string which will be used for the items that are going to 
     * be inserted or removed.
     */
    private String myObject; 
    /**
     * itemsOfLocationList is a hashmap which contains the items that will be used as 
 keys and their labels as values.
     */
    private HashMap<String,JLabel> itemsOfLocationList;
    /**
     * distanceOfItem is an integer that will be used to print the items in a 
     * specific position in the label.
     */
    private final int distanceOfItem;
    /**
     * positionOfItem is the position of each item.Depends on the distanceOfItem.
     */
    private int positionOfItem;
    /**
     * newline is a string used in order to create a new line when something is 
     * printed.
     */
    private final String newline;
    /**
     * arrowLabel is a label used for the implementation of the map.
     */
    private JLabel arrowLabel;
    /**
     * numberOfx is integer that will be used in order to find the exact 
     * position of each location in the map.
     */
    private int numberOfx;
    /**
     * numberOfy is integer that will be used in order to find the exact 
     * position of each location in the map.
     */
    private int numberOfy;
    /**
     * booleanForEnableOfButton is a boolean value used in order to enable or
     * disable a button.
     */  
    private boolean booleanForEnableOfButton;
    /**
     * Main() is the constructor of the class.The fields are initialised, the 
     * objects are declared and the buttons not needed are disabled in order to
     * be enabled when the startButton is pressed. Also the buffered images are 
     * loaded in the ImageFinder class. 
     */
    public Main() {
        newline = "\n";
        distanceOfItem = 50;
        initComponents();
        finder = new ImageFinder();
        controller = new TurnController();
        itemsOfLocationList = new HashMap<String,JLabel>();
        arrowLabel = new JLabel();
        forwardButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        putDownMenu.setEnabled(false);
        pickUpMenu.setEnabled(false);
        backButton.setEnabled(false);
        numberOfx = 0;
        numberOfy = 0;
        positionOfItem = 0;
        finder.loadImages();
        finder.createExits();
    }
   
    /**
     * This method is called from within the constructor to initialise the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        imageLabel = new javax.swing.JLabel();
        forwardButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        itemLabel = new javax.swing.JLabel();
        myTextArea = new java.awt.TextArea();
        mapLabel = new javax.swing.JLabel();
        clearHistoryButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        myMenuBar = new javax.swing.JMenuBar();
        putDownMenu = new javax.swing.JMenu();
        mapPutDown = new javax.swing.JMenuItem();
        bookPutDown = new javax.swing.JMenuItem();
        laptopPutDown = new javax.swing.JMenuItem();
        hatPutDown = new javax.swing.JMenuItem();
        stopPutDown = new javax.swing.JMenuItem();
        pickUpMenu = new javax.swing.JMenu();
        mapPickUp = new javax.swing.JMenuItem();
        bookPickUp = new javax.swing.JMenuItem();
        laptopPickUp = new javax.swing.JMenuItem();
        hatPickUp = new javax.swing.JMenuItem();
        stopPickUp = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AppletonView");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BEGIN.jpg"))); // NOI18N

        forwardButton.setText("Forward");
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.setMaximumSize(new java.awt.Dimension(57, 23));
        exitButton.setMinimumSize(new java.awt.Dimension(57, 23));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        myTextArea.setEditable(false);
        myTextArea.setMinimumSize(new java.awt.Dimension(90, 80));

        mapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapEmpty.PNG"))); // NOI18N
        mapLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mapLabelMouseReleased(evt);
            }
        });

        clearHistoryButton.setText("Clear History");
        clearHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHistoryButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        helpButton.setMaximumSize(new java.awt.Dimension(57, 23));
        helpButton.setMinimumSize(new java.awt.Dimension(57, 23));
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        putDownMenu.setText("PutDown");

        mapPutDown.setText("Map");
        mapPutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapPutDownActionPerformed(evt);
            }
        });
        putDownMenu.add(mapPutDown);

        bookPutDown.setText("Book");
        bookPutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPutDownActionPerformed(evt);
            }
        });
        putDownMenu.add(bookPutDown);

        laptopPutDown.setText("Laptop");
        laptopPutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laptopPutDownActionPerformed(evt);
            }
        });
        putDownMenu.add(laptopPutDown);

        hatPutDown.setText("Hat");
        hatPutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatPutDownActionPerformed(evt);
            }
        });
        putDownMenu.add(hatPutDown);

        stopPutDown.setText("Stop");
        stopPutDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopPutDownActionPerformed(evt);
            }
        });
        putDownMenu.add(stopPutDown);

        myMenuBar.add(putDownMenu);

        pickUpMenu.setText("PickUp");

        mapPickUp.setText("Map");
        mapPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapPickUpActionPerformed(evt);
            }
        });
        pickUpMenu.add(mapPickUp);

        bookPickUp.setText("Book");
        bookPickUp.setToolTipText("");
        bookPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPickUpActionPerformed(evt);
            }
        });
        pickUpMenu.add(bookPickUp);

        laptopPickUp.setText("Laptop");
        laptopPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laptopPickUpActionPerformed(evt);
            }
        });
        pickUpMenu.add(laptopPickUp);

        hatPickUp.setText("Hat");
        hatPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatPickUpActionPerformed(evt);
            }
        });
        pickUpMenu.add(hatPickUp);

        stopPickUp.setText("Stop");
        stopPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopPickUpActionPerformed(evt);
            }
        });
        pickUpMenu.add(stopPickUp);

        myMenuBar.add(pickUpMenu);

        helpMenu.setText("Help");

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(exitMenuItem);

        myMenuBar.add(helpMenu);

        setJMenuBar(myMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearHistoryButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(myTextArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(forwardButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(forwardButton)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leftButton)
                            .addComponent(rightButton)
                            .addComponent(backButton))
                        .addGap(26, 26, 26)
                        .addComponent(clearHistoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Makes possible to the user to move forward. Changes the currentLocation 
     * according to the previous location and the forward button is enabled or 
     * disabled if there is or there is not an exit. As far as concern items,
     * those which are already printed belong to the previous location so they 
     * are removed in order to print those which belong to the new location. 
     * 
     * @param evt 
     */
    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        removeObjectsDrawn(currentLocation);

        currentLocation = currentLocation.getExit(currentView);
        imageLabel.setIcon(new javax.swing.ImageIcon(currentLocation.getImage(currentView)));
        
        forwardButtonEnable(currentLocation,currentView);
        backButtonEnable(currentLocation,controller.moveBack(currentView));
        movementInMap(currentLocation,currentView);
        
        myTextArea.append("Your location is " + currentLocation.getDescription() + newline);
        myTextArea.append("You are looking  " + currentView + newline);
        
        insertObjects(currentLocation);
        
    }//GEN-LAST:event_forwardButtonActionPerformed
     /**
     * Makes possible to the user to exit and close the application. The user is 
     * also asked if he really wants to exit.
     * 
     * @param evt 
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?", "Exit", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
          System.exit(0);          
        }
    }//GEN-LAST:event_exitButtonActionPerformed
    /**
     * Makes possible to the user to start the application. 
     * All the menuItems are enabled. CurrentLocation and currentView are
     * initialised with the help of finder object and the map begins to work. 
     * 
     * @param evt 
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // All buttons are enabled
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        putDownMenu.setEnabled(true);
        pickUpMenu.setEnabled(true);
        backButton.setEnabled(true);
        startButton.setEnabled(false);

        // Location view initialized(appleton and north)
        currentView = finder.getInitialView();
        currentLocation = finder.getInitialLocation();
        
        forwardButtonEnable(currentLocation,currentView);
        backButtonEnable(currentLocation,controller.moveBack(currentView));
        myTextArea.append("Your location is " + currentLocation.getDescription() + newline);

        myTextArea.append("You are looking  " + currentView + newline);

        imageLabel.setIcon(new javax.swing.ImageIcon(currentLocation.getImage(currentView)));

        movementInMap(currentLocation,currentView);
    }//GEN-LAST:event_startButtonActionPerformed
    /**
     * Makes possible to the user to turn right. CurrentView is changed 
     * according to the previous point of view. The new point of view is given 
     * from the TurnController class. Furthermore the proper image is shown and 
     * the forwardButton is enabled if there is an exit in the moving forward.
     * Also in the map the arrow used changes point of looking.
     * 
     * @param evt 
     */
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        currentView = controller.turnRight(currentView);
        
        imageLabel.setIcon(new javax.swing.ImageIcon(currentLocation.getImage(currentView)));
        
        forwardButtonEnable(currentLocation,currentView);
        backButtonEnable(currentLocation,controller.moveBack(currentView));
        movementInMap(currentLocation,currentView);
        myTextArea.append("You are looking  " + currentView + newline);
    }//GEN-LAST:event_rightButtonActionPerformed
    /**
     * Makes possible to the user to turn left. CurrentView is changed according
     * to the previous point of view. The new point of view is given form 
     * the TurnController class. Furthermore the proper image is shown and the 
     * forwardButton is enabled if there is an exit in the moving forward.Also 
     * in the map the arrow used changes point of looking. 
     * 
     * @param evt 
     */
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        currentView = controller.turnLeft(currentView);

        imageLabel.setIcon(new javax.swing.ImageIcon(currentLocation.getImage(currentView)));
        
        forwardButtonEnable(currentLocation,currentView);
        backButtonEnable(currentLocation,controller.moveBack(currentView));
        movementInMap(currentLocation,currentView);
        myTextArea.append("You are looking  " + currentView + newline);
    }//GEN-LAST:event_leftButtonActionPerformed
     /**
     * Makes possible to the user to  put down a map-item. When this button is 
     * pressed a new label is created in order to contain the image for the 
     * item. The label is now visible and it is stored in the hashmap with the 
     * items of the currentLocation.Also, the button for putting down that map 
     * is  disabled because it belongs to the location and cannot be inserted 
     * again.
     * 
     * @param evt 
     */
    private void mapPutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapPutDownActionPerformed
        myObject="Map";
        positionOfItem = currentLocation.getSumOfDistanceForObjects();
        objectLabel = new JLabel();
        objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(myObject)));
        
        objectInsert(myObject,currentLocation);

        mapPutDown.setEnabled(false);
    }//GEN-LAST:event_mapPutDownActionPerformed
     /**
     * Makes possible to the user to  pick up map-item. Firstly, the programme 
     * checks if this item is already stored in the location. If this is true 
     * the map-item is not visible anymore and it is removed for the 
     * currentLocation's list with items. Furthermore, in order to have the 
     * items in right position in the label for the items they are removed and 
     * drawn again after the update of the location 's hashmap with items.
     * 
     * @param evt 
     */
    private void mapPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapPickUpActionPerformed
        myObject = "Map";
        booleanForEnableOfButton = itemRemove(myObject, currentLocation);
        removeObjectsDrawn(currentLocation);
        if (booleanForEnableOfButton == true){
            mapPutDown.setEnabled(booleanForEnableOfButton);
            }
        objectsRedrawAfterRemoval(currentLocation);
    }//GEN-LAST:event_mapPickUpActionPerformed
     /**
     * Makes possible to the user to  put down map-item. When this button is 
     * pressed a new label is created in order to contain the image for the 
     * item.The label is now visible and it is stored in the hashmap with the 
     * items of the currentLocation. Also, the button for putting down that map 
     * is disabled because it belongs to the location and cannot be inserted 
     * again.
     * 
     * @param evt 
     */
    private void bookPutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPutDownActionPerformed
        myObject = "Book";
        positionOfItem = currentLocation.getSumOfDistanceForObjects();
        objectLabel = new JLabel();
        objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(myObject)));
        objectInsert(myObject,currentLocation);

        bookPutDown.setEnabled(false);
    }//GEN-LAST:event_bookPutDownActionPerformed
     /**
     * Makes possible to the user to  pick up book-item. Firstly, the programme 
     * checks if this item is already stored in the location. If this is true 
     * the book-item is not visible anymore and it is removed for the 
     * currentLocation's list with items. Furthermore, in order to have the 
     * items in right position in the label for the items they are removed and 
     * drawn again after the update of the location 's hashmap with items.
     * 
     * @param evt 
     */
    private void bookPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPickUpActionPerformed
        myObject = "Book";
        booleanForEnableOfButton = itemRemove(myObject, currentLocation);
        removeObjectsDrawn(currentLocation);
        
        objectsRedrawAfterRemoval(currentLocation);
        if (booleanForEnableOfButton == true){
            bookPutDown.setEnabled(booleanForEnableOfButton);
        }
    }//GEN-LAST:event_bookPickUpActionPerformed
     /**
     * Makes possible to the user to  put down laptop-item. When this button is 
     * pressed a new label is created in order to contain the image for the 
     * item.The label is now visible and it is stored in the hashmap with the 
     * items of the currentLocation. Also, the button for putting down the 
     * laptop is disabled because it belongs to the location and cannot be 
     * inserted again.
     * 
     * @param evt 
     */
    private void laptopPutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laptopPutDownActionPerformed
        myObject = "Laptop";
        positionOfItem = currentLocation.getSumOfDistanceForObjects();
        objectLabel = new JLabel();
        objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(myObject)));  
        objectInsert(myObject,currentLocation);
        laptopPutDown.setEnabled(false);
    }//GEN-LAST:event_laptopPutDownActionPerformed
     /**
     * Makes possible to the user to  pick up laptop-item. Firstly, the 
     * programme checks if this item is already stored in the location. If this 
     * is true the laptop-item is not visible anymore and it is removed for the 
     * currentLocation's list with items. Furthermore, in order to have the 
     * items in right position in the label for the items they are removed and 
     * drawn again after the update of the location 's hashmap with items.
     * @param evt 
     */
    private void laptopPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laptopPickUpActionPerformed
        myObject = "Laptop";
        booleanForEnableOfButton = itemRemove(myObject, currentLocation);
        removeObjectsDrawn(currentLocation);
        objectsRedrawAfterRemoval(currentLocation);
        if (booleanForEnableOfButton == true){
            laptopPutDown.setEnabled(booleanForEnableOfButton);
        }
    }//GEN-LAST:event_laptopPickUpActionPerformed
     /**
     * Makes possible to the user to  put down hat-item. When this button is 
     * pressed a new label is created in order to contain the image for the 
     * item.The label is now visible and it is stored in the hashmap with the 
     * items of the currentLocation. Also, the button for putting down the 
     * hat is disabled because it belongs to the location and cannot be 
     * inserted again.
     * 
     * @param evt 
     */
    private void hatPutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hatPutDownActionPerformed
        myObject = "Hat";
        positionOfItem = currentLocation.getSumOfDistanceForObjects();
        objectLabel = new JLabel();
        objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(myObject)));  
        objectInsert(myObject,currentLocation);
        hatPutDown.setEnabled(false);
    }//GEN-LAST:event_hatPutDownActionPerformed
     /**
     * Makes possible to the user to  pick up hat-item. Firstly, the 
     * programme checks if this item is already stored in the location. If this 
     * is true the hat-item is not visible anymore and it is removed for the 
     * currentLocation's list with items. Furthermore, in order to have the 
     * items in right position in the label for the items they are removed and 
     * drawn again after the update of the location 's hashmap with items.
     * @param evt 
     */
    private void hatPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hatPickUpActionPerformed
        myObject = "Hat";
        booleanForEnableOfButton = itemRemove(myObject, currentLocation);
        removeObjectsDrawn(currentLocation);
        if (booleanForEnableOfButton == true){
            hatPutDown.setEnabled(booleanForEnableOfButton);
        }
        objectsRedrawAfterRemoval(currentLocation);
    }//GEN-LAST:event_hatPickUpActionPerformed
     /**
     * Makes possible to the user to  put down stop-item. When this button is 
     * pressed a new label is created in order to contain the image for the 
     * item.The label is now visible and it is stored in the hashmap with the 
     * items of the currentLocation. Also, the button for putting down the 
     * stop is disabled because it belongs to the location and cannot be 
     * inserted again.
     * 
     * @param evt 
     */
    private void stopPutDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopPutDownActionPerformed
        myObject = "Stop";
        positionOfItem = currentLocation.getSumOfDistanceForObjects();
        objectLabel = new JLabel();
        objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(myObject)));  
        objectInsert(myObject,currentLocation);
        stopPutDown.setEnabled(false);
    }//GEN-LAST:event_stopPutDownActionPerformed
     /**
     * Makes possible to the user to  pick up stop-item. Firstly, the 
     * programme checks if this item is already stored in the location. If this 
     * is true the stop-item is not visible anymore and it is removed for the 
     * currentLocation's list with items. Furthermore, in order to have the 
     * items in right position in the label for the items they are removed and 
     * drawn again after the update of the location 's hashmap with items.
     * 
     * @param evt 
     */
    private void stopPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopPickUpActionPerformed
        myObject = "Stop";
        booleanForEnableOfButton=itemRemove(myObject, currentLocation);
        if (booleanForEnableOfButton == true){
            stopPutDown.setEnabled(booleanForEnableOfButton);
        }
        removeObjectsDrawn(currentLocation);
        objectsRedrawAfterRemoval(currentLocation);
    }//GEN-LAST:event_stopPickUpActionPerformed
     /**
     * Used in order to find the exact coordinates of a location in map.
     * @param evt 
     */
    private void mapLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapLabelMouseReleased
        numberOfx=evt.getX();
        numberOfy=evt.getY();
//        System.out.println("Coordinates: " + numberOfx+","+numberOfy);
    }//GEN-LAST:event_mapLabelMouseReleased
     /**
     * Button used in order to clear the text area.
     * 
     * @param evt 
     */
    private void clearHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearHistoryButtonActionPerformed
        myTextArea.setText("");
    }//GEN-LAST:event_clearHistoryButtonActionPerformed
     /**
     * When this menu-item is chosen a new frame is created which contains an 
     * image which explains the abilities of the application.
     * 
     * @param evt 
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        JFrame helpFrame = new JFrame();
        helpFrame.setVisible(true);
        JLabel helpLabel = new JLabel();
        helpFrame.add(helpLabel);
        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpme.png")));
        helpFrame.setSize(660, 480);
        helpFrame.setResizable(false);
        helpFrame.setTitle("Help");
    }//GEN-LAST:event_helpButtonActionPerformed
     /**
     * Makes possible to the user to exit and close the application. The user is 
     * also asked if he really wants to exit.
     * 
     * @param evt 
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
         String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?", "Exit", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
          System.exit(0);          
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed
     /**
     * When this menu-item is chosen a new frame is created which contains an 
     * image which explains the abilities of the application.
     * 
     * @param evt 
     */
    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        JFrame helpFrame = new JFrame();
        helpFrame.setVisible(true);
        JLabel helpLabel = new JLabel();
        helpFrame.add(helpLabel);
        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpImage.png")));
        helpFrame.setSize(875, 640);
        helpFrame.setResizable(false);
        helpFrame.setTitle("Help");
    }//GEN-LAST:event_helpMenuItemActionPerformed
     /**
     * By pressing the X-button the user is asked if he really wants to exit.
     * 
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?", "Exit", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
          System.exit(0);          
        }
    }//GEN-LAST:event_formWindowClosing
    /**
     * Makes possible to the user to move backward. Changes the currentLocation 
     * according to the previous location and the back button is enabled or 
     * disabled if there is or there is not an exit. As far as concern items,
     * those which are already printed belong to the previous location so they 
     * are removed in order to print those which belong to the new location. 
     * 
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        removeObjectsDrawn(currentLocation);
        
        currentLocation = currentLocation.getExit(controller.moveBack(currentView));
        imageLabel.setIcon(new javax.swing.ImageIcon(currentLocation.getImage(currentView)));
        
        forwardButtonEnable(currentLocation,currentView);
        movementInMap(currentLocation,currentView);
        
        myTextArea.append("Your location is " + currentLocation.getDescription() + newline);
        myTextArea.append("You are looking  " + currentView + newline);
        
        insertObjects(currentLocation);
        backButtonEnable(currentLocation,controller.moveBack(currentView));
    }//GEN-LAST:event_backButtonActionPerformed
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
    }

    /**
     * Prints the correct arrow in the map according to currentLocation and 
     * currrentView. The coordinates of the locations are given by the object 
     * finder of ImageFinder class.
     * 
     * @param myLocation the current location where the user is.
     * @param myView the current point of view where the user is looking at.
     */
    public void movementInMap(Location myLocation,String myView){
        arrowLabel.setIcon(new javax.swing.ImageIcon(finder.getArrow(myView)));
        mapLabel.add(arrowLabel);
        arrowLabel.setSize(30, 30);
        arrowLabel.setLocation(finder.getXLocationCoordinate(myLocation), finder.getYLocationCoordinate(myLocation));
        arrowLabel.setVisible(true);
    }
    
     /**
     * Enables the forward button if there is an exit at the point of view the 
     * user is looking at. Otherwise the button is disabled.
     * 
     * @param myLocation the current location where the user is.
     * @param myView the current point of view where the user is looking at.
     */
    @Override
    public void forwardButtonEnable(Location myLocation,String myView){
        if (myLocation.getExit(myView)!=null){
            forwardButton.setEnabled(true);
        }
        else{
            forwardButton.setEnabled(false);
        }
    }
     /**
     * Enables the back button if there is an exit at the "opposite" point of view the 
     * user is looking at. Otherwise the button is disabled.
     * 
     * @param myLocation the current location where the user is.
     * @param myView the current point of view where the user is looking at.
     */
    @Override
    public void backButtonEnable(Location myLocation,String myView){
        if (myLocation.getExit(myView)!=null){
            backButton.setEnabled(true);
        }
        else{
            backButton.setEnabled(false);
        }
    }
    
     /**
     * When the user changes a location this method (before currentLocation 
     * equals to the new value) removes all the items from the label in order to
     * be able to draw the new ones.
     * 
     * @param locationObjectsRemoved the location where the objects are removed.
     */
    public void removeObjectsDrawn(Location locationObjectsRemoved){
        itemsOfLocationList = locationObjectsRemoved.getItemsPictures();
        for (String objectKey : itemsOfLocationList.keySet()){    
               itemsOfLocationList.get(objectKey).setVisible(false);   
        }
    }
    
     /**
     * When the user changes a location this method (after currentLocation 
     * equals to the new value) inserts all the items,if any, that correspond 
     * to the current location.
     * 
     * @param locationToInsertObjects the location where the objects are inserted .
     */    
    public void insertObjects(Location locationToInsertObjects){
        itemsOfLocationList = locationToInsertObjects.getItemsPictures();
        for (String objectKey : itemsOfLocationList.keySet()){    
               itemsOfLocationList.get(objectKey).setVisible(true);
        }
    }
    
     /**
     * The item that was chosen in inserted in the a label and it is stored in 
     * the current location 's hashmap with items. Also, the positionOfItem is 
     * increased in order the new item to be printed next to the current.
     * 
     * @param objectInserted is a string that corresponds to the item chosen.
     * @param locationObjectInserted is the current location or the location 
     * that the user want to insert the item.
     */    
    public void objectInsert(String objectInserted,Location locationObjectInserted){
        itemsOfLocationList=locationObjectInserted.getItemsPictures();
        if (itemsOfLocationList.containsKey(objectInserted)== false){
            itemLabel.add(objectLabel);
            objectLabel.setLocation(positionOfItem,0);
            objectLabel.setSize(48, 48);
            objectLabel.setVisible(true);
            locationObjectInserted.setObjectPictures(objectInserted,objectLabel);
            positionOfItem += distanceOfItem;
        }
        locationObjectInserted.setSumOfDistanceForObjects(positionOfItem);
    }
    
     /**
     * The item that was chosen is not visible anymore and it is removed from 
     * the current location 's hashmap with items.
     * 
     * @param itemToBeRemoved the item that the user want to remove
     * @param locationObjectRemoved the location that the user wants to remove the item from. Actually, the current location.
     * @return true if the object was not in the current location 's list with items. This happens in order to enable the button so the user can put it down as it is not anywhere. 
     */       
    public boolean itemRemove(String itemToBeRemoved, Location locationObjectRemoved){
        itemsOfLocationList=locationObjectRemoved.getItemsPictures();
        if (itemsOfLocationList.containsKey(itemToBeRemoved)){
            itemsOfLocationList.get(itemToBeRemoved).setVisible(false);
            for (String key:itemsOfLocationList.keySet()){
                if (key.equals(itemToBeRemoved)){
                    locationObjectRemoved.removeLabel(itemToBeRemoved);
                    break;
                 }
            } 
            positionOfItem-=distanceOfItem;
            locationObjectRemoved.setSumOfDistanceForObjects(positionOfItem);
            return true;
        }
        
        else{
            myTextArea.append("A " +myObject + " was not picked up!!!" + newline);
            return false;
        }
    }
     /**
     * After a removal of an object the items are removed and printed again in 
     * order to initialise again their positions in the label.
     * 
     * @param LocationObjectsRedrawn the location for the redraw.
     */ 
    public void objectsRedrawAfterRemoval(Location LocationObjectsRedrawn){
        itemsOfLocationList = LocationObjectsRedrawn.getItemsPictures();
        positionOfItem=0;
        for (String newKey:itemsOfLocationList.keySet()){
            objectLabel = new JLabel();
            objectLabel.setIcon(new javax.swing.ImageIcon(finder.getObjectImage(newKey))); 
            itemLabel.add(objectLabel);
            objectLabel.setLocation(positionOfItem,0);
            objectLabel.setSize(48, 48);
            objectLabel.setVisible(true);
            LocationObjectsRedrawn.setObjectPictures(newKey, objectLabel);
            positionOfItem += distanceOfItem;
        }
        LocationObjectsRedrawn.setSumOfDistanceForObjects(positionOfItem);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem bookPickUp;
    private javax.swing.JMenuItem bookPutDown;
    private javax.swing.JButton clearHistoryButton;
    public javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton forwardButton;
    private javax.swing.JMenuItem hatPickUp;
    private javax.swing.JMenuItem hatPutDown;
    private javax.swing.JButton helpButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem laptopPickUp;
    private javax.swing.JMenuItem laptopPutDown;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel mapLabel;
    private javax.swing.JMenuItem mapPickUp;
    private javax.swing.JMenuItem mapPutDown;
    private javax.swing.JMenuBar myMenuBar;
    private java.awt.TextArea myTextArea;
    private javax.swing.JMenu pickUpMenu;
    private javax.swing.JMenu putDownMenu;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton startButton;
    private javax.swing.JMenuItem stopPickUp;
    private javax.swing.JMenuItem stopPutDown;
    // End of variables declaration//GEN-END:variables
}
