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
    public static void preorderTraversal(TreeNode root, List<Integer> l){
        if(root==null) return;
        l.add(root.val);
        preorderTraversal(root.left,l);
        preorderTraversal(root.right,l);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        preorderTraversal(root,l);
        return l;
    }
}