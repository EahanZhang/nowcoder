package sword.to.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description:
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * Thinking:
 *  使用两个堆栈stack1,stack2来实现该功能。
 *  1. 设置reverse位，当reverse为false时，表示此时为从左到右输出，对stack1进行操作；否则，表示从右到左输出,对stack2进行操作。
 *  2. 当stack1和stack2不全为空的时候，继续循环。
 *  3. 当前顺序为从左到右输出的时候， 将当前节点的左右节点按先左后右的顺序压入stack2，之后需要从右往左输出的时候直接将stack2的元素pop出来即可
 *  4. 同理，当前顺序为从右到左的时候，将当前节点的左右节点按先右后左的顺序压入stack1，之后需要从左往右输出逇时候直接将stack1的元素pop出来即可
 *  5. 每次循环结束时,reverse取反。.
 *
 *
 *
 *
 *
 */

public class PrintBinaryTreeLikeZ {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        boolean reverse = false;

        // 若pRoot为空，则不作操作，直接返回。
        if (pRoot != null) {
            stack1.push(pRoot);
            // 只要两个栈不全为空， 则继续循环
            while (!stack1.empty() || !stack2.empty()) {
                // reverse 为 True，则表明顺序为从右到左
                if (reverse) {
                    // 对stack2 进行操作
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    while (!stack2.empty()) {
                        TreeNode tempNode = stack2.pop();
                        // 将节点的值加入到tempList中
                        tempList.add(tempNode.val);
                        // 若子节点不为空，则将子节点按从右到左的顺序压栈
                        if (tempNode.right != null) {
                            stack1.push(tempNode.right);
                        }
                        if (tempNode.left != null) {
                            stack1.push(tempNode.left);
                        }
                    }
                    // 将tempList加入到list中
                    list.add(tempList);
                } else {
                    // 对stack1 进行操作
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    while (!stack1.empty()) {
                        TreeNode tempNode = stack1.pop();
                        // 将节点的值加入到tempList中
                        tempList.add(tempNode.val);
                        // 若子节点不为空，则将子节点按从左到右的顺序压栈
                        if (tempNode.left != null) {
                            stack2.push(tempNode.left);
                        }
                        if (tempNode.right != null) {
                            stack2.push(tempNode.right);
                        }
                    }
                    list.add(tempList);
                }
                reverse = !reverse;
            }
        }
        return list;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(10);
        root.right = new TreeNode(6);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = new TreeNode(5);
        left.right = new TreeNode(7);
        right.left = new TreeNode(9);
        right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> list = new PrintBinaryTreeLikeZ().Print(root);

    }
}
