class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int baseSatisfied = 0;
        int length = customers.length;

        for(int i=0; i < length; i++) {
            if(grumpy[i]==0) {
                baseSatisfied += customers[i];
            }
        }
        
        int extraSatisfied=0;
        int bestExtraSatisfied=0;

        for(int i = 0; i < minutes;i++) {
             if(grumpy[i]==1) {
                extraSatisfied += customers[i];
             }
           }

        bestExtraSatisfied = extraSatisfied;

        for(int i=minutes; i < length; i++) {
            if(grumpy[i] == 1)
            extraSatisfied += customers[i];
            if(grumpy[i-minutes] == 1)
            extraSatisfied -= customers[i-minutes];
            bestExtraSatisfied = Math.max(extraSatisfied, bestExtraSatisfied );
        }
             

         return bestExtraSatisfied+baseSatisfied ;     
        }

       
       
}

