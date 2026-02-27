import java.util.HashMap;

/** Roman To Integer
 * Problem link: https://leetcode.com/problems/roman-to-integer/
 * 
 * Idea:
 *  In Roman numerals, most symbols are added from left to rigth. However, when a symbol with smaller value appears before a larger value, it represents substraction. The key idea is compare eahc character with the next one. To get each symbol's value efficiently, HashMap was used to get the value of each symbol.
 * 
 * Complexity: O(n)
 */

public class romanToNumberSolution {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        int a, b = romanNumbers.get(s.charAt(0));
        int result = 0;

        for(int i = 1 ; i < s.length() ; i++) {
            a = romanNumbers.get(s.charAt(i - 1));
            b = romanNumbers.get(s.charAt(i));

            if (a < b) {
                result -= a;
            } else {
                result += a;
            }
        }
        
        return result + b;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + romanToInt("III"));
        System.out.println("Result: " + romanToInt("LVIII"));
        System.out.println("Result: " + romanToInt("MCMXCIV"));
    }
}
