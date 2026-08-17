class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int currProfit = 0;
        int index = 0;
        
        for(int i = 1;i < prices.length; i++) {
            currProfit = Math.max(prices[i] - prices[index], currProfit);
            if (prices[index] > prices[i]) {
                index = i;
                // i += 1;
            }
        }

        return currProfit;
    }
}
