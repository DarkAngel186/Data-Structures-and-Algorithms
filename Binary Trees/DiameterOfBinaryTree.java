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
 * This is a solution for Leetcode problem, Diameter Of Binary Tree:
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * 
 */
public class DiameterOfBinaryTree {
    
    int diameter = 0;

    private int height(TreeNode root) {

        if(root == null) return 0;

        int l = height(root.left);

        int r = height(root.right);

        diameter = Math.max(l + r, diameter);

        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        height(root);

        return diameter;
    }
}
