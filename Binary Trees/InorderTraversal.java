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
 * This is a solution for Leetcode problem, Binary Tree Inorder Traversal:
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * 
 * This problem is solved using DFS.
 */
public class InorderTraversal {

    List<Integer> ans;

    private void solve(TreeNode root) {

        if(root == null) return;

        solve(root.left);
        
        ans.add(root.val);

        solve(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        ans = new ArrayList<>();

        solve(root);

        return ans;
    }
}