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
    public int solve(TreeNode root, int sum, long curr){
        int count=0;
         if(root==null){
            return 0;
        }
        curr+=root.val;
        if(curr==sum) count++;
        int ls=solve(root.left,sum,curr);
        int rs=solve(root.right,sum,curr);
        return ls+rs+count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int ans=solve(root,targetSum,0);
        int l=pathSum(root.left, targetSum);
        int r=pathSum(root.right, targetSum);
        return ans+l+r;
    }
}