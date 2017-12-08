package sword.to.offer;

import sun.reflect.generics.tree.Tree;

/**
 *  题目描述
 *  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *  注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *
 *  思路：
 *  一共用三种情况：
 *  1 如果该树为空， 则返回nill；
 *  2 节点右孩子存在。 则从该节点的右孩子出发一直寻找其左子节点的叶子节点，该叶子节点即为所求。
 *  3 节点不是根节点（即叶子节点），
 *  3.1 若该节点是其父节点的左子节点，则返回该父节点。
 *  3.2 否则向上遍历其父节点的父节点，重复进行上述判断，返回结果。
 */
public class GetNext {
    public TreeLinkNode GetNext (TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;

    }
}
