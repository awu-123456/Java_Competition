import java.util.Scanner;

public class Main6 {
    int[][] dp = new int[210][210];
    public int maxValue (int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            int n = scanner.nextInt();
            boolean[][] hash = new boolean[n][26];
            for(int i = 0;i < n;i++) {
                char[] s = scanner.next().toCharArray();
                for(char ch : s) {
                    hash[i][ch - 'a'] = true;
                }
            }
            int left = 0;
            int right = n - 1;
            while(left < right) {
                if(!check(hash,left,right)) {
                    break;
                }
                left++;
                right--;
            }
            if(left < right) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean check(boolean[][] hash, int left, int right) {
        for(int i = 0;i < 26;i++) {
            if(hash[left][i] && hash[right][i]) {
                return true;
            }
        }
        return false;
    }
}
