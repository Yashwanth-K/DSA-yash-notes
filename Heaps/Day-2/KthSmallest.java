// Find the kth smallest element in an array

// using a Max-Heap of size k

import java.util.PriorityQueue;
import java.util.Collections;
public class KthSmallest{

    public static int findKthSmallest(int[]arr, int k){
        // Max-Heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int num:arr){
            maxHeap.add(num);
            if(maxHeap.size()>k){
                maxHeap.poll(); //removing element more than size k, so we can find the kth smallest at the root
            }
        }
        return maxHeap.peek(); // The root of the max-heap is the kth smallest element
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int kthSmallest = findKthSmallest(arr, k);
        System.out.println(k + "th smallest element is: " + kthSmallest);
    }
}



