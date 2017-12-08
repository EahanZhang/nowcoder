package sword.to.offer;

import java.util.List;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：
 * 1. 在所给链表前加一个节点，避免删除头结点时的麻烦
 * 2. 遍历链表， 如果当前节点和当前节点的下一个节点的值相等，则进入循环， 直到当前节点和下一个节点的值不等时跳出循环
 * 3. 将重复的节点剔除（修改节点的next指向）
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
