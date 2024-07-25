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
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        maxi=Math.max(maxi,lh+rh);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxi;
    }
    public int height(TreeNode root){
         if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
     
        return Math.max(lheight,rheight)+1;
    }
        
  }
    
}