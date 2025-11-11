public class day53 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1,cur2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        int t = 0;
        while(cur1 != null || cur2 != null || t != 0) {
            if(cur1 != null) {
                t += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                t += cur2.val;
                cur2 = cur2.next;
            }
            prev.next = new ListNode(t % 10);
            prev = prev.next;
            t /= 10;
        }
        return newHead.next;
    }
}
