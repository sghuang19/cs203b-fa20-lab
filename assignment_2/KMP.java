package assignment_2;

import java.util.LinkedList;

/**
 * By implementing KMP algorithm, for a given text S and pattern P, obtain how
 * many times the P appears in S and the locations.
 */
public class KMP {
    /**
     * Calculate the next array of pattern P
     *
     * @param pattern the input pattern that is to be searched in the text
     * @return the KMP next array of the pattern
     */
    public static int[] computeNextArray(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int j = 0;
        for (int i = 2; i < pattern.length(); i++) {
            while (pattern.charAt(i - 1) != pattern.charAt(j) && next[j] != -1)
                j = next[j];
            if (pattern.charAt(i - 1) == pattern.charAt(j))
                next[i] = ++j;
        }
        return next;
    }

    /**
     * Utilizing the next array obtained in problem 1 to calculate how many times
     * does P appear in S
     *
     * @param text    the text in which is pattern is searched
     * @param pattern the input pattern that is to be searched in the text
     * @return the times the pattern appears in the text
     */
    public static int KMPSearchTimes(String text, String pattern) {
        LinkedList<Integer> locations = KMPFindLocations(text, pattern);
        return (locations.get(0) == -1) ? 0 : locations.size();
    }

    /**
     * Calculate the position where P appears in S, utilizing the next array
     * implemented in the first problem
     * 
     * @param text    the text in which is pattern is searched
     * @param pattern the input pattern that is to be searched in the text
     * @return the position where P appears in S, the return value is the index of
     *         the first common character, started with 0.
     */
    public static LinkedList<Integer> KMPFindLocations(String text, String pattern) {
        LinkedList<Integer> locations = new LinkedList<Integer>();
        locations.add(-1);
        int[] next = computeNextArray(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            try {
                while (text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                }
            } catch (StringIndexOutOfBoundsException ignored) {
                // out of bounds, judge
                // if j out of bounds, a valid match
                if (j == pattern.length()) {
                    locations.add(i -= pattern.length());
                    j = 0;
                } else
                    // i out of bounds,, searching ends
                    break;
            }

            // if the first character is not a match, go on
            if (j == 0)
                i++;
            // otherwise, go back to find longest matched prefix and suffix
            else
                j = next[j];
        }

        if (locations.size() != 1)
            locations.remove(0);
        return locations;
    }
}
