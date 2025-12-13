import java.util.Queue;

public class day86 {
    public int lastStoneWeight(int[] stones)
    {
        Queue<Integer> heap = null;
        for(int x : stones)
        {
            heap.offer(x);
        }
        while(heap.size() > 1)
        {
            int a = heap.poll();
            int b = heap.poll();
            if(a > b)
            {
                heap.offer(a - b);
            }
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
