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
 * This is a solution for Leetcode problem, Flatten Binary Tree To Linked List:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * 
 */
public class FlattenBinaryTreeToLL {
    
    TreeNode previous = null;

    public void flatten(TreeNode root) {
        
        if(root == null) return;

        flatten(root.right);

        flatten(root.left);

        root.left = null;
        root.right = previous;
        previous = root;
    }
}
