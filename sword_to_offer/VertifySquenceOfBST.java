package sword.to.offer;

import java.sql.Array;
import java.util.Arrays;

/**
 *  题目描述
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *  思路：
 *  1. 对于一个二叉搜索树的后序序列，序列最后一位是该树的顶点。
 *  2. 序列中存在一个节点，在其左边的节点均小于顶点的值， 在其右边的节点均大于顶点的值（最后一位除外）
 *  3. 对于其每一个子树也成立
 *  4. 因此可以遍历每一个子树，判断其是否为后序序列。然后做与运算。
 */
public class VertifySquenceOfBST {
    public static boolean VerrifySequenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) return false;
        // 找分界点
        int pos = getLocation(sequence);
        int top = sequence[sequence.length - 1];
        // 对序列的右子树进行判断
        for (int j = pos; j < sequence.length - 1; j++) if (sequence[j] < top) return false;
        // 若左右子树均满足条件，则进行递归
        if (pos > 1 && pos <= sequence.length - 3)
            return VerrifySequenceOfBST(Arrays.copyOfRange(sequence, 0, pos))
                    && VerrifySequenceOfBST(Arrays.copyOfRange(sequence, pos + 1, sequence.length - 2));
        else if (pos > 1 && pos > sequence.length - 3)
            return VerrifySequenceOfBST(Arrays.copyOfRange(sequence, 0, pos));
        else if (pos < 1 && pos <= sequence.length - 3)
            return VerrifySequenceOfBST(Arrays.copyOfRange(sequence, pos + 1, sequence.length - 2));
        return true;
    }

    public static int getLocation(int [] sequence) {
        int i, top = sequence[sequence.length - 1];
        for (i = 0; i < sequence.length - 1 ; i++) if (sequence[i] > top) break;
        return i;
    }

    public static void main(String[] args) {
        int s[] = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(VerrifySequenceOfBST(s) ? "true" : "false");
    }
}
