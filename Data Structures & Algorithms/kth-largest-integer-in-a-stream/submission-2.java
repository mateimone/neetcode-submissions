class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            this.heap.offer(n);
            if (this.heap.size() > k) {
                this.heap.poll();
            }
        }
    }
    
    public int add(int val) {
        if (this.heap.isEmpty()) {
            this.heap.offer(val);
            return val;
        }
        else if (this.heap.size() < this.k) {
            this.heap.offer(val);
            return this.heap.peek();
        }

        int top = this.heap.peek();
        if (val < top)
            return top;
        
        this.heap.poll();
        this.heap.offer(val);
        return this.heap.peek();
    }
}
