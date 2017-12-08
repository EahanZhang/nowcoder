package sword.to.offer;

/**
 *  题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *  思路：
 *  使用两个指针遍历链表
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop (ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                // 无环， return
                return null;
            }
        }

        // 循环结束表明有环存在， 并且此时slow 和 fast相遇
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = pHead;
        ListNode loopNode = new EntryNodeOfLoop().EntryNodeOfLoop(pHead);
        System.out.println(loopNode.val);
    }
}
