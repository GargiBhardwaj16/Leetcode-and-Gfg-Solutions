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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null ){
            return root;
        }
        if(root.val == key){
            if (root.left == null && root.right == null){
                root = null;
            } 
            else if (root.right != null) {
                root.val = slightlyBigger(root);
                root.right = deleteNode(root.right, root.val);
            }     
            else {
                root.val = slightlySmaller(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val>key){
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    public int slightlyBigger(TreeNode root) {
        root = root.right;
        while (root.left != null){
            root = root.left;
        } 
        return root.val;
    }

    public int slightlySmaller(TreeNode root) {
        root = root.left;
        while (root.right != null){
            root = root.right;
        } 
        return root.val;
    }
}