class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int low = 0; 
        int high = letters.length-1;
        int mid =0;

        while(low <= high)
        {
            mid = low + (high-low)/2;
            

            if(letters[mid] <= target)
            low = mid+1;

            else
            high = mid-1;
             
        }
    
    return (low < letters.length) ? letters[low] : letters[0];
        
    }
}