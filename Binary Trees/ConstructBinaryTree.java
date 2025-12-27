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
 * This class contains solution for 3 classic Leetcode problem for trees i.e. : 
 * 1. Construct Binary Tree from Preorder and Inorder Traversal: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * 
 * 2. Construct Binary Tree from Postorder and Inorder Traversal: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * 
 * 3. Construct Binary Tree from Postorder and Preorder Traversal:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 * 
 */
public class ConstructBinaryTree {
    
    private TreeNode solveForPreorderAndInorder(int[] pre, int in[], int psi, int pei, int isi, int iei) {

        if(isi > iei || psi > pei) return null;

        int idx = isi;
        while(pre[psi] != in[idx]) idx++;

        int l = idx - isi;

        TreeNode root = new TreeNode(pre[psi]);

        root.left = solveForPreorderAndInorder(pre, in, psi + 1, psi + l, isi, idx - 1);
        root.right = solveForPreorderAndInorder(pre, in, psi + l + 1, pei, idx + 1, iei);

        return root;
    }

    private TreeNode solveForPostorderAndInorder(int[] post, int[] in, int psi, int pei, int isi, int iei) {

        if(isi > iei || psi > pei) return null;

        int idx = isi;
        while(in[idx] != post[pei]) idx++;

        int r = iei - idx;

        TreeNode root = new TreeNode(post[pei]);

        root.left = solveForPostorderAndInorder(post, in, psi, pei - r - 1, isi, idx - 1);
        root.right = solveForPostorderAndInorder(post, in, pei - r, pei - 1, idx + 1, iei);

        return root;
    }

    private TreeNode solveForPostorderAndPreorder(int[] pre, int[] post, int prsi, int prei, int posi, int poei) {

        if(prsi > prei || posi > poei) return null;

        int root = prsi + 1;
        while(root <= prei && post[poei - 1] != pre[root]) root++;

        int rn = prei - root + 1;

        TreeNode node = new TreeNode(post[poei]);

        node.left = solveForPostorderAndPreorder(pre, post, prsi + 1, root - 1, posi, poei - rn - 1);
        
        node.right = solveForPostorderAndPreorder(pre, post, root, prei, poei - rn, poei - 1);

        return node;
    }

    public TreeNode buildTree(int[] order1, int[] order2) {
        
        // To Construct Binary Tree from Preorder and Inorder Traversal:
        TreeNode root =  solveForPreorderAndInorder(order1, order2, 0, order1.length - 1, 0, order2.length - 1);

        // To Construct Binary Tree from Postorder and Inorder Traversal:
        solveForPostorderAndPreorder(order1, order2, 0, order1.length - 1, 0, order2.length - 1);

        // To Construct Binary Tree from Postorder and Preorder Traversal:
        solveForPostorderAndInorder(order1, order2, 0, order1.length - 1, 0, order2.length - 1);

        return root;
    }
}
