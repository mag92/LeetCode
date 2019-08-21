/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
*/
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        
        char[] addr = address.toCharArray();
        for(char c : addr){
            if (c == '.') {
                s.append('[');
                s.append(c);
                s.append(']');
            }
            else
                s.append(c);
        }
        return s.toString();
    }
}
