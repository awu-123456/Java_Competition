import java.util.Scanner;

public class day90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 1, y = 2;
        int MOD = 1000000007;
        for(int i = 2; i <= n; i++)
        {
            int xx = x, yy = y;
            x = (2 * yy + 1) % MOD;
            y = ((2 * yy + 2) % MOD + xx) % MOD;
        }
        System.out.println(x + " " + y);
    }

        public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        double ret = 1.0;
        for(int i = n; i >= n - m + 1; i--) ret *= i;
        for(int i = m; i >= 2; i--) ret /= i;
        for(int i = 0; i < m; i++) ret *= 0.8;
        for(int i = 0; i < n - m; i++) ret *= 0.2;
        System.out.printf("%.4f", ret);
    }
}
