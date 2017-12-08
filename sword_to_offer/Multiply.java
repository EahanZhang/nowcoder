package sword.to.offer;

/**
 * 题目描述
 *  给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *  其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 *  不能使用除法。
 * 思路：
 * 1. 使用两个for循环
 * 2. 第一个for循环
 * 2. 第二个for循环使用两个for循环嵌套，求B[i]与A[i+1]至A[n-1]的乘积
 */
public class Multiply {
    public static int [] multiply(int [] A) {
        int [] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                B[i] *= A[j];
            }
        }
        return B;
    }
}
