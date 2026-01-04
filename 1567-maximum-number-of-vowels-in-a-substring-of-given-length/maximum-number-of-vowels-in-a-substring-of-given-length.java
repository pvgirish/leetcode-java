class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int vowels = 0;
        int maxVowels = 0;
        int length = s.length();

        for(int i=0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                vowels++;
            }
        }
        maxVowels = vowels;

        for(int i =k; i < length; i++) {
            if(isVowel(s.charAt(i))) {
                vowels++;
            }
            if(isVowel(s.charAt(i-k))) {
                vowels--;
            }

            maxVowels = Math.max(vowels,maxVowels);
        }

        return maxVowels;
    }
}