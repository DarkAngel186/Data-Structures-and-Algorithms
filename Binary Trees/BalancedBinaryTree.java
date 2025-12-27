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
 * This is a solution for Leetcode problem, Balanced Binary Tree:
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * 
 */
public class BalancedBinaryTree {
    
    boolean ans = true;

    private int height(TreeNode root) {

        if(root == null) return 0;

        int l = height(root.left);

        int r = height(root.right);

        if(Math.abs(l - r) > 1) ans = false;

        return Math.max(l, r) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        
        height(root);

        return ans;
    }
}
