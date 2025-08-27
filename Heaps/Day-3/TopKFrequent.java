// Top K Frequent Elements (LeetCode 347)

import java.util.*;

public class TopKFrequent{
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // Min-heap by frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Keep only top k frequent elements in heap
        for (int key : map.keySet()) {
            pq.add(new int[] { key, map.get(key) });
            if (pq.size() > k) pq.poll();
        }

        // Extract top k elements from heap
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }  
}