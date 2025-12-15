import java.util.*;

public class day88 {
    public int uniquePaths(int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
            {
                if(i == 1 && j == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m][n];
    }
    public int dfs(int i, int j, int[][] memo)
    {
        if(memo[i][j] != 0)
        {
            return memo[i][j];
        }
        if(i == 0 || j == 0) return 0;
        if(i == 1 && j == 1)
        {
            memo[i][j] = 1;
            return 1;
        }
        memo[i][j] = dfs(i - 1, j, memo) + dfs(i, j - 1, memo);
        return memo[i][j];
    }
}
