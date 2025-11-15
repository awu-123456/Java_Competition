public class day57 extends day53{
    public ListNode mergeKLists(ListNode[] lists)
    {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int left, int right)
    {
        if(left > right) return null;
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoList(l1, l2);
    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2)
    {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, prev = head;

        while(cur1 != null && cur2 != null)
        {
            if(cur1.val <= cur2.val)
            {
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            }
            else
            {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null) prev.next = cur1;
        if(cur2 != null) prev.next = cur2;
        return head.next;
    }
}
