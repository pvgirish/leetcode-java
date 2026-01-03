class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        double maxWindowSum = 0;
        int length = nums.length;
        for(int i=0; i<k; i++)
        {
            windowSum += nums[i];
        }
        maxWindowSum = windowSum;
    for(int i=k; i<length; i++){
        windowSum += nums[i] - nums[i-k];
        maxWindowSum = Math.max(maxWindowSum,windowSum);
    }

    return maxWindowSum/k;

    }
}