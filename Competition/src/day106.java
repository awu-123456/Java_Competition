import java.util.Arrays;

public class day106 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ret = 0;
        Arrays.fill(dp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
    public int dfs(int pos, int[] nums, int[] memo) {
        if(memo[pos] != 0) return memo[pos];
        int ret = 1;
        for(int i = pos + 1; i < nums.length; i++)
        {
            if(nums[i] > nums[pos])
            {
                ret = Math.max(ret, dfs(i, nums, memo) + 1);
            }
        }
        memo[pos] = ret;
        return ret;
    }
}
