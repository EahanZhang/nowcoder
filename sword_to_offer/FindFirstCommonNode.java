package sword.to.offer;

/**
 * 题目描述：
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路：
 * 两层循环寻找第一个共同节点
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode point1 = pHead1;
        while (point1 != null) {
            ListNode point2 = pHead2;
            while (point2 != null) {
                if (point1.val == point2.val) {
                    return point1;
                }
                point2 = point2.next;
            }
            point1 = point1.next;
        }
        return null;
    }
}
