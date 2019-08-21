/* Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
Memory Usage: 34.1 MB, less than 98.70% of Java online submissions for To Lower Case.
*/

class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] >= 65 && chars[i] <= 90)
                chars[i] += 32;
        }
        return new StringBuilder().append(chars).toString();
    }
}
