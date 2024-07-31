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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(postorder.length == 1) return root;
        
        int idx = 0;
        for(int val: inorder) {
            if(root.val == val) break;
            idx++;
        }
        
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, idx), Arrays.copyOfRange(postorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(inorder, idx+1, inorder.length), Arrays.copyOfRange(postorder, idx, postorder.length-1));
        return root;
    }
}