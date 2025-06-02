/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // use preorder
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helperSerialize(root, "");
    }
    
    private String helperSerialize(TreeNode node, String str) {
        if(node == null) str+="null,";
        else {
        str += str.valueOf(node.val) + ",";
        str = helperSerialize(node.left, str);
        str = helperSerialize(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return helperDeserialize(data_list);
    }
    
    private TreeNode helperDeserialize(List<String> data) {
        if(data.get(0).equals("null"))  {
            data.remove(0);
            return null;
        }
        //put the first value into root
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = helperDeserialize(data);
        root.right = helperDeserialize(data);
        
        return root;
    }
    
    
};

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));