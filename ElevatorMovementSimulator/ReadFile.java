/**
 *
 * @author Soravath Mengseng
 */
package ElevatorMovementSimulator;

import java.io.File;
import java.util.Scanner;


class ReadFile {
    
     private ControllerDemo controller;
     private Scanner x;
     private String floor  ;
     private String elevator  ;
     private String maxfloor  ;
     private String initialfloor ;

    public ReadFile(ControllerDemo controller) {
        this.controller = controller;
    }
    
    
    
    public void openFile(){
        try {
          x = new Scanner (new File("C:\\Users\\Sarawat\\Desktop\\SaveElevationSimulation\\chinese.txt"));
        } catch(Exception e){
          System.out.println(" could not fine the file.");
        }
    }
    
    public void readFile(){
        while(x.hasNext()){
            floor = x.next();
            elevator = x.next();
            maxfloor = x.next();
            initialfloor = x.next();
            
            //floor = Integer.valueOf(a);
           /// elevator = Integer.valueOf(b);
           // maxfloor = Integer.valueOf(c);
            //initialfloor = Integer.valueOf(d);
            
            
            
           
            
            //System.out.printf("%s %s %s %s", a, b, c, d);
        }    
    }
    
    public void closeFile(){
       x.close();
    }

    public String getFloor() {
        return floor;
    }

    public String getElevator() {
        return elevator;
    }

    public String getMaxfloor() {
        return maxfloor;
    }

    public String getInitialfloor() {
        return initialfloor;
    }

   
    
}
