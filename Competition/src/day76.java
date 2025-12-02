import java.util.PriorityQueue;

public class day76 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((a,b) -> b.compareTo(a));
        double sum = 0;
        for(int x : nums) {
            sum += x;
            heap.add((double)x);
        }
        int count = 0;
        sum /= 2.0;
        while(sum > 0) {
            double t = heap.peek() / 2.0;
            heap.poll();
            sum -= t;
            count++;
            heap.add(t);
        }
        return count;
    }

    public boolean lemonadeChange(int[] bills) {
        int ten = 0,five = 0;
        for(int x : bills) {
            if(x == 5) {
                five++;
            }
            else if(x == 10) {
                if(five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else {
                if(five != 0 && ten != 0) {
                    five--;
                    ten--;
                }
                else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
