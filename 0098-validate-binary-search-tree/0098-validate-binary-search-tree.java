/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Deque<TreeNode> stack = new LinkedList();
    Deque<Integer> upper = new LinkedList();
    Deque<Integer> lower = new LinkedList();
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Integer low = null, high = null, val;
        update(root, low, high);
        
        while(!stack.isEmpty()) {
            root = stack.poll();
            low = lower.poll();
            high = upper.poll();
            
            if(root == null) continue;
            val = root.val;
            if(low != null && val <= low) {
                return false;
            }
            if(high != null && val >= high) {
                return false;
            }
            update(root.right,val,high);
            update(root.left,low,val);
        }
        return true;
    }
    
    public void update(TreeNode node, Integer low, Integer high) {
        stack.add(node);
        lower.add(low);
        upper.add(high);
    }
}