class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);

        int res = 1, length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                length++;
            }
            else if (nums[i] != nums[i - 1]) {
                res = Math.max(res, length);
                length = 1;
            }
        }
        res = Math.max(res, length);
        return res;
    }
}