/*  Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
    Memory Usage: 34 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings.
*/
class Solution {
    public int balancedStringSplit(String s) {
        char[] sArr = s.toCharArray();
        
        int balance = 0;
        int count = 0;
        
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == 'R')
                balance++;
            else if (sArr[i] == 'L')
                balance--;
            
            if (i > 0 & balance == 0) 
                count++;
        }
        return count;
    }
}
