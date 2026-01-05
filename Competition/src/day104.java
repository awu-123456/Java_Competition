public class day104 {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        memo = new int[m][n];
        int ret = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                ret = Math.max(ret, dfs(matrix, i, j));

        return ret;
    }
    public int dfs(int[][] matrix, int i, int j) {
        if(memo[i][j] != 0) {
            return memo[i][j];
        }
        int ret = 1;
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i]
                    [j]) {
                ret = Math.max(ret, dfs(matrix, x, y) + 1);
            }
        }
        memo[i][j] = ret;
        return ret;
    }
}
