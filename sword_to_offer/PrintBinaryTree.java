package sword.to.offer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  题目描述
 *  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *  思路：
 *  1. 深度遍历二叉树，输入
 *  2. 使用两个队列存放节点，一次输出
 */
public class PrintBinaryTree {
    ArrayList<ArrayList<Integer> > Print (TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<ArrayList<Integer>>();
        int depth = getDepth(pRoot);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(pRoot);
        int i = 0;
        // 只要队列中还存在节点， 循环继续
        while (!queue1.isEmpty() || !queue2.isEmpty() ) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            // 若queue1中不为空， 则继续取出节点
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    if (node.left != null) {
                        queue2.add(node.left);
                    }
                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                    tempList.add(node.val);
                }
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    if (node.left != null) {
                        queue1.add(node.left);
                    }
                    if (node.right != null) {
                        queue1.add(node.right);
                    }
                    tempList.add(node.val);
                }
            }
            list.add(tempList);
            i++;
        }
        return list;
    }

    int getDepth(TreeNode pRoot) {
        if (pRoot == null) return 0;
        int left = getDepth(pRoot.left);
        int right = getDepth(pRoot.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        PrintBinaryTree test = new PrintBinaryTree();
        ArrayList<ArrayList<Integer>> list = test.Print(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
