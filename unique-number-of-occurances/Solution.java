/* Runtime: 2 ms, faster than 88.20% of Java online submissions for Unique Number of Occurrences.
* Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Unique Number of Occurrences.
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        
        for(int i : arr) {
            if (numFreq.get(i) != null) numFreq.put(i, numFreq.get(i) + 1);
            else numFreq.put(i, 1);
        }
        
        List<Integer> freqs = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> e : numFreq.entrySet()) {
            
            if (freqs.contains(e.getValue())) return false;
            freqs.add(e.getValue());
        }
        return true;
    }
}
