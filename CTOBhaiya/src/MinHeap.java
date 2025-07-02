import java.util.*;

public class MinHeap {
    private List<Integer> heap ;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Returns the index of the parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the index of the left child node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Returns the index of the right child node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Swaps the elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int value){
        heap.add(value);

        int currIdx = heap.size() - 1;

        while (currIdx > 0 && heap.get(currIdx) > heap.get(parent(currIdx))){
            swap(currIdx, parent(currIdx));
            currIdx = parent(currIdx);
        }
    }

    public int getMin() {
        if(heap.isEmpty()) throw new RuntimeException("Heap is empty!");

        int min = heap.get(0);
        int lastElm = heap.removeLast();

        if(!heap.isEmpty()){
            heap.set(0, lastElm);

            int currIdx = 0;
            while (true) {
                int leftIdx = leftChild(currIdx);
                int rightIdx = rightChild(currIdx);

                int smallestIdx = currIdx;

                if(leftIdx < heap.size() && heap.get(leftIdx) < heap.get(smallestIdx)){
                    smallestIdx = leftIdx;
                }

                if(rightIdx < heap.size() && heap.get(rightIdx) < heap.get(smallestIdx)){
                    smallestIdx = rightIdx;
                }

                if(smallestIdx == currIdx) break;


                swap(smallestIdx, currIdx);
                currIdx = smallestIdx;
            }
        }

        return min;
    }

    public static void minHeapify(List<Integer> arr, int i, int n) {
        // Assume the root is the smallest element initially
        int smallest = i;
        // Calculate the indices of the left and right child of the current node
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Compare the left child with the current smallest
        if (l < n && arr.get(l) < arr.get(smallest))
            smallest = l;

        // Compare the right child with the current smallest
        if (r < n && arr.get(r) < arr.get(smallest))
            smallest = r;

        // If the current node is not the smallest, swap it with the smallest child
        if (smallest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, temp);
            // Recursively heapify the subtree rooted at the smallest child
            minHeapify(arr, smallest, n);
        }
    }

    static void buildHeap(List<Integer> list, int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = list.size() / 2 - 1; i >= 0; i--)
            minHeapify(list, i, list.size());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17);

        buildHeap(list, list.size());

        for (int i = 0; i < list.size(); ++i)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
