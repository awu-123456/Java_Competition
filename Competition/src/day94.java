import java.util.Scanner;

public class day94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++) p[i] = in.nextInt();
        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];
        k = Math.min(k, n / 2);
        for(int j = 0; j <= k; j++) f[0][j] = g[0][j] = -0x3f3f3f3f;
        f[0][0] = -p[0]; g[0][0] = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - p[i]);
                g[i][j] = g[i - 1][j];
                if(j >= 1) g[i][j] = Math.max(g[i][j], f[i - 1][j - 1] + p[i]);
            }
        }
        int ret = 0;
        for(int j = 0; j <= k; j++) ret = Math.max(ret, g[n - 1][j]);
        System.out.println(ret);
    }
}