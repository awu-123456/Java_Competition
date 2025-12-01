public class day75 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i = 2;i <= n;i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }

    public int waysToStep(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        if(n == 3) {
            return 4;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int mod = 1000000007;
        for(int i = 4;i <= n;i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % mod + dp[i-3]) % mod;
        }
        return dp[n];
    }

    public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int[] dp= new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for(int i = 3;i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
