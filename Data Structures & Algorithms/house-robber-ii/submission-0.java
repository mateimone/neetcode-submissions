class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp_first = new int[nums.length];
        int[] dp_last = new int[nums.length];
        dp_first[1] = nums[0];
        dp_last[1] = nums[1];

        for(int i = 2;i <= nums.length-1;i++) {
            // dp_[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
            dp_first[i] = Math.max(dp_first[i-2] + nums[i-1], dp_first[i-1]);
            dp_last[i] = Math.max(dp_last[i-2] + nums[i], dp_last[i-1]);
        }

        return Math.max(dp_first[nums.length-1], dp_last[nums.length-1]);
    }
}
