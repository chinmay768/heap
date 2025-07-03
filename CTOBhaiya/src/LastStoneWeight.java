import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(x != y){
                maxHeap.add(y - x);
            }
        }

        return maxHeap.size() == 1? maxHeap.peek() : 0;
    }

}
