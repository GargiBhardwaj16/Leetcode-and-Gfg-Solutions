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
    List<String> l=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return l;
        solve(root,"",l);
        return l;
    }
    public static void solve(TreeNode root,String s,List<String> l){
        if(s.length()==0){
            s+=(root.val);
        }
        else{
            s+=("->"+root.val);
        }
        if(root.left==null&& root.right==null) l.add(s);
        if(root.left!=null) solve(root.left,s,l);
        if(root.right!=null) solve(root.right,s,l);
    }
}