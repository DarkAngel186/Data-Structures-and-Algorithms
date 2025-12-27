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
 * This is a solution for Leetcode problem, All Nodes Distance K In Binary Tree:
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * 
 */
public class AllNodesDistanceKInBinaryTree {
    
    List<Integer> ans = new ArrayList<>();
    boolean flag = false;
    TreeNode prev = null;
    int idx = 0;

    private void nodesAtDistanceK(TreeNode root, int k) {

        if(k < 0 || root == null || root == prev) return;

        if(k == 0) {

            ans.add(root.val);
            return;
        }

        nodesAtDistanceK(root.left, k - 1);
        nodesAtDistanceK(root.right, k - 1);
    }

    private void findPath(TreeNode root, TreeNode target, int k) {

        if(root == null) return;

        if(target.val == root.val) {

            flag = true;
            nodesAtDistanceK(root, k);
            prev = root;
            idx++;
            return;
        }

        if(!flag) findPath(root.left, target, k);
        
        if(!flag) findPath(root.right, target, k);

        if(flag) {

            nodesAtDistanceK(root, k - idx);
            idx++;
            prev = root;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        findPath(root, target, k);
        return ans;
    }
}
