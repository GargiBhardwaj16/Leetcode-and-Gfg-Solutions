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
    static HashMap<Long,Integer> m;
    static int count;
    public static void solve(TreeNode root, int sum, long curr){
         if(root==null){
            return ;
        }
        curr+=root.val;
        
        if(curr==sum) count++;
        if(m.containsKey(curr-sum)){
            count+=m.get(curr-sum);
        }
        m.put(curr,m.getOrDefault(curr,0)+1);
        solve(root.left,sum,curr);
        solve(root.right,sum,curr);
        m.put(curr,m.get(curr)-1);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        m=new HashMap<>();
        count=0;
        solve(root,targetSum,0);
        return count;
        /*if(root==null){
            return 0;
        }
        int ans=solve(root,targetSum,0);
        int l=pathSum(root.left, targetSum);
        int r=pathSum(root.right, targetSum);
        return ans+l+r;*/
    }
}