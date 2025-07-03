import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TheKWeakestRowsInMatrix {

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int soldiersCount = 0;
            for (int j = 0; j < mat[i].length; j++) { // Can use Binary Search for this
                if (mat[i][j] == 1) soldiersCount++;
            }
            freqMap.put(i, soldiersCount);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            int res = freqMap.get(a) - freqMap.get(b);
            return res != 0 ? res : a - b;
        });

        for (int i = 0; i < mat.length; i++) {
            minHeap.add(i);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        int k = 3;

        System.out.println(Arrays.toString(kWeakestRows(matrix, k)));
    }
}