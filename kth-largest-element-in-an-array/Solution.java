// Runtime: 6 ms, faster than 61.66% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 36.4 MB, less than 90.67% of Java online submissions for Kth Largest Element in an Array.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : nums) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
