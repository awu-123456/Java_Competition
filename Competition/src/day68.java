import java.util.PriorityQueue;
import java.util.Scanner;

public class day68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        int[] arr = new int[10000];
        int n = 0,sum = 0;
        while(x > 0) {
            int t = (int)(x % 10);
            arr[n++] = t;
            sum += t;
            x /= 10;
        }
        if(sum % 2 == 1) {
            System.out.println("No");
            return;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0;i < n;i++) {
            for(int j = sum;j >= arr[i];j--) {
                dp[j] = dp[j] || dp[j-arr[i]];
            }
        }
        if(dp[sum]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            long n = scanner.nextLong();
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long ret = 0;
            if(n <= 2) {
                ret += Math.min(a,b);
            } else {
                if(a * 3 < b * 2) {
                    ret += (n / 2 * a);
                    n %= 2;
                    if(n == 1) {
                        ret += Math.min(Math.min(a,b),b - a);
                    }
                } else {
                    ret += (n / 3 * b);
                    n %= 3;
                    if(n == 1) {
                        ret += Math.min(Math.min(a,b),2 * a - b);
                    }
                    if(n == 2) {
                        ret += Math.min(Math.min(a,b),3 * a - b);
                    }
                }
            }
            System.out.println(ret);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i < n;i++) {
            int x = scanner.nextInt();
            heap.add(x);
        }
        int sum = 0,count = 0;
        while (true) {
            int x = heap.poll();
            sum += x;
            count++;
            heap.add(x * 2);
            if(sum > k) {
                System.out.println(count-1);
                return;
            }
        }
    }
}
