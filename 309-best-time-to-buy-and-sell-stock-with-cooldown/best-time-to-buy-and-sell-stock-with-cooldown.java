class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];
        hold[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = hold[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }
}
