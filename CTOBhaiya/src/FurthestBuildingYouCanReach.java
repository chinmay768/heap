import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int currIdx = 0;

        while (currIdx < heights.length - 1){
            int heightDiff = heights[currIdx + 1] - heights[currIdx];

            if(heightDiff > 0){
                if(ladders != 0) {
                    minHeap.add(heightDiff);
                    ladders--;
                }else if(!minHeap.isEmpty() && minHeap.peek() > heightDiff && bricks > heightDiff){
                    bricks = bricks - heightDiff;
                }else if(!minHeap.isEmpty() && minHeap.peek() < heightDiff && bricks >= minHeap.peek()){
                    int minLadderHeight = minHeap.poll();
                    bricks -= minLadderHeight;
                    minHeap.add(heightDiff);
                }else if(heightDiff <= bricks){
                    bricks -= heightDiff;
                }else {
                    return currIdx;
                }

            }

            currIdx++;
        }
        return currIdx;
    }

    public static void main(String[] args) {

    }

}
