package sword.to.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  题目描述：
 *  如何得到一个数据流中的中位数？
 *  如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *  如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 *  思路1：
 *   构建一个字符串， 将数字一次读入并排序， 根据字符串长度输出结果
 */
public class GetMidian {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void Insert(int num) {
        list.add(num);
        Collections.sort(list);
        System.out.println(list.toString());
    }

    public static Double GetMedian() {
       double a, b;
       a = list.get(list.size() / 2);
       b = list.get(list.size() / 2 - 1);
       if (list.size() % 2 != 0) {
           return a;
       } else {
           return (a + b) / 2;
       }
    }

    public static void main(String[] args) {
        int[] list = {5,2,3,4,1,6,7,0,8};
        for (int i : list) Insert(i);
        System.out.println(GetMedian());
    }
 }
