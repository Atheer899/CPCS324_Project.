package PhoneNetworkApp;

import GraphFramework.*;

public class Line extends Edge{
    // data field
    private int lLength;
    
    // Line Constructor
    public Line(Vertex source, Vertex target, int weight) {
        super(source, target, weight); // call super
        this.lLength = 5 * weight; // multiply weight by 5
    }

    // Method to print line lenght
    @Override
    public void displayInfo(){
        System.out.print(": line length: " + lLength + "\n"); // print message
    }
    
}
