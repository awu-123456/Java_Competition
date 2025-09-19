import java.util.HashMap;
import java.util.Map;

public class day14 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length,m = mat[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int[][] ret = new int[n][m];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                int x1 = Math.max(0,i - k) + 1,y1 = Math.max(0,j - k) + 1;
                int x2 = Math.min(n-1,i + k) + 1,y2 = Math.min(m-1,j + k) + 1;
                ret[i][j] = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            }
        }
        return ret;
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);
        int ret = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += (nums[i] == 1 ? -1 : 1);
            if(hash.containsKey(sum)) {
                ret = Math.max(ret,i - hash.get(sum));
            } else {
                hash.put(sum,i);
            }
        }
        return ret;
    }
}
