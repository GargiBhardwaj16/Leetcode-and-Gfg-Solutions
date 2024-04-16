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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode cur=new TreeNode(val);
            cur.left=root;
            return cur;
        }
        add(root,val,depth,1);
        return root;
    }
    public void add(TreeNode root, int val, int depth,int c){
         if(root==null){
           return ;
        }
        c=c+1;
        if(c==depth){
            TreeNode cur=new TreeNode(val);
            cur.left=root.left;
            root.left=cur;
            TreeNode cur1=new TreeNode(val);
            cur1.right=root.right;
            root.right=cur1;
        }
      add(root.left,val,depth,c);
      add(root.right,val,depth,c);
    }
}