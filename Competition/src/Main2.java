import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        PriorityQueue<Integer> heep = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
        long sum = 0;
        for(int i = 0;i < n;i++) {
            long x = scanner.nextLong();
            if(x % 2 == 0) {
                heep.add((int)x);
            }
            sum += x;
        }
        while(k-- > 0 && !heep.isEmpty()) {
            long x = heep.poll() / 2;
            sum -= x;
            if(x % 2 == 0) {
                heep.add((int)x);
            }
        }
        System.out.println(sum);
    }
}
