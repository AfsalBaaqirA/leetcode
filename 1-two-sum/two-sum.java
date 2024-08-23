class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(target - nums[i])) {
                int x = i;
                int y = hm.get(target - nums[i]);
                if (x != y) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{};
    }
}