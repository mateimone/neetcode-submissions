class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n-1]) return nums[0];

        // BiFunction<int, int, int> middle = (l, r) -> (l + (r-l)/2);
        int l = 0, r = n-1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        return nums[l];
    }
}


// 123456
// 612345
// 561234


// 456123


// 345612
// 234561

// 123456



// 4 > 3
// 5 > 2
// 6 > 1






















// public int findMin(int[] nums) {
//         int left = 0, right = nums.length-1;

//         if (nums[left] < nums[right]) return nums[left];

//         while (left < right) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] > nums[right]) {
//                 left = mid + 1;
//             }
//             else {
//                 right = mid;
//             }
//         }

//         return nums[left];
//     }
