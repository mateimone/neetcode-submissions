class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]); 
        int[] dp = new int[cost.length+1];
        dp[1] = cost[0];
        dp[2] = cost[1];

        for(int i = 3;i <= cost.length;i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i-1];
        }

        return Math.min(dp[cost.length], dp[cost.length-1]);
    }
}
