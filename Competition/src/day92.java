import java.util.Scanner;

public class day92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = in.nextInt();
        int ret = 1;
        for(int i = 0; i < n; ) {
            int j = i;
            while(j + 1 < n && arr[j + 1] - arr[j] <= 8) j++;
            ret = Math.max(ret, j - i + 1);
            i = j + 1;
        }
        System.out.println(ret);
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        char[] dp = new char[n + 1];
        int ret = 0;
        for(int i = 0; i < n; i++) {
            char ch = s[i];
            if(ret == 0 || ch >= dp[ret]) {
                dp[++ret] = ch;
            }
            else {
                int left = 1, right = ret;
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(dp[mid] > ch) right = mid;
                    else left = mid + 1;
                }
                dp[left] = ch;
            }
        }
        System.out.println(n - ret);
    }
}
