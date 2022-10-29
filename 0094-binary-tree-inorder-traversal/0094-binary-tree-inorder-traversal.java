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
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder start from the leftmost
        //left - root - right
        List<Integer> tree = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            //go to the left most and push every root into the stack
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //pop the curr root
            curr = stack.pop();
            tree.add(curr.val);
            curr = curr.right;
        }
        return tree;
    }

}