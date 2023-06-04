package GraphFramework;

public class MHPrimAlg extends MSTAlgorithm {
    private int cost;

    public MHPrimAlg(Graph graph) {
        super();
        super.setGraph(graph);
        this.cost = 0;
    }

    
    @Override
    public void constructMST(Graph graph) {
        MinHeap pq = new MinHeap();

        // start from the first vertex
        Vertex startVertex = (Vertex) graph.vertices.values().toArray()[0];

        for (Edge edge : startVertex.getAdjList()) {
            pq.insert(edge);
        }
        startVertex.setIsVisited(true);

        while (pq.getSize() > 0) {
            Edge edge = pq.remove();

            if (edge.getTarget().getIsVisited()) {
                continue;
            }
            
            getMSTResultList().add(edge);

            for (Edge adjEdge : edge.getTarget().getAdjList()) {
                if (!adjEdge.getTarget().getIsVisited()) {
                    pq.insert(adjEdge);
                }
            }
            edge.getTarget().setIsVisited(true);
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

    @ Override
    public void displayMSTcost() {
        for (Edge edge : getMSTResultList()) {
            cost += edge.getWeight();
        }
	System.out.println("The cost of designed phone network: " + this.cost);
    }
}

