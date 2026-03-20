/** Longest Palindromic Substring
 * Problem link: https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Idea:
 *  The idea was to iterate through the characters of the string and check whether each generated substring was a palindrome, saving it until a longer palindromic substring was found.
 * 
 * Complexity: O(n ^ 2)
 */

package medium;

public class longestPalindromicSubstringSolution {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        int start = 0;
        int maxLen = 1;

        for (int i = 0 ; i < s.length() ; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + longestPalindrome("babad"));
        System.out.println("Result 2: " + longestPalindrome("abbab"));
        System.out.println("Result 3: " + longestPalindrome("aabbb"));
    }
}
