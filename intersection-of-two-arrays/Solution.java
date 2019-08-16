/**
 * Runtime: 2 ms, faster than 98.40% of Java online submissions for Intersection of Two Arrays.
 * Memory Usage: 37.5 MB, less than 68.92% of Java online submissions for Intersection of Two Arrays.
 * Next challenges
 * */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int i : nums1) {
            if (freqs.get(i) == null) freqs.put(i, 1);
            else freqs.put(i, freqs.get(i)+1);
        }
        Set<Integer> l = new HashSet<>();
        for(int j : nums2) {
            if (freqs.get(j) != null) l.add(j);
        }
        
        int[] intersection = new int[l.size()];
        int i = 0;
        Iterator iter = l.iterator();
        while (iter.hasNext()) {
            intersection[i] = (int)iter.next();
            i++;
        }
        
        return intersection;
    }
    
}
