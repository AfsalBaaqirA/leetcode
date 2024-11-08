class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] arr = new int[n];
        int[] ans = new int[n];

        arr[0]=nums[0];
        for(int i = 1; i < n; i++){
            arr[i] = arr[i-1] ^ nums[i];
        }

        int val = (int) Math.pow(2, maximumBit) - 1;
        int k = 0;
        for(int i = n-1; i >= 0; i--){
            ans[k++] = arr[i] ^ val;
        }
        return ans;
    }
}