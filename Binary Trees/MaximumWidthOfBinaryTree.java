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
 * This is a solution for Leetcode problem, Maximum Width Of Binary Tree:
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 * 
 */
class Pair{

    TreeNode node;
    int n;

    Pair(TreeNode node, int n) {

        this.node = node;
        this.n = n;
    }
}

public class MaximumWidthOfBinaryTree {
    
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int ans = 0;

        while(queue.size() > 0) {

            int s = queue.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < s; i++) {

                Pair p = queue.remove();

                if(p.node.left != null) queue.add(new Pair(p.node.left, (2 * p.n) + 1));
                if(p.node.right != null) queue.add(new Pair(p.node.right, (2 * p.n) + 2));

                if(i == 0) start = p.n;
                if(i == s - 1) end = p.n;
            }

            ans = Math.max(ans, end - start);
        }

        return ans + 1;
    }
}
