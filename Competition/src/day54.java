public class day54 extends day53{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead,cur = prev.next,next = cur.next,nnext = next.next;
        while(cur != null && next != null) {
            prev.next = next;
            next.next = cur;
            cur.next = nnext;
            prev = cur;
            cur = nnext;
            if(cur != null) {
                next = cur.next;
            }
            if(next != null) {
                nnext = next.next;
            }
        }
        return newHead.next;
    }
}
