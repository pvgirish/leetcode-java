class Solution {
    public int findDuplicate(int[] nums) {

        // Step 1: Sort numbers to their correct positions
        placeNumbersAtCorrectIndices(nums);  
        // Step 2: Identify the missing numbers List
        return findDuplicateNumber(nums);      
    }

    /* Step 1: Place elements at their correct indices (Cycle Sort-like approach) */
    private void placeNumbersAtCorrectIndices(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Ensure the number is within valid bounds BEFORE accessing nums[nums[i] - 1]
            while (nums[i] <= n && nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;

                // Additional check to prevent out-of-bounds before accessing nums[correctIndex]
                if (correctIndex < n && nums[correctIndex] != nums[i]) {
                    swap(nums, i, correctIndex);
                } else break;
            }
        }
    }

    // Step 2: Find the missing numbers by checking deviants
    private int findDuplicateNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {  // Fix: Correct range should be `i < n`
            if (nums[i] != i + 1) {
                return nums[i];  // Fix: Add missing index + 1, not `nums[i]`
            }
        }
        return 0;  
    }

    // Swap function to exchange elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
