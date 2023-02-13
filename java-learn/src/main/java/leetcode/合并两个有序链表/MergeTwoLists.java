package leetcode.合并两个有序链表;

public class MergeTwoLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 == null) {
                return list2;
            }
            if (list2 ==null) {
                return list1;
            }
            ListNode headListNode = new ListNode();
            while (list1 != null && list2 != null) {
                ListNode tmp = new ListNode();
                tmp.val = list1.val > list2.val ? list2.val : list1.val;
                headListNode.next = tmp;
                if (list1.val > list2.val) {
                    list2 = list2.next;
                }else {
                    list1 = list1.next;
                }
            }
            return headListNode.next;
        }
}
