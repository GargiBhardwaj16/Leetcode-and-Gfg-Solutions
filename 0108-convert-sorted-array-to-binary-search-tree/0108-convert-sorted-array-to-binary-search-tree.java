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
     private static TreeNode constructBST(int[] arr, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBST(arr, start, mid - 1);
        root.right = constructBST(arr, mid + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return constructBST(nums,0,n-1);
    }
}