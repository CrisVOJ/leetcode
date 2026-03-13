package easy;
/** Length of Last Word
 * Problem link: https://leetcode.com/problems/length-of-last-word/
 * 
 * Idea:
 *  The idea was to split all the words in the string into a list, then get the last word and return its length.
 * 
 * Complexity: O(n)
 */
public class lengthLastWordSolution {
    public static int lengthOfLastWord(String s) {
        s = s.trim();

        String[] words = s.split(" ");
        
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + lengthOfLastWord("Hello World"));
        System.out.println("Result 2: " + lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("Result 3: " + lengthOfLastWord("luffy is still joyboy"));
    }
}
