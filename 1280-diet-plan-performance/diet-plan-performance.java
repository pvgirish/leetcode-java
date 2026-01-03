class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int length = calories.length;
        int T =0;
        int points = 0;

        for(int i=0; i < k; i++) {
            T += calories[i];
        }
        
        if(T < lower) points--;
        else if(T > upper) points++;

        for(int i=k; i < length; i++) {
            T += calories[i];
            T -=calories[i-k];
            if(T < lower) points--;
            else if(T > upper) points++;
        }



        return points;
    }
}