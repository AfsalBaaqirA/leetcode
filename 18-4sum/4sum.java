class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSumHelper(nums, (long) target, 4, 0);
    }

    private List<List<Integer>> kSumHelper(int[] nums, long target, int k, int start) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                long sum = (long) nums[l] + nums[r];
                if (sum == target) {
                    result.add(Arrays.asList(nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } 
                else if (sum < target) {
                    l++;
                } 
                else {
                    r--;
                }
            }
        } 
        else {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
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