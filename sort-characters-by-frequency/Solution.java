/*
Runtime: 20 ms, faster than 62.09% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 38.5 MB, less than 92.59% of Java online submissions for Sort Characters By Frequency.
*/
class Solution {
    public String frequencySort(String s) {
        char[] sArr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : sArr) {
            if (freq.get(c) == null) freq.put(c, 1);
            else freq.put(c, freq.get(c)+1);
        }
        System.out.println(freq.toString());
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(s.length()+1, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                if (a.getValue() < b.getValue()) return 1;
                else if (a.getValue() > b.getValue()) return -1;
                return 0;
            }
        });
        List<Character> l = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : freq.entrySet()) 
            pq.add(entry);
        System.out.println(pq.size());
        StringBuilder str = new StringBuilder("");
        while(pq.size() > 0) {
            //System.out.println(pq.poll().getKey());
            int num = pq.peek().getValue();
            char ch = pq.poll().getKey();
            for(int j = 0; j < num; j++)
                str.append(ch);
        }
        return str.toString();
    }
}
