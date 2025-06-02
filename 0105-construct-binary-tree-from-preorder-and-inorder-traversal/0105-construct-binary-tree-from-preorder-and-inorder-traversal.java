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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
        root is preorder first value
         */
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int idx = 0;

        for(int val: inorder) {
            if(val == root.val)
                break;
            idx++;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));
        return root;
    }
}