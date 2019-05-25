/**
 *
 * @author Soravath Mengseng
 */
package ElevatorMovementSimulator;

import java.util.ArrayList;
import java.util.Random;


public class Scenario {
    // data attribute
    private ControllerDemo controller;
    private ArrayList <Integer> floorCollection;
    private int move;
    //private ArrayList <Integer> elevatorCollection;
    
    private boolean doorOpen = true; 
    private boolean doorClose = false;
    private int s = 0;
    private int setfloor = 0;
    public int trackingVisitor = 0;
    
    public Scenario(ControllerDemo controller) {
        this.controller = controller;
    }
    public void setTrackingVisitor(){
      trackingVisitor =  controller.initV;
    }
    public void createFloor( int floor  ){
        setfloor = floor;
        floorCollection = new ArrayList <Integer>();
        for (int i= 0; i < floor; ++i ){
            floorCollection.add(i);
           //System.out.println(" this me" + floorCollection.get(i));
        } 
    }//createFloor
    
    public void createElevator(int elevator){
    
    }//createElevator
    
    public int currentFloor(){
        
        // doorOpen;         
        boolean stateEevator = false;
        if ( doorClose == true ){
             int j = s;
             
             doorOpen = true;
             doorClose = false;
              System.out.println("doorClose is on " + s + "th floor ");
        }
               
        else if (doorOpen == true ){
            s = move();
            
             doorClose = true;
             doorOpen = false;
             System.out.println("doorOpen is on  " + s + "th floor. ");
             System.out.println("--------------------------------");
        }
          
      
    
    return s;
    }
    public int move (){
        ++trackingVisitor;
    //floorbank = new FloorBank() ;
        for(int i = 0; i <floorCollection.size(); ++i){
              System.out.println(" this floor collection of :" + floorCollection.get(i));
    }
     
     Random s = new Random();
       move = s.nextInt(setfloor) ;//+ 1;
      // System.out.println(" floorCollection size is :  " + floorbank.getFloorCollection().size());
     System.out.println(" ********* Queue next move is :  " + move);
       
      // for (int i = 0; i < )
     int pickElevator = floorCollection.get(move);
    System.out.println(" Elevator move to :  " + pickElevator); 
       
    return pickElevator; 
    }

    public int getMove() {
        return move;
    }
    
    
}
