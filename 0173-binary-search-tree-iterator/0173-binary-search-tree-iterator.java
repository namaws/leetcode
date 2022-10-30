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
class BSTIterator {
    ArrayList<Integer> inOrderTree;
    int index;
    public BSTIterator(TreeNode root) {
        //Arrays containing all the nodes in the sorted order
        this.inOrderTree = new ArrayList<Integer>();
        //pointer to the next smallest element in the BST
        this.index = -1;
        
        this.inOrder(root);
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) return;
        this.inOrder(root.left);
        this.inOrderTree.add(root.val);
        this.inOrder(root.right);
    }
    
    public int next() {
        return this.inOrderTree.get(++this.index);
    }
    
    public boolean hasNext() {
        return this.index+1 < this.inOrderTree.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */