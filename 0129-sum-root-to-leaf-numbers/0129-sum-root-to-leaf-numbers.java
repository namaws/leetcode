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
    public int sumNumbers(TreeNode root) {
        return findPath(root, 0);
    }
    
    public int findPath(TreeNode node, int value) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return value*10 + node.val;
        
        return findPath(node.left, value*10+node.val) + findPath(node.right, value*10+node.val);
    }
}