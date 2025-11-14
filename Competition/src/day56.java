import java.util.PriorityQueue;

public class day56 extends day53{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for(ListNode l : lists)
            if(l != null)
                heap.offer(l);
        ListNode ret = new ListNode(0);
        ListNode prev = ret;
        while(!heap.isEmpty())
        {
            ListNode t = heap.poll();
            prev.next = t;
            prev = t;
            if(t.next != null) heap.offer(t.next);
        }
        return ret.next;
    }
}
