import java.util.PriorityQueue;
import java.util.Scanner;

public class day36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 1;i <= m;i++) {
            heap.add(0);
        }
        int ret = 0;
        for(int i = 1;i <= n;i++) {
            int x = scanner.nextInt();
            int t = heap.poll();
            t += x;
            heap.add(t);
            ret = Math.max(ret,t);
        }
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int cnt = 1;
        int day = 0;
        while(n-- > 0) {
            day++;
            sum += cnt;
            if(day == cnt) {
                day = 0;
                cnt++;
            }
        }
        System.out.println(sum);
    }
}
