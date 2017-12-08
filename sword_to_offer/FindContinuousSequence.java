package sword.to.offer;
import java.util.ArrayList;
/**
 *  题目描述
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

  思路：
   1. 假设连续正序系列首项为m， 尾项为n， 则S = (m + n) * (n - m + 1) / 2， 其中n < S
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < sum; i++) {
            for (int j = i + 1; j < sum; j++) {
                if (getSum(i, j) == 2 * sum) {
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    for (int m = i; m <= j; m++) {
                        tempList.add(m);
                    }
                    result.add(tempList);
                }
            }
        }
        return result;
    }

    public int getSum(int m, int n) {
        return (m + n) * (n - m + 1);
    }
}
