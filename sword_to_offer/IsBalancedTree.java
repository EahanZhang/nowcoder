package sword.to.offer;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 * 1. 平衡二叉树的特点是： 要么是一棵空树，要么其左子树和右子树的高度相差不超过1；
 * 2. 根据求树的深度来判断是否为平衡二叉树
 */
public class IsBalancedTree {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) isBalanced = false;
        return left > right ? left + 1: right + 1;
    }
}
