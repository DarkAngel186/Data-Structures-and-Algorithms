/**
 * Definition for a binary tree node. 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * This is a solution for Leetcode problem, Binary Tree Maximum Path Sum:
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * 
 */
public class BinaryTreeMaximumPathSum {
    
    int maxPath = Integer.MIN_VALUE;

    private int solve(TreeNode root) {

        if(root == null) return 0;

        int l = Math.max(0, solve(root.left));
        
        int r = Math.max(0, solve(root.right));

        maxPath = Math.max(maxPath, l + r + root.val);

        return Math.max(l, r) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        
        solve(root);

        return maxPath;
    }
}
