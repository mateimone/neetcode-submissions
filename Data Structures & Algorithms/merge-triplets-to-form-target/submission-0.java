class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] startingTriplet = new int[]{0,0,0};
        for(int[] triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            startingTriplet = combine(triplet, startingTriplet);
        }
        if(startingTriplet[0] == target[0] && 
            startingTriplet[1] == target[1] &&
            startingTriplet[2] == target[2]) return true;
        return false;
    }

    public int[] combine(int[] t1, int[] t2) {
        return new int[]{Math.max(t1[0], t2[0]), Math.max(t1[1], t2[1]), Math.max(t1[2], t2[2])};
    }
}
