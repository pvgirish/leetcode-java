class Solution {
    public int[] findErrorNums(int[] nums) {

        // Step 1: Sort numbers to their correct positions
        placeNumbersAtCorrectIndices(nums);  
        // Step 2: Identify the missing numbers List
        return findMissingNumbers(nums);      
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
    private int[] findMissingNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int count=0;
        for (int i = 0; i < n; i++) { 
            if (nums[i] != i + 1) {
                result.add(nums[i]);
                result.add(i+1);  
            }
        }

     return result.stream().mapToInt(i -> i).toArray();

    }

    // Swap function to exchange elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
