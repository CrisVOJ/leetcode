/** Valid Palindrome
 * Problem link: https://leetcode.com/problems/valid-palindrome/
 * 
 * Idea:
 *  The main idea of my solution was to create a new string containing only the alphanumeric characters from the input string, converting them to lowercase. 
 *  I iterated through each character of the original string, checked if it was alphanumeric using Character.isAlphabetic() and Character.isDigit(), and appended the lowercase version to a StringBuilder if it was valid. 
 *  Finally, I compared the cleaned string with its reversed version to determine if it is a palindrome.
 * 
 * Complexity: O(n^2)
 * 
 */

package easy;

public class validPalindromeSolution {
    public static boolean isPalindrome(String s) {
        StringBuilder newString = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                newString.append(s.charAt(i));
            }
        }

        if (!newString.toString().toLowerCase().equals(newString.reverse().toString().toLowerCase())) return false;

        return true;
    }

/**
 * Optimal approach: 
 *  The optimal solution uses two pointers to verify the palindrome property in a single pass. 
 *  We move one pointer from the start and another from the end, skipping non-alphanumeric characters. 
 *  For each pair of alphanumeric characters found, we compare their lowercase versions. 
 *  If any pair doesn't match, we return false. 
 *  This achieves O(n) time and O(1) space by avoiding the creation of any auxiliary string.
 */

    public static boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

                left ++;
                right --;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Result 1 v1: " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Result 2 v1: " + isPalindrome("race a car"));
        System.out.println("Result 3 v1: " + isPalindrome(" "));

        System.out.println("Result 1 v2: " + isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println("Result 2 v2: " + isPalindrome2("race a car"));
        System.out.println("Result 3 v2: " + isPalindrome2(" "));
    }
}
