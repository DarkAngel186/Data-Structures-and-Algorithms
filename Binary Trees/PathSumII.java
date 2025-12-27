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
 * This is a solution for Leetcode problem, Path Sum II:
 * https://leetcode.com/problems/path-sum-ii/description/
 * 
 */
public class PathSumII {
    
    List<List<Integer>> ans;

    private void solve(TreeNode root, int tar, List<Integer> res) {

        if(root == null) return;

        if(root.left == null && root.right == null) {

            if(tar == root.val) {

                res.add(root.val);
                ans.add(new ArrayList<>(res));
                res.remove(res.size() - 1);
            }
            
            return;
        }

        res.add(root.val);

        solve(root.left, tar - root.val, res);

        solve(root.right, tar - root.val, res);

        res.remove(res.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        ans = new ArrayList<>();

        solve(root, targetSum, new ArrayList<>());

        return ans;
    }
}
