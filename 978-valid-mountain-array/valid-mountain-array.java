class Solution {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int left = -1;
        int right = -1;

        if(length < 3) return false; 

        for(int i = 0; i < length-1; i++ ) {
            if(arr[i] >= arr[i+1]) {
                left = i;
                break;
            }
        }
        for(int j = length-1; j > 0; j--) {
            if(arr[j] >= arr[j-1]) {
                right = j;
                break;
            }
        }
        if(left == -1 || right == -1) return false;
        else if  (left == 0 || right == length-1) return false;
        else return (left == right);
        
    }
}