class Solution {

    public int missingNumber(int[] nums) {
        sortNumbersInPlace(nums);  // Correct function call

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;  // Return missing number
            }
        }

        return nums.length;  // If all numbers are in place, return `n`
    }

    
    public void sortNumbersInPlace(int[] nums) {  // Renamed for clarity
        int arr_length = nums.length;

        for (int i = 0; i < arr_length; i++) {
            while (nums[i] < arr_length && nums[i] != i) {  // Added boundary check
                swap(nums, i, nums[i]); // Use `nums[i]` instead of `d`
            }
        }
    }

    private void swap(int[] nums, int i, int j) {  // Swap function
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
}
