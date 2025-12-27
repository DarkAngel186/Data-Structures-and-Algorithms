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
 * This is a solution for Leetcode problem, Find Bottom Left Tree Value:
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * 
 */
public class FindBottomLeftTreeValue {
    
    int maxLevel;
    int ans;

    private void solve(TreeNode root, int level) {

        if(root == null) return;

        if(level > maxLevel) {
            
            ans = root.val;
            maxLevel = level;
        }

        solve(root.left, level + 1);
        
        solve(root.right, level + 1); 
    }

    public int findBottomLeftValue(TreeNode root) {
        
        maxLevel = 0;
        ans = root.val;

        solve(root, maxLevel);

        return ans;
    }
}
