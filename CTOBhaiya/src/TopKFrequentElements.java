import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pqMinHeap.add(entry.getKey());

            if(pqMinHeap.size() > k) pqMinHeap.poll();
        }

        int[] result = new int[k];
        int idx = 0;
        while (!pqMinHeap.isEmpty()){
            result[idx++] = pqMinHeap.poll();
        }

        return result;
    }

    public int[] topKFrequentStream(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
