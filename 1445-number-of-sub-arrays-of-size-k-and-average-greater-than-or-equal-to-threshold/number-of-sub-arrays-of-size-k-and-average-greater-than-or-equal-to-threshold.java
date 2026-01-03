class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

    int count = 0;
    double windowSum = 0;
    int length = arr.length;
    for(int i=0; i<k; i++)
    {
        windowSum += arr[i];
    }
    if(windowSum/k >= threshold) count++;
    
    for(int i=k; i<length; i++){
        windowSum += arr[i] - arr[i-k];
        if(windowSum/k >= threshold) count++;

    }

    return count;

    }
    
}