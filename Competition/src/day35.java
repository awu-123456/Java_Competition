import java.util.Scanner;

public class day35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] ch = new char[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            String s = scanner.next();
            for(int j = 1;j <= m;j++) {
                ch[i][j] = s.charAt(j-1);
            }
        }
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                int t = 0;
                if(ch[i][j] == 'l') t = 4;
                else if(ch[i][j] == 'o') t = 3;
                else if(ch[i][j] == 'v') t = 2;
                else if(ch[i][j] == 'e') t = 1;
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + t;
            }
        }
        System.out.println(dp[n][m]);
    }
    public int getLongestPalindrome (String s) {
        int n = s.length();
        int ret = 0;
        for(int i = 0;i < n;i++) {
            int left = i - 1,right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            ret = Math.max(ret,right - left - 1);
            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            ret = Math.max(ret,right - left - 1);
        }
        return ret;
    }
}
