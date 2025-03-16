class Solution {
    public int missingNumber(int[] nums) {
        placeNumbersAtCorrectIndices(nums);  // Step 1: Sort numbers to their correct positions
        return findMissingNumber(nums);      // Step 2: Identify the missing number
    }

    // Step 1: Place elements at their correct indices (Cycle Sort-like approach)
    private void placeNumbersAtCorrectIndices(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] < n && nums[i] != i) {  // Ensure the number is at the correct index
                swap(nums, i, nums[i]);  // Directly use nums[i] instead of storing in a variable
            }
        }
    }

    // Step 2: Find the missing number by checking deviants
    private int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;  // Found the missing number
            }
        }
        return nums.length;  // If all numbers are correctly placed, missing number is `n`
    }

    // Swap function to exchange elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
