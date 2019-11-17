/* Runtime: 4 ms, faster than 8.66% of Java online submissions for Search in a Binary Search Tree.
Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Search in a Binary Search Tree.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        Stack<TreeNode> toExplore = new Stack<>();
        
        toExplore.push(root);
        
        while(!toExplore.isEmpty()) {
            TreeNode t = toExplore.pop();
            //System.out.println(t.val);
            if (t.val == val) { //System.out.println(t); 
                return t; }
            if (t.left != null) toExplore.push(t.left);
            if (t.right != null) toExplore.push(t.right);
        }
        return null;
    }
}
