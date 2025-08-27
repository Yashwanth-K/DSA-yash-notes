// K Closest Points to Target (LeetCode 973)

import java.util.*;

public class KClosestToTarget {
    public int[][] kClosest(int[][] points, int[] target, int k) {
        // Min-heap based on distance to target
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int distA = (a[0] - target[0]) * (a[0] - target[0]) + (a[1] - target[1]) * (a[1] - target[1]);
            int distB = (b[0] - target[0]) * (b[0] - target[0]) + (b[1] - target[1]) * (b[1] - target[1]);
            return distA - distB;
        });

        // Add all points to the min-heap
        for (int[] point : points) {
            minHeap.add(point);
        }

        // Extract the k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
