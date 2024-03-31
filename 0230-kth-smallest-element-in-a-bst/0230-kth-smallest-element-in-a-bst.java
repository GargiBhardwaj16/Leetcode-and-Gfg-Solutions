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
    public static void printInorder(TreeNode root , ArrayList<Integer> l){
        if (root == null)
            return;
         printInorder(root.left, l);
         l.add(root.val);
         printInorder(root.right,l);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> l=new ArrayList<>();
        printInorder(root,l);
        int size=l.size();
        return l.get(k-1);
    }
}