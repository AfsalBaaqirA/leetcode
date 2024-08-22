class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}