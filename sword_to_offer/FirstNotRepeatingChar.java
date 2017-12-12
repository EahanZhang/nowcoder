package sword.to.offer;

/**
 * Problem Description:
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 * Thinking:
 *  先遍历一次，使用哈希记录每个次数，再遍历一次，输出次数为1的字母
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;
        int[] times = new int[256];
        for (int i = 0; i < str.length(); i++) times[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (times[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    public static void main(String [] args) {
        new FirstNotRepeatingChar().FirstNotRepeatingChar("google");
    }
}
