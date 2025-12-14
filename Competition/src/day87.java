import java.util.PriorityQueue;

public class day87 {
    PriorityQueue<Integer> heap;
    int _k;
    public void KthLargest(int k, int[] nums)
    {
        _k = k;
        heap = new PriorityQueue<>();
        for(int x : nums)
        {
            heap.offer(x);
            if(heap.size() > _k)
            {
                heap.poll();
            }
        }
    }

    public int add(int val)
    {
        heap.offer(val);
        if(heap.size() > _k)
        {
            heap.poll();
        }
        return heap.peek();
    }
}
