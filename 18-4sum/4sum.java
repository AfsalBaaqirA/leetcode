class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSumHelper(nums, (long) target, 4, 0);
    }

    private List<List<Integer>> kSumHelper(int[] nums, long target, int k, int start) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (k == 2) {
            // Base case: 2-sum problem
            int left = start, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        } 
        else {
            // Recursive case: reduce k-sum to (k-1)-sum
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue; // Skip duplicates
                }
                List<List<Integer>> subResults = kSumHelper(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> subResult : subResults) {
                    List<Integer> newResult = new ArrayList<>(subResult);
                    newResult.add(0, nums[i]);
                    result.add(newResult);
                }
            }
        }
        
        return result;
    }
}