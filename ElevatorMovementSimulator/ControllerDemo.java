/**
 *
 * @author Soravath Mengseng
 */
package ElevatorMovementSimulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// ControllerDemo shoud rename as ControllSimulation
public class ControllerDemo {    
    // data attribute
    private int stopAnimation = 1000;   
    public int floor;
    public int elevator;
    public int maxV;
    public int initV;
    
    private MainFrame mainFrame;
    private SubFrame subFrame;
    private Scenario scenario;
    private WriteFile writeFile;
    private ReadFile readFile;
    
    public void setSubFrame(SubFrame subFrame){
    this.subFrame = subFrame;
    }
    
    public void setMainFrame(MainFrame mainFrame ){
    this.mainFrame = mainFrame;    
    }
    
    public void setScenario(Scenario scenario){
    this.scenario = scenario;    
    }
    
    public void setReadFile(ReadFile readFile ){
        this.readFile = readFile;
    }
    
    public void setWriteFile(WriteFile writeFile) {
        this.writeFile = writeFile;
    }
    
    // constrtuctor
    public ControllerDemo() {
    }
    
    public void loadSimulation() {
       readFile.openFile();
       readFile.readFile();
       readFile.closeFile();
       
       ///////////////
      subFrame.setFloors(readFile.getFloor());
      subFrame.setElevator(readFile.getElevator());
      subFrame.setMaxVisitor(readFile.getMaxfloor());
      subFrame.setInitialVisitor(readFile.getInitialfloor());
      
      
      
      System.out.println( "????????? "+ floor + elevator + maxV + initV );
      subFrame.setVisible(true);
       
    }
    
    public void saveSimulation(){   
        setFloor();
        setElevator();
        setMaxV();
        setInitV() ;   
       
       writeFile.setFloor(String.valueOf(floor));
       writeFile.setElevator(String.valueOf(elevator));
       writeFile.setMaxVisitor(String.valueOf(maxV));
       writeFile.setInitialVisitor(String.valueOf(initV)); 
       
       writeFile.createDirectory();
       writeFile.openFile();
       writeFile.addRecords();
       writeFile.closeFile();
        
    }
    
    public void runAnimation(){
        setFloor();
        setMaxV();
        setInitV();
        scenario.createFloor(floor);//subFrame.getFloors());
       // maxV = subFrame.getMaxVisitor();
        //initV = subFrame.getInitialVisitor();
        scenario.setTrackingVisitor();
        
        //scenario.move();
    
    System.out.println(" Hi, This is Elevator Movement Software. ");
    System.out.println(" the elevator is "+ subFrame.getElevator()
                      +" the floor is "+ floor);//subFrame.getFloors());
    
    
    final JFrame window = new JFrame();
        window.setTitle("Elevator Simulation Test");
        window.setSize(700,450);
        window.setLayout(new BorderLayout());   // seperate window in to region
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton connectionButton = new JButton("Stop");
        JPanel topPanel = new JPanel();
    
        topPanel.add(connectionButton);
        window.add(topPanel, BorderLayout.AFTER_LAST_LINE);        
         
         final XYSeries series = new XYSeries("Elevator on Board");        
         
         XYSeriesCollection dataset = new XYSeriesCollection(series);         
         JFreeChart chart = ChartFactory.createXYLineChart("Elevator Animation", "Time (seconds)", "Floors", dataset);
         chart.setBorderPaint(Color.BLUE);         
         window.add(new ChartPanel(chart),BorderLayout.EAST);         
         
         //configure the connect button and use another thread to listen for data
         connectionButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
           stopAnimation = 100000;
        }
    }) ;

           // @Override
           // public void actionPerformed(ActionEvent ae) {  
         
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                         int valuex = 0;
                        // int disable = maxV - initV;
                         while (scenario.trackingVisitor <= maxV  ){
                        //for (int i = initV ; i <= maxV; i++){
                            
                           //System.out.println("Ihis is visitor in building " + i);
                           System.out.println(" Visitor in building have been boarding  " + scenario.trackingVisitor);
                           String s = Integer.toString(scenario.trackingVisitor);
                          // scenario.getMove();
                           subFrame.showStatus("Visitor in building:            "+s +"\n"+
                                               "Visitor waiting at next queue : " + scenario.getMove()+" th floor.");
                            try {
                               // Random rand = new Random();
                                //int valuex = rand.nextInt(50) + 200 ; //For 1 to 200:
                                valuex = valuex + 6;
                                
                                //int valuey = rand.nextInt(200) +1 ; 
                                //int valuey = 2;
                                     int valuey = scenario.currentFloor();
                                    //int valuey = elevator.currentFloor();
                                     series.add(valuex, valuey);
                                     //System.out.println("This is X axis value :" + valuex + "  This is Y axis value :" + valuey);
                                    window.repaint();                          
                                    Thread.sleep(stopAnimation);                         //1000 milliseconds is one second.
                                  } catch(InterruptedException ex) {
                                  Thread.currentThread().interrupt();
                                  }                         
                           
                        }                        
                    }
                };//thread
              thread.start();
           // } //Override actionPerformed             
            
       // }); 
     window.setVisible(true);
    }

    public void createSubFrame() {
       subFrame.setVisible(true);
    }
    

    public void setMaxV() {
        this.maxV = subFrame.getMaxVisitor();
    }

    public void setInitV() {
        this.initV = subFrame.getInitialVisitor();
    }

    public void setFloor() {
        this.floor = subFrame.getFloors();
        //System.out.println("******THis is number of floor: "+ floor);
    }

    public void setElevator() {
        this.elevator = subFrame.getElevator() ;
        //System.out.println("******THis is number of elevator: "+ elevator);
    }

    
    
    
    
}
