import java.util.*;

public class KthLargestElementInAnArray {

    // TC: O(NlogN)
    public int findKthLargestNaive(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // K size min heap = top k largest elements
    // TC:
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);

            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
    }
}
