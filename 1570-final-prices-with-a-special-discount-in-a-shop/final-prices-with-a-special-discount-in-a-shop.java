class Solution {
    public int[] finalPrices(int[] prices) {
        int size = prices.length;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(prices[j]<=prices[i]){
                    prices[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}