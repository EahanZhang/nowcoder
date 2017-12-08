package sword.to.offer;

/**
 * 题目描述：
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *  思路：
 *  1. 一共大小为n * 2的矩阵需要填充， 每个小矩形面积为 2 * 1 或 1 * 2（横着摆或竖着摆）
 *  2. 当n = 1时， f(1) = 1
 *  3. 当n = 2时， f(2) = 2
 *  4. 对于n , 有两种情况：
 *      若第一块摆放的是2*1的矩阵（竖着放），则剩下的方法为f(n-1)
 *      若第一块摆放的是1*2的矩阵（横着放），由于横着摆，导致下面那一块的摆法方法确定，因此剩下的方法为f(n-2)
 */
public class RectCover {
    public static int RectCover(int target) {
        if (target <= 0) return 1;
        if (target == 1) return 1;
        else if (target == 2) return 2;
        else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
