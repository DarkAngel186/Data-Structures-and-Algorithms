import java.util.ArrayList;
import java.util.List;

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
 * This is a solution for Leetcode problem, Binary Tree Preorder Traversal:
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * This problem is solved using DFS.
 */
public class PreorderTraversal {
    
    List<Integer> ans;

    private void solve(TreeNode root) {

        if(root == null) return;

        ans.add(root.val);

        solve(root.left);
        
        solve(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        
        ans = new ArrayList<>();

        solve(root);

        return ans;
    }
}
