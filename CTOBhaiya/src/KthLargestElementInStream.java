import java.util.PriorityQueue;

public class KthLargestElementInStream {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargestElementInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size() > k) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }

}
