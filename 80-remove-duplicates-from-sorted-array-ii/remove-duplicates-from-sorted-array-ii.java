class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1, occ = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
                occ = 1;
            }
            else {
                if (occ < 2) {
                    nums[k] = nums[i];
                    k++;
                    occ++;
                }
            }
        }
        return k;    
    }
}