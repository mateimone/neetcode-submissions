public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> set = new();

        int i = 0;
        foreach (int n in nums) {
            if (set.ContainsKey(n))
                return i < set[n] ? new int[] {i, set[n]} : new int[] {set[n], i};
            set.Add(target-n, i);

            i++;
        }

        // return false;
        return new int[2];
    }
}
