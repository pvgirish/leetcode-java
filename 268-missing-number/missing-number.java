class Solution {
    public int missingNumber(int[] nums) {

        int array_sum = 0;
        int range_sum = (nums.length * (nums.length+1))/2;
        
        int missing_number=0;

        for ( int i = 0; i < nums.length; i++)
        {
            array_sum += nums[i];
        }
        
        return missing_number = Math.abs(range_sum - array_sum);
    }
}