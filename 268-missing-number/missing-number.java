class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Step 1: Place elements at their correct indices (Cycle Sort approach)
        for (int i = 0; i < n; i++) {
            while (nums[i] < n && nums[i] != i) {  // Sanity check and swapping logic
                int d = nums[i]; // Correct index where `nums[i]` should be
                swap(nums, i, d);
            }
        }

        // Step 2: Find the missing number by checking deviants
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;  // The missing number
            }
        }

        return n;  // If all numbers are in place, missing number is `n`
    }

    private void swap(int[] nums, int i, int j) {  // Swap function
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
