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
 * This is a solution for Leetcode problem, Subtree Of Another Tree:
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * 
 */
public class SubtreeOfAnotherTree {
    
    private boolean solve(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null) return true;
        
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;

        return solve(root.left, subRoot.left) && solve(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null) return true;
        
        if(root == null || subRoot == null) return false;
        
        if(root.val == subRoot.val && solve(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
