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
 * This is a solution for Leetcode problem, Binary Tree Right Side View:
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * 
 */
public class BinaryTreeRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {

            int s = queue.size();
            for(int i = 0; i < s; i++) {

                TreeNode node = queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(i == s - 1) ans.add(node.val);
            }
        }

        return ans;
    }
}
