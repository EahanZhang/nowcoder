package sword.to.offer;

/**
 *  统计一个数字在排序数组中出现的次数
 */
public class GetNumOfK {
    public int GetNumOfK(int [] array, int k) {
        if (array.length == 0) return 0;
        boolean desc = false;
        if (array[0] >= array[array.length - 1]) desc = true;
        if (desc && (k > array[0] || k < array[array.length - 1])) return 0;
        if (!desc && (k < array[0] || k > array[array.length - 1])) return 0;

       int count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == k) count++;

        return count;
    }
}
