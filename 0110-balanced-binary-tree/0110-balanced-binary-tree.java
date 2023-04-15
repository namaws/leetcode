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
    //definition of balanced tree is the difference of height of left and right is less than 2
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(findHeight(root.left)-findHeight(root.right)) < 2&& isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int findHeight(TreeNode root) {
        //empty tree height is 0
        if(root == null) return 0;
        return Math.max(findHeight(root.left), findHeight(root.right))+1;
    }
}