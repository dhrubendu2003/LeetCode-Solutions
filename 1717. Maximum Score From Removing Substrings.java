class Solution {
    public int maximumGain(String s, int x, int y) {
        String firstPair = x > y ? "ab" : "ba";
        int firstPoints = Math.max(x, y);
        String secondPair = x > y ? "ba" : "ab";
        int secondPoints = Math.min(x, y);

        // Calculate the points for the first operation
        int points = calculatePoints(s, firstPair, firstPoints);

        // After removing the first pair, calculate for the second
        String remainingString = removePair(s, firstPair);
        points += calculatePoints(remainingString, secondPair, secondPoints);

        return points;
    }

    private int calculatePoints(String s, String pair, int pointsPerPair) {
        Stack<Character> stack = new Stack<>();
        int points = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == pair.charAt(0) && c == pair.charAt(1)) {
                stack.pop(); // Remove the pair
                points += pointsPerPair; // Add points
            } else {
                stack.push(c);
            }
        }
        return points;
    }

    private String removePair(String s, String pair) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == pair.charAt(0) && c == pair.charAt(1)) {
                stack.pop(); // Remove the pair
            } else {
                stack.push(c);
            }
        }

        // Reconstruct the remaining string
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
