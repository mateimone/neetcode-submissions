public class Solution {
    public int LongestConsecutive(int[] nums) {
        if (nums.Length == 0) return 0;
        if (nums.Length == 1) return 1;
        HashSet<int> sequenceStarters = new();
        HashSet<int> allElems = new();

        foreach (int i in nums) {
            allElems.Add(i);
        }

        foreach (int i in allElems) {
            if (!allElems.Contains(i-1)) {
                sequenceStarters.Add(i);
            }
        }

        int maxLength = 1;
        foreach (int seqStarter in sequenceStarters) {
            int currElem = seqStarter;
            int currLength = 1;
            bool finishedSequence = false;
            while (!finishedSequence) {
                if (allElems.Contains(currElem + 1)) {
                    currElem++;
                    currLength++;
                }
                else {
                    finishedSequence = true;
                }
            }
            if (maxLength < currLength) maxLength = currLength;
        }

        return maxLength;
    }
}
