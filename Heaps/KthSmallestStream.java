
// having iInitial array, and then we'll keep adding and 
// simultaneously finding the kth smaller statement. 

import java.util.PriorityQueue;
import java.util.Collections;

public class KthSmallestStream{
    PriorityQueue<Integer> maxHeap;
    int k;

    // Constructor to initialize the stream with k and initial array
    public KthSmallestStream(int k, int[] initialArray){
        this.k=k;
        maxHeap = new PriorityQueue<>(k,Collections.reverseOrder());
        for(int num:initialArray){
            add(num);
        }
    }

    // Add a new number to the stream and return the kth smallest element
    public int add(int num){
        maxHeap.add(num);
        if(maxHeap.size()>k){
            maxHeap.poll(); //removing element more than size k, so we can find the kth smallest at the root
        }
        return maxHeap.peek(); // The root of the max-heap is the kth smallest element
    }
    public static void main(String[] args) {
        int[] initialArray = {7, 10, 4, 3, 20, 15};
        int k = 3;
        KthSmallestStream stream = new KthSmallestStream(k, initialArray);
        System.out.println(k + "th smallest element is: " + stream.add(5)); // Should print 5
        System.out.println(k + "th smallest element is: " + stream.add(2)); // Should print 4
        System.out.println(k + "th smallest element is: " + stream.add(1)); // Should print 5
    }
}