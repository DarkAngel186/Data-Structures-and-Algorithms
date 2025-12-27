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
 * This is a solution for Leetcode problem, Lowest Common Ancestor Of Binary Tree:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 
 */
public class LowestCommonAncestor {
    
    TreeNode ans = null;

    private boolean lca(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return false;

        if(ans != null) return true;

        boolean l = lca(root.left, p, q);
        
        if(ans != null) return true;

        boolean r = lca(root.right, p, q);

        boolean n = root == p || root == q;

        if(r && l || l && n || r && n) ans = root;

        return l || n || r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        lca(root, p, q);

        return ans;
    }
}
