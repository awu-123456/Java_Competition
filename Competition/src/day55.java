public class day55 extends day53{
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = new ListNode(0);
        ListNode cur = slow.next;
        slow.next = null; //
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }
        ListNode cur1 = head, cur2 = head2.next;
        ListNode ret = new ListNode(0);
        ListNode prev = ret;
        while(cur1 != null)
        {
            prev.next = cur1;
            prev = cur1;
            cur1 = cur1.next;
            if(cur2 != null)
            {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
    }
}
