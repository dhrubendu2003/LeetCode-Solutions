class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Count the frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        // Create a sorted list of characters
        List<Character> sortedChars = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                sortedChars.add((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!sortedChars.isEmpty()) {
            // Pick the largest character available
            char current = sortedChars.get(0);
            int count = Math.min(freq[current - 'a'], repeatLimit);

            // Add up to repeatLimit occurrences of current character
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
            freq[current - 'a'] -= count;

            if (freq[current - 'a'] == 0) {
                // Remove the character if no more occurrences are left
                sortedChars.remove(0);
            } else if (sortedChars.size() > 1) {
                // Use the next largest character to break repetition
                char next = sortedChars.get(1);
                result.append(next);
                freq[next - 'a']--;
                if (freq[next - 'a'] == 0) {
                    sortedChars.remove(1);
                }
            } else {
                // No other characters available to break repetition, stop
                break;
            }
        }
        return result.toString();
    }
}
