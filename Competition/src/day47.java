import java.util.Scanner;

public class day47 {
    int[] dx = {0,1};
    int[] dy = {1,0};
    int sum = 0;
    public void dfs(int x,int y,int n,int m,int[][] grid) {
        sum += grid[x][y];
        for(int k = 0;k < 2;k++) {
            int a = x + dx[k];
            int b = y + dy[k];
            if(a >= 0 && a <= m && b >= 0 && b <= n) {
                dfs(a,b,n,m,grid);
            }
        }
    }
    public int maxValue (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dfs(0,0,n,m,grid);
        return sum;
    }
    public int maxValue1 (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = grid[0][0];
        for(int i = 1;i < n;i++) {
            dp[1][i+1] = dp[1][i] + grid[0][i];
        }
        for(int i = 1;i < m;i++) {
            dp[i+1][1] = dp[i][1] + grid[i][0];
        }
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        for(int i = 0;i < n;i++) {
            long a = scanner.nextLong();
            if(x >= a) {
                x += a;
            } else {
                x += gcd(x,a);
            }
        }
        System.out.println(x);
    }
    private static long gcd(long a, long b) {
        while(b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
