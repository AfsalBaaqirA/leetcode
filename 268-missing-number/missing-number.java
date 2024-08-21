class Solution {
    public int missingNumber(int[] nums) {
        // // Approach 1
        // Arrays.sort(nums);
        // int left = 0, right = nums.length;
        // while (left < right) {
        //     int mid = left + (right - left) / 2;
        //     if (nums[mid] > mid) {
        //         right = mid;
        //     } else {
        //         left = mid + 1;
        //     }
        // }
        // return left;
        // // Approach 2
        // int i;
        // for (i = 0; i < nums.length; i++) {
        //     if (i != nums[i]){
        //         return i;
        //     }
        // }
        // return i;
        // // Approach 3
        // int xor = 0;
        // int i;
        // for (i = 0; i < nums.length; i++) {
        //     xor ^= i ^ nums[i];
        // }
        // return xor ^ i;
        // // Approach 4
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }
}
