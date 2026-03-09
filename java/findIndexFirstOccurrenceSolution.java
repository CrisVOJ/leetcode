/** Find the Index of the First Occurrence in a String
 * Problem link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 
 * Idea:
 *  First, I need to check whether haystack contains needle in order to start the process of finding the index. Otherwise, I simply return -1. Later, I discovered that Java already has a built-in method for this.
 * 
 * Complexity: O(n * m)
 */
public class findIndexFirstOccurrenceSolution {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

        // if (haystack.contains(needle)) {
        //     for (int i = 0 ; i < haystack.length() ; i++) {
        //         if (haystack.charAt(i) == needle.charAt(0)) {
        //             for (int j = 1 ; j < needle.length() ; j++) {
        //                 if (haystack.charAt(i + j) != haystack.charAt(j)) {
        //                     break;
        //                 }

        //                 if (j == (needle.length() - 1)) {
        //                     return i;
        //                 }
        //             }
        //         }
        //     }
        // }

        // return -1;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + strStr("sadbutsad", "sad"));
        System.out.println("Result 2: " + strStr("leetcode", "leeto"));
    }
}
