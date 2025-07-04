import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    // Naive way is to sort store the matrix in a list and sort the list

    // K size max heap = k smallest elms
    // TC: O(m * n * logk)  / SC: O(k)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                maxHeap.add(matrix[i][j]);

                if(maxHeap.size() > k) maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static int countSmallerElements(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;

        int count = 0;
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] <= target) {
                count += col + 1;
                row++;
            }else {
                col--;
            }
        }
        return count;
    }

    public static int kthSmallestOptimal(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int count = countSmallerElements(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 2}, {1, 3}};
        int k = 1;
        int result = kthSmallestOptimal(matrix, k);

        System.out.println(result);
    }
}
