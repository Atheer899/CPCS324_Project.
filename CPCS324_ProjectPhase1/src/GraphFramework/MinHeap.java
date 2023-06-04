package GraphFramework;
import java.util.ArrayList;

public class MinHeap {
    
public ArrayList<Edge> Heap;

    public MinHeap() {
        Heap = new ArrayList<>();
        Heap.add(new Edge(new Vertex("Dummy"), new Vertex("Dummy"), Integer.MIN_VALUE)); // Dummy Edge at index 0
    }

    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos) { return (2 * pos) + 1; }

    private boolean isLeaf(int pos) { return pos > (Heap.size() / 2) && pos <= Heap.size(); }

    private void swap(int fpos, int spos) {
        Edge tmp = Heap.get(fpos);
        Heap.set(fpos, Heap.get(spos));
        Heap.set(spos, tmp);
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if ((leftChild(pos) < Heap.size() && Heap.get(pos).getWeight() > Heap.get(leftChild(pos)).getWeight())
                    || (rightChild(pos) < Heap.size() && Heap.get(pos).getWeight() > Heap.get(rightChild(pos)).getWeight())) {

                if (rightChild(pos) >= Heap.size() || Heap.get(leftChild(pos)).getWeight() < Heap.get(rightChild(pos)).getWeight()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(Edge element) {
        Heap.add(element);
        int current = Heap.size() - 1;

        while (Heap.get(current).getWeight() < Heap.get(parent(current)).getWeight()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Edge remove() {
        Edge popped = Heap.get(1);
        Heap.set(1, Heap.get(Heap.size() - 1));
        Heap.remove(Heap.size() - 1);
        minHeapify(1);
        return popped;
    }

    public int getSize() {
        return Heap.size() - 1; // -1 because of the dummy edge
    }
}

