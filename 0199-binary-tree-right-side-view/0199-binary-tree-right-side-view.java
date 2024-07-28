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
class Pair{
    int f;
    int s;
    Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        if(root==null) return l;
        solve(root,0,l);
        return l;
    }
    public static void solve(TreeNode root,int level,List<Integer>l){
        if(root==null) return;
        if(level==l.size()){
            l.add(root.val);
        }
        if(root.right!=null) solve(root.right,level+1,l);
        if(root.left!=null) solve(root.left,level+1,l);
    }
}