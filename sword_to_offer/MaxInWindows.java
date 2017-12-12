package sword.to.offer;
import java.util.ArrayList;
/**
 * Problem Description:
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * Thinking:
 *  1. 对第一个窗口进行排序，记录最大值以及最左边的值，
 *  2. 若下一个窗口的最右边的值大于当前窗口的最大值则不用再进行排序；
 *  3. 若下一个窗口的最右边的值小于当前庄口的最大值,且当前窗口的最大值刚好是最左边的那个值，则需要再进行排序求最大值
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int curMax;
        if (size == 0) {
            return list;
        }
        if (size >= num.length) {
            list.add(getMax(num, 0, num.length - 1));
        } else {
            if (num.length != 0) {
                curMax = getMax(num, 0, size - 1);
                list.add(curMax);

                int count = size;
                while (count < num.length) {
                    int curNumber = num[count];

                    if (curNumber >= curMax) {
                        // 若curNumber大于/等于上一个滑动窗口的最大值， 则直接将curNumber插入list中
                        curMax = curNumber;
                        list.add(curMax);
                    } else {
                        // 若curNumber小于上一个窗口的最大值， 则需要排序来得到当前窗口的最大值
                        curMax = getMax(num, count - size + 1, count);
                        list.add(curMax);
                    }
                    count++;
                }
            }

        }
        return list;
    }

    private static int getMax(int[] num, int begin, int end) {
        if (begin >= num.length || end >= num.length) return -1;
        int max = num[begin];

        for (int i = begin + 1; i <= end; i++) {
            if (num[i] > max) max = num[i];
        }
        return max;
    }
}
