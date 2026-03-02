/** Longest Common Prefix
 * Problem link: https://leetcode.com/problems/longest-common-prefix/
 * 
 * Idea:
 *  I can iteratively shorten the first string until it becomes a prefix of the second string, then repeat this process with the remaining strings until all have been compared.
 * 
 * Complexity: O(n * m^2)
 */
public class longestCommonPrefixSolution {
    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while (result != null) {
                if (strs[i].startsWith(result)) {
                    break;
                } else {
                    result = result.substring(0, (result.length() - 1));
                }
            }

            if (result == null || result == "") {
                break;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] test1 = {"flower","flow","flight"};
        String[] test2 = {"dog","racecar","car"};

        System.out.println("Result: " + longestCommonPrefix(test1));
        System.out.println("Result: " + longestCommonPrefix(test2));
    }
}
