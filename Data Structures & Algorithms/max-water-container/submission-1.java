class Solution {
    public int maxArea(int[] heights) {
        // BiFunction<Integer, Integer, Integer> area = (l, r) -> (r - l) * Math.min(heights[l], heights[r]);
        int l, r;
        l = 0;
        r = heights.length - 1;
        int maximum = Integer.MIN_VALUE;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            maximum = Math.max(maximum, area);
            
            if (heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        
        return maximum;
    }
}
