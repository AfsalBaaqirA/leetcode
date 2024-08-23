class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answerSet = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        if (nums.length < 3) {
            return answer;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // No need to continue if the current number is greater than 0
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    answerSet.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }
        
        answer.addAll(answerSet);
        return answer;
    }
}