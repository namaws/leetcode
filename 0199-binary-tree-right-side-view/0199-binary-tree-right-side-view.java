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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        List<Integer> list = new ArrayList();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                TreeNode curr = q.poll();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
                if(size == 1) 
                    list.add(curr.val);
                size--;
            }
        }
        return list;
    }
}