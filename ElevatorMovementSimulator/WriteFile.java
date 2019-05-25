/**
 *
 * @author Soravath Mengseng
 */
package ElevatorMovementSimulator;

import java.io.File;
import java.util.Formatter;


class WriteFile {
    
    private ControllerDemo controller;
    
    private String floor;
    private String elevator;
    private String MaxVisitor;
    private String InitialVisitor;

    public WriteFile(ControllerDemo controller) {
        this.controller = controller;
    }
    
     private Formatter x;
    
    
    public void createDirectory(/*String filePath*/){    
        String pathname = /*filePath;  */ "C:\\Users\\Sarawat\\Desktop\\SaveElevationSimulation";
        File folder = new File(pathname);
        
         try{
             if (folder.exists()){
             System.out.println("Folder " + folder.getName()+ " is already exist.");}
             else{  folder.mkdir();  
             System.out.print("Folder: " + folder.getName() + " was created successfully." );}
             
         }catch(Exception e){
            e.printStackTrace();
         }  
    }
    
    
    public void openFile(){
        try{
              x = new Formatter("C:\\Users\\Sarawat\\Desktop\\SaveElevationSimulation\\chinese.txt");
        }
         catch(Exception e){
             System.out.println("you have an error");
        }
    }
    public void addRecords(){
        x.format("%s %s %s %s", floor, elevator, MaxVisitor, InitialVisitor);
    }
     
    public void closeFile(){
        x.close();
    }

    public void setController(ControllerDemo controller) {
        this.controller = controller;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public void setMaxVisitor(String MaxVisitor) {
        this.MaxVisitor = MaxVisitor;
    }

    public void setInitialVisitor(String InitialVisitor) {
        this.InitialVisitor = InitialVisitor;
    }

    public void setX(Formatter x) {
        this.x = x;
    }
    
    
}
