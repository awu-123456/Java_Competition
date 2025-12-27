import java.util.ArrayList;

public class day97 {
    public int getCoins (ArrayList<Integer> nums)
    {
        int n = nums.size();
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for(int i = 1; i <= n; i++)
        {
            arr[i] = nums.get(i - 1);
        }
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n; i >= 1; i--)
        {
            for(int j = i; j <= n; j++)
            {
                for(int k = i; k <= j; k++)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j]
                            + arr[i - 1] * arr[k] * arr[j + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
