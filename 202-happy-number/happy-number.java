class Solution {
    public boolean isHappy(int n) {
        int hare = n, tortoise = n;
        
        while (true) {
            tortoise = happyFunction(tortoise);        // Move tortoise one step
            hare = happyFunction(happyFunction(hare)); // Move hare two steps

            if (hare == 1) return true; // If we reach 1, it's a happy number
            if (hare == tortoise) return false; // If cycle detected, not a happy number
        }
    }

    int happyFunction(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;  // Extract last digit
            sum += digit * digit; // Square and add to sum
            n /= 10;  // Remove last digit
        }
        return sum;
    }
}