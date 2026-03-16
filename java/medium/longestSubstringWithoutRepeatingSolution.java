/** Longest Substring Without Repeating Characters
 * Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Idea:
 *  The main idea was to iterate through the characters of the string while keeping track of the current substring without repeating characters. Whenever a duplicate character appeared, I updated the tracked characters and the maximum length found so far.
 * 
 * Complexity: O(n)
 */

package medium;

import java.util.HashMap;

public class longestSubstringWithoutRepeatingSolution {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> characters = new HashMap<>();

        for (int rigth = 0 ; rigth < s.length() ; rigth++) {
            Character current = s.charAt(rigth);

            if (characters.containsKey(current) && characters.get(current) >= left) {
                left = characters.get(current) + 1;
            }

            characters.put(current, rigth);
            maxLength = Math.max(maxLength, (rigth - left + 1));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Result 2: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Result 3: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("Result 4: " + lengthOfLongestSubstring("aab"));
        System.out.println("Result 5: " + lengthOfLongestSubstring(""));
    }
}
