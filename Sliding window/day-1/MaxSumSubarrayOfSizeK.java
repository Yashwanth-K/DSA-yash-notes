public class MaxSumSubarrayOfSizeK {
    
    public int findMaxSum(int[] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            //
            windowSum += arr[windowEnd]; // add the next element

            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if(windowEnd >= k-1){
                maxSum = Math.max(maxSum, windowSum); // update maxSum if needed
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaxSumSubarrayOfSizeK mss = new MaxSumSubarrayOfSizeK();
        int[] arr = {2,1,5,1,1,2};
        int k = 3;
        System.out.println(mss.findMaxSum(arr, k));
    }
}
