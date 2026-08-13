class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) map.put(n, 0);
            else map.put(n, map.get(n)+1);
        }
        Queue<Pair> tops = new PriorityQueue<Pair>((p1,p2) -> Integer.compare(p1.b, p2.b));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (tops.size() >= k) {
                Pair top = tops.peek();
                if (top.b < entry.getValue()) {
                    tops.poll();
                    tops.add(new Pair(entry.getKey(),entry.getValue()));
                }
            }
            else {
                tops.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        int[] res = new int[tops.size()];
        int i = 0;
        while(!tops.isEmpty()) {
            res[i++] = tops.poll().a;
        }
        return res;
    }

}

class Pair {
    int a;
    int b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
