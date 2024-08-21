class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = 1000000;
        int secondBuy = 1000000;
        int firstProfit = 0;
        int secondProfit = 0;

        for (int price : prices) {
            firstBuy = Math.min(firstBuy, price);
            firstProfit = Math.max(firstProfit, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstProfit);
            secondProfit = Math.max(secondProfit, price - secondBuy);
        }
        return secondProfit;
    }
}
