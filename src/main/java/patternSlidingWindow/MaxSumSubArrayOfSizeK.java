package patternSlidingWindow;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowStart=0, maxSum = 0, windowSum=0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            windowSum+=arr[windowEnd];
            if(windowEnd>=k-1){
                maxSum=windowSum>maxSum?windowSum:maxSum;
                windowSum-=arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
