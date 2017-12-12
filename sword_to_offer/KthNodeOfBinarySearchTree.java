package sword.to.offer;

/**
 *  Problem Description
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * Thinking:
 * 1. 二叉搜索树中序遍历的结果序列就是一个按升序排序好的序列，
 * 2. 因此按此序列顺序返回第K个节点即为所求。
 */
public class KthNodeOfBinarySearchTree {
    private int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) return node;
            if (++index == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null) return node;
        }
        return null;
    }
}
