package PhoneNetworkApp;

import GraphFramework.*;
import java.io.*;
import java.util.HashMap;


public class BluePrintsGraph extends Graph{
    
    // BluePrintsGraph Constructor
    public BluePrintsGraph(){
        this.verticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        this.vertices = new HashMap<>();
    }
    
    // BluePrintsGraph Constructor
    public BluePrintsGraph(int verticesNo, int edgeNo, boolean isDigraph){
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new HashMap<>();
    }
    
    // Method to create vertex (office)
    @Override
    public Vertex createVertex(String label){
        return new Office(label);
    }
    
    // Method to create an edge (line)
    @Override
    public Edge createEdge(Vertex vertex1, Vertex vertex2, int weight){
        return new Line(vertex1, vertex2, weight);
    }
    
    // Method to add edge (line) to the graph
    @Override
    public Edge addEdge(String v, String u, int w) {
        return super.addEdge(v, u, w); //call super method
    }
    
    // Method to create a random graph
    @Override
    public void makeGraph(int v, int e) {
        super.makeGraph(v, e); // call super method
    }
    
    // Method to read graph from a file
    @Override
    public void readGraphFromFile(File fileName) throws IOException {
        super.readGraphFromFile(fileName); // call super metohd
    }
}
