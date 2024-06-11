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
    int max;
    public int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        left=Math.max(left,0);
        right=Math.max(right,0);
        int curr=left+right+root.val;
        max=Math.max(curr,max);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
    }
}