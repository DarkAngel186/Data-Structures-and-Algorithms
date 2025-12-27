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
 * This is a solution for Leetcode problem, Burn A Binary Tree:
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 * 
 */
public class BurnATree {
    
    int time = 0;
    int tempTime = 0;
    boolean flag = false;
    TreeNode prev = null;

    private void infectTree(TreeNode root, int currTime) {

        if(root == null || root == prev) return;

        time = Math.max(time, currTime);

        infectTree(root.left, currTime + 1);
        infectTree(root.right, currTime + 1);
    }

    private void findStartNode(TreeNode root, int start) {

        if(root == null) return;

        if(root.val == start) {

            flag = true;
            infectTree(root, 0);
            prev = root;
            tempTime++;
            return;
        }

        if(!flag) findStartNode(root.left, start);
        
        if(!flag) findStartNode(root.right, start);

        if(flag) {

            infectTree(root, tempTime);
            prev = root;
            tempTime++;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        
        findStartNode(root, start);
        return time;
    }
}
