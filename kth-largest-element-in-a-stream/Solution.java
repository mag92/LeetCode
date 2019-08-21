/* *
* Runtime: 58 ms, faster than 86.98% of Java online submissions for Kth Largest Element in a Stream.
* Memory Usage: 43 MB, less than 96.67% of Java online submissions for Kth Largest Element in a  Stream.
*/
import java.util.*;

class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;
        for(int i : nums)
            add(i);
            
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > K)
            pq.poll();
    
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
