public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int n = nums.Length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] res = new int[n];

        pref[0] = 1;
        suff[n-1] = 1;

        int zeroCount = 0;
        int zeroIndex = 0;
        if (nums[0] == 0) zeroCount++;

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i-1] * nums[i-1];
            if (nums[i] == 0 && zeroCount == 1) {
                return new int[n];
            }
            else if (nums[i] == 0) {
                zeroIndex = i;
                zeroCount++;
            }
        }

        if (zeroCount == 1) {
            int prod = pref[zeroIndex];
            
            for (int i = zeroIndex+1; i < nums.Length;i++) {
                prod *= nums[i];
            }

            res[zeroIndex] = prod;
            return res;
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}
