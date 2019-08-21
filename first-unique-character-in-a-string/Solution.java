/* Not the fastest obviously... :)
Runtime: 46 ms, faster than 19.53% of Java online submissions for First Unique Character in a String.
Memory Usage: 39 MB, less than 86.43% of Java online submissions for First Unique Character in a String.
*/

class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> freq = new LinkedHashMap<>();
        char[] sArr = s.toCharArray();
        
        for(char c : sArr){
            if (freq.get(c) == null) freq.put(c, 1);
            else freq.put(c, freq.get(c)+1);
        }
        
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1)
                return s.indexOf(entry.getKey());
        }
        return -1;
    }
}
