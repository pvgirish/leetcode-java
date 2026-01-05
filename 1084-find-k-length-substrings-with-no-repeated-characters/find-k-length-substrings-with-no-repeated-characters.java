class Solution {

    public boolean isPresent(Map<Character, Integer> characters, char c) {
        return characters.getOrDefault(c, 0) > 0;
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        int length = s.length();
        if (k > length) return 0;

        Map<Character, Integer> characters = new HashMap<>();
        int numberOfSubstrings = 0;
        int duplicates = 0;

        // ---- first window ----
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            int count = characters.getOrDefault(c, 0);
            if (count == 1) {
                duplicates++;
            }
            characters.put(c, count + 1);
        }

        if (duplicates == 0) {
            numberOfSubstrings++;
        }

        // ---- sliding window ----
        for (int i = k; i < length; i++) {

            // add incoming
            char in = s.charAt(i);
            int inCount = characters.getOrDefault(in, 0);
            if (inCount == 1) {
                duplicates++;
            }
            characters.put(in, inCount + 1);

            // remove outgoing
            char out = s.charAt(i - k);
            int outCount = characters.get(out);
            if (outCount == 2) {
                duplicates--;     // duplicate resolved
            }

            if (outCount == 1) {
                characters.remove(out);
            } else {
                characters.put(out, outCount - 1);
            }

            if (duplicates == 0) {
                numberOfSubstrings++;
            }
        }

        return numberOfSubstrings;
    }
}