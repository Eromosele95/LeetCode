/**
 * Definition for a binary tree node.

 */
class Solution112 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if(root.val == sum && (root.left==null&&root.right==null)) return true;

        else{
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        }

    }
}