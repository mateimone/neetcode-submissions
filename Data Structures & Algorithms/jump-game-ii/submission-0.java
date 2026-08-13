class Solution {
    public int jump(int[] nums) {
        int res, l, r;
        res = l = r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l;i < r + 1;i++) {
                farthest = Integer.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res += 1;
        }
        return res;
    }
}
