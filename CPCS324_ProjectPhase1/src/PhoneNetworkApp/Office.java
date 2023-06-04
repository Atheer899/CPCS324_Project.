
package PhoneNetworkApp;

import GraphFramework.*;

public class Office extends Vertex{

    // Office constructor
    public Office(String label) {
        super(label);     
    }
    
    // method to print office number
    @Override
    public void displayInfo(){
        System.out.print("Office No." + getLabel());
    }
}
