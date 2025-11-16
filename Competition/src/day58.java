public class day58 extends day53{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        int n = 0;
        ListNode cur = head;
        while(cur != null)
        {
            cur = cur.next;
            n++;
        }
        n /= k;
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        cur = head;
        for(int i = 0; i < n; i++)
        {
            ListNode tmp = cur;
            for(int j = 0; j < k; j++)
            {
                ListNode next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = next;
            }
            prev = tmp;
        }
        prev.next = cur;
        return newHead.next;
    }
}
