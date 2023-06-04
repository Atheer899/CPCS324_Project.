package GraphFramework;

import java.util.*;

public class KruskalAlg extends MSTAlgorithm {
    
    private int cost;
    
    public KruskalAlg(Graph graph) {
        super();
        super.setGraph(graph);
        this.cost = 0;
    }

    @Override
    public void constructMST(Graph graph) {
        HashMap<String, Vertex> parent = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();
        List<Edge> edges = new ArrayList<Edge>();

        // add all edges to the arrayList
        for (Map.Entry<String, Vertex> vertex : graph.vertices.entrySet()) { 
            for(Edge edge : vertex.getValue().getAdjList()){
                parent.put(vertex.getValue().getLabel(), vertex.getValue());
                rank.put(vertex.getValue().getLabel(), edge.getWeight());
                edges.add(edge);
            }
        }

        for (Edge edge : edges) {
            Vertex x = find(parent, edge.getSource().getLabel());
            Vertex y = find(parent, edge.getTarget().getLabel());

            if (x != y) {
                getMSTResultList().add(edge);
                union(parent, rank, x.getLabel(), y.getLabel());
            }
        }
    }

    public Vertex find(HashMap<String, Vertex> parent, String i) {
        if (parent.get(i).getLabel().equals(i)) {
            return parent.get(i);
        }
        return find(parent, parent.get(i).getLabel());
    }

    public void union(HashMap<String, Vertex> parent, HashMap<String, Integer> rank, String x, String y) {
        Vertex xroot = find(parent, x);
        Vertex yroot = find(parent, y);

        if (rank.get(xroot.getLabel()) < rank.get(yroot.getLabel())) {
            parent.put(xroot.getLabel(), yroot);
        } else if (rank.get(xroot.getLabel()) > rank.get(yroot.getLabel())) {
            parent.put(yroot.getLabel(), xroot);
        } else {
            parent.put(yroot.getLabel(), xroot);
            rank.put(xroot.getLabel(), rank.get(xroot.getLabel()) + 1);
        }
    }

    @Override
    public void displayResultingMST() {
        for (Edge edge : getMSTResultList()) {
            edge.getSource().displayInfo();
            System.out.print(" - ");
            edge.getTarget().displayInfo();
            edge.displayInfo();
        }
    }
    
    @Override
    public void displayMSTcost() {
        for (Edge edge : getMSTResultList()) {
            cost += edge.getWeight();
        }
	System.out.println("The cost of designed phone network: " + this.cost);
    }
}