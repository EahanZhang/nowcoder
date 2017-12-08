package sword.to.offer;

/**
 * 题目描述：
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 *
 * 思路：
 * 1. 遍历每一个数，分别求其每一位上是否有1， 若有， 计数器加1
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Betwee1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                if (j % 10 == 1) count++;
                j /= 10;
            }
        }
        return count;
    }
}
