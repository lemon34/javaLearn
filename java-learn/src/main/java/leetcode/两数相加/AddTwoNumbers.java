package leetcode.两数相加;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //返回结果，相当于哨兵节点
        ListNode listNodeRes = new ListNode();
        ListNode listNodeTmp = listNodeRes;
        int tmpVal = 0;
        int carry = 0;
        int currentVal = 0;
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        while (true) {
            if (listNode1 == null && listNode2 == null) {
                //当进位不为0的时候，还需要补充一个节点
                if (carry != 0) {
                    listNodeTmp.next = new ListNode(carry);
                }
                break;
            }
            if (listNode1 != null && listNode2 != null) {
                //都不为空
                tmpVal = carry + listNode1.val + listNode2.val;
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            } else if (listNode1 != null && listNode2 == null) {
                //其中一个为空
                tmpVal = carry + listNode1.val;
                listNode1 = listNode1.next;
            } else if (listNode1 == null && listNode2 != null) {
                //其中一个为空
                tmpVal = carry + listNode2.val;
                listNode2 = listNode2.next;
            }
            // 进位等于 mod
            carry = tmpVal / 10;
            // 剩余值为余数
            currentVal = tmpVal % 10;
            listNodeTmp.next = new ListNode(currentVal);
            listNodeTmp = listNodeTmp.next;
        }
        return listNodeRes.next;
    }

    public static void main(String[] args) {
        ListNode listNode1= new ListNode(9);
        listNode1.next = new ListNode(9);
    }
}
