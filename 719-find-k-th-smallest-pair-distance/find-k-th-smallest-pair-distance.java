public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countPairsWithDistanceLessThanOrEqual(nums, mid);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    private int countPairsWithDistanceLessThanOrEqual(int[] nums, int mid) {
        int count = 0;
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}
