class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        for(int s : stones) pq.add(s);

        while(!pq.isEmpty()) {
            int s1 = pq.poll();
            if (pq.isEmpty()) return s1;
            int s2 = pq.poll();
            if (s1 < s2) pq.add(s2-s1);
            else if (s2 < s1) pq.add(s1-s2);
        }
        
        return 0;
    }
}
