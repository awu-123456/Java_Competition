public class day105 {
    int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        return dfs(1, n);
    }
    public int dfs(int left, int right) {
        if(left >= right) return 0;
        if(memo[left][right] != 0) {
            return memo[left][right];
        }
        int ret = Integer.MAX_VALUE;
        for(int head = left; head <= right; head++) {
            int x = dfs(left, head - 1);
            int y = dfs(head + 1, right);
            ret = Math.min(Math.max(x, y) + head, ret);
        }
        memo[left][right] = ret;
        return ret;
    }
}
