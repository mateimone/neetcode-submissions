class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)->Integer.compare(a,b));
        int a = 0;
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                a = pq.poll();
            }
        }

        return pq.poll();
    }
}
