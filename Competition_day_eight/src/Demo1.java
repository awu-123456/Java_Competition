import com.sun.tools.javac.Main;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] arr = new long[n+1];
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextLong();
        }
        long[] dp = new long[n+1];
        for(int i = 1;i <= n;i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        for(int i = 1;i <= m;i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(dp[r]-dp[l-1]);
        }
    }
}
