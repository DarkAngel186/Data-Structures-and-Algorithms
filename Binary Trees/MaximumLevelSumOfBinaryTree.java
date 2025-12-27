import java.util.LinkedList;
import java.util.Queue;

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
 * This is a solution for Leetcode problem, Maximum Level Sum Of Binary Tree:
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 * 
 */
public class MaximumLevelSumOfBinaryTree {
    
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int ans = 1;
        int sum = Integer.MIN_VALUE;

        while(queue.size() > 0) {

            int s = queue.size();
            int currSum = 0;
            for(int i = 0; i < s; i++) {

                TreeNode node = queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                currSum += node.val;
            }

            if(currSum > sum) {

                ans = level;
                sum = currSum;
            } 

            level++;
        }

        return ans;
    }
}
