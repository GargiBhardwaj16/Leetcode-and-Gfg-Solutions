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
    public static void display(TreeNode root, List<Integer> l){
        if(root==null) return ;
        display(root.left,l);
        l.add(root.val);
        display(root.right,l);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        List<Integer> l=new ArrayList<>();
        display(root,l);
        boolean flag=true;
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>=l.get(i+1)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}