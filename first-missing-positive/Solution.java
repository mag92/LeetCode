/* *
* Runtime: 7 ms, faster than 5.84% of Java online submissions for First Missing Positive.
* Memory Usage: 36 MB, less than 100.00% of Java online submissions for First Missing Positive.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : nums) {
            m.put(i, 1);
        }
        
        int min = 1;
        int max = 0;
        
        for(int i : nums) {
            if (i < min && i >= 1) {
                min = i;
            }
            if (i > max)
                max = i;
        }
        
        for(int i = min; i < max; i++){
            System.out.println(i);
            if (m.get(i) != null)
                continue;
            else return i;
            
        }
        return max+1;
    }
}
