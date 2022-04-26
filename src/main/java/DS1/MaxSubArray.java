package DS1;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = nums[0];
        for(int num: nums){
            if(currSum < 0){
                currSum = 0;
            }
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] a = {-6,-2,-3,-5};
        System.out.println(msa.maxSubArray(a));
    }
}
