import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
 * This is a solution for Leetcode problem, Binary Tree Zigzag Level Orde Traversal:
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * 
 */
public class ZigzagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while(queue.size() > 0) {

            int s = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < s; i++) {

                TreeNode node = queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(flag) res.add(node.val);

                else res.add(0, node.val);
            }

            ans.add(res);
            flag = !flag;
        }

        return ans;
    }
}
