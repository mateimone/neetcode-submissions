class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];
        for (int i : nums) {
            int prevFreq = freqMap.getOrDefault(i, 0);
            freqMap.put(i, prevFreq + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (freqs[entry.getValue()] == null)
                freqs[entry.getValue()] = new ArrayList<>();
            freqs[entry.getValue()].add(entry.getKey());
        }

        int[] topK = new int[k];
        int count = 0;
        for (int i = freqs.length-1; i > 0; i--) {
            if (freqs[i] == null) continue;
            for (int element : freqs[i]) {
                topK[count++] = element;
            }
            if (count == k) {
                return topK;
            }
        }

        return new int[] {};
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
