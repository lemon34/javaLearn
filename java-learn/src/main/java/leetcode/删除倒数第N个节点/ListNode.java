package leetcode.删除倒数第N个节点;


import lombok.Data;

@Data
public class ListNode {

    ListNode next;
    private int val;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
