class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int l = 0, maxProfit = 0;
        for (int r = 1; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
            else {
                l = r;
            }
        }
        return maxProfit;
    }
}
