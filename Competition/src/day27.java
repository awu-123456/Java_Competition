import java.util.Arrays;
import java.util.Scanner;

public class day27 {
    public int MLS (int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int len = 1;
        for(int i = 0;i < n;i++) {
            int left = i;
            while(left + 1 < n && arr[left] + 1 == arr[left+1]) {
                left++;
            }
            int count = left - i + 1;
            if(count > len) {
                len = count;
            }
            i = left;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[26];
        a['l' - 'a'] = 4;
        a['o' - 'a'] = 3;
        a['v' - 'a'] = 2;
        a['e' - 'a'] = 1;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] ch = new char[n][m];
        for(int i = 0;i < n;i++) {
            String s = scanner.next();
            ch[i] = s.toCharArray();
        }
        int[][] dp = new int[n][m];
        dp[0][0] = a[ch[0][0] - 'a'];
        for(int i = 1;i < n;i++) {
            dp[i][0] = dp[i-1][0] + a[ch[i][0] - 'a'];
        }
        for(int i = 1;i < m;i++) {
            dp[0][i] = dp[0][i-1] + a[ch[0][i] - 'a'];
        }
        for(int i = 1;i < n;i++) {
            for (int j = 1;j < m;j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + a[ch[i][j] - 'a'];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sum = a * b;
        while(b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        System.out.println(sum / a);
    }
}
