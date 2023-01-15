package leetcode.删除倒数第N个节点;


public class RemoveNthFromEnd {
    /**
     * 本题采用快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        // 这块返回dummy.next 而不是返回head的原因是由于当head节点被删除的时候，此时head已经不存在了，所以需要返回哨兵节点对应的下一个节点
        ListNode ans = dummy.next;
        return ans;

    }
}
