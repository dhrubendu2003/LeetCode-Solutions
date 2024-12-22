class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }

        // Check character counts
        int countLStart = 0, countRStart = 0;
        int countLTarget = 0, countRTarget = 0;

        for (char c : start.toCharArray()) {
            if (c == 'L') countLStart++;
            else if (c == 'R') countRStart++;
        }

        for (char c : target.toCharArray()) {
            if (c == 'L') countLTarget++;
            else if (c == 'R') countRTarget++;
        }

        // If counts don't match, return false
        if (countLStart != countLTarget || countRStart != countRTarget) {
            return false;
        }

        int n = start.length();
        int posStart = 0, posTarget = 0;

        while (posStart < n && posTarget < n) {
            // Find next non-underscore character in start
            while (posStart < n && start.charAt(posStart) == '_') {
                posStart++;
            }
            // Find next non-underscore character in target
            while (posTarget < n && target.charAt(posTarget) == '_') {
                posTarget++;
            }

            if (posStart == n && posTarget == n) {
                return true;
            }

            // If one pointer reaches the end but not the other, return false
            if (posStart == n || posTarget == n) {
                return false;
            }

            // Check characters at current positions
            char charStart = start.charAt(posStart);
            char charTarget = target.charAt(posTarget);

            if (charStart != charTarget) {
                return false;
            }

            if (charStart == 'L' && posStart < posTarget) {
                return false; // L cannot move right
            }
            if (charStart == 'R' && posStart > posTarget) {
                return false; // R cannot move left
            }

            // Move to next characters
            posStart++;
            posTarget++;
        }

        return true;
    }
}
