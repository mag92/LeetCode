/* 
Runtime: 13 ms, faster than 71.05% of Java online submissions for Top K Frequent Elements.
Memory Usage: 40.8 MB, less than 56.90% of Java online submissions for Top K Frequent Elements.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums) {
            if (freq.get(i) == null) freq.put(i, 1);
            else freq.put(i, freq.get(i)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(nums.length, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                if (a.getValue() > b.getValue()) return 1;
                else if (a.getValue() < b.getValue()) return -1;
                return 0;
            }
        });
        List<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(entry);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++)
            l.add(pq.poll().getKey());
        
        return l;
            
    }
}
