package sword.to.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 题目描述
 *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *  例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

public class FirstAppear {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    ArrayList<Character> list = new ArrayList<Character>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
             map.put(ch, map.get(ch)+1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    public char FirstAppearingOnce() {
        char ch = '#';
        for (char c : list) {
            if (map.get(c) == 1) {
                ch = c;
                break;
            }
        }
        return ch;

    }
}
