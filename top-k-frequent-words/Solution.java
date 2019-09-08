/*
Runtime: 6 ms, faster than 96.25% of Java online submissions for Top K Frequent Words.
Memory Usage: 39.5 MB, less than 58.93% of Java online submissions for Top K Frequent Words.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String, Integer>> pqFreqs = 
            new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer>e2) {
                    if (e2.getValue() == e1.getValue())
                        return e1.getKey().compareTo(e2.getKey());
                    return e2.getValue() - e1.getValue();
                }
            });
        
        Map<String, Integer> freqs = new HashMap<>();
        
        for(String w : words) {
            if (freqs.get(w) == null) freqs.put(w, 1);
            else freqs.put(w, freqs.get(w) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : freqs.entrySet())
            pqFreqs.add(entry);
        
        // pop k elements from pq
        List<String> l = new ArrayList<>();
        
        while (k != 0) {
            l.add(pqFreqs.poll().getKey());
            k--;
        }
        return l;
    }
}
