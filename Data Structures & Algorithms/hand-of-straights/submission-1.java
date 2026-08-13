class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < hand.length;i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        // Arrays.sort(hand);
        Queue<Integer> q = new PriorityQueue<>();
        for(int n : map.keySet()) {
            q.add(n);
        }
        int size = groupSize;
        while(!q.isEmpty()) {
            int cur, prev = -2;
            int[] removed = new int[groupSize];
            while(size > 0) {
                if(q.isEmpty()) return false;
                cur = q.poll();
                removed[groupSize - size] = cur;
                if(prev != -2 && Math.abs(cur-prev) != 1) {
                    System.out.println(cur);
                    System.out.println(prev);
                    return false;
                }
                size--;
                prev = cur;
            }
            for(int r : removed) {
                int v = map.get(r);
                if(v > 1) {
                    q.add(r);
                }
                map.put(r, v-1);
            }
            System.out.println(q.toString());
            System.out.println(map.toString());
            size = groupSize;
        }

        return true;
    }
}
