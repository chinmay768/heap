import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

//            double dist = Math.sqrt((x * x) + (y * y));
            int dist = (x * x) + (y * y);

            maxHeap.add(new int[]{dist, i});

            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()){
            int[] point = points[maxHeap.poll()[1]];
            result[i++] = point;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
