package GraphFramework;

import java.util.LinkedList;

public abstract class MSTAlgorithm {
    private Graph graph;
    private LinkedList<Edge> MSTResultList;

    public MSTAlgorithm() {
        this.MSTResultList = new LinkedList<>();
    }
    
    public LinkedList<Edge> getMSTResultList() {
        return this.MSTResultList;
    }

    public Graph getGraph() {
        return this.graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void constructMST(Graph graph) {}
    
    public void displayMSTcost() {}
    
    public void displayResultingMST() {}
}

