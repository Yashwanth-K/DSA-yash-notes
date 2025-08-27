// Top K Frequent Words (LeetCode 692)

import java.util.*;
public class TopKFrequentWord {
    public String[] topKFrequent(String[] words, int k) {
        // freq
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Min-heap first by frequency then by lexicographical order
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b.compareTo(a); // Higher lexicographical order comes first
            }
            return map.get(a) - map.get(b); // Lower frequency comes first
        });

        // Keep only top k frequent words in heap
        for (String key : map.keySet()) {
            minHeap.add(key); // Only word is added in min-heap and it compares with freq using maps
            if (minHeap.size() > k) minHeap.poll();
        }

        // Extract top k words from heap
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ansList.add(minHeap.poll());
        }
        Collections.reverse(ansList);

        String[] ans = ansList.toArray(new String[k]);
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentWord solution = new TopKFrequentWord();
        String[] words = {"i", "love", "leetcode", "i", "coding"};
        int k = 2;
        String[] result = solution.topKFrequent(words, k);
        System.out.println(Arrays.toString(result)); // Output: ["i", "love"]
    }
}


