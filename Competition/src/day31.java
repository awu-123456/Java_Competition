import java.util.Scanner;

public class day31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long[][] dp = new long[n+2][m+2];
        dp[0][1] = 1;
        x += 1;
        y += 1;
        for(int i = 1;i <= n+1;i++) {
            for(int j = 1;j <= m+1;j++) {
                if(i != x && j != y && Math.abs(i-x) + Math.abs(j-y) == 3 || (i == x && j == y)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        System.out.println(dp[n+1][m+1]);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long ret = 0;
        for(long x = 0;x <= Math.min(n/2,m);x++) {
            long y = Math.min(n - x * 2,(m - x) / 2);
            ret = Math.max(ret,x * a + y * b);
        }
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = scanner.nextInt();
        }
        int ret = 0;
        for(int i = 1;i < n;i++) {
            if(arr[i] - arr[i-1] > 0) {
                ret += arr[i] - arr[i-1];
            }
        }
        System.out.println(ret);
    }
}
