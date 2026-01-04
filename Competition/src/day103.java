import java.util.Arrays;
import java.util.Scanner;

public class day103 {
    public static int n;
    public static long k;
    public static long[] arr;
    public static long[] sum;
    public static long cal(int l, int r) {
        int mid = (l + r) / 2;
        return (mid - l) * arr[mid] - (sum[mid - 1] - sum[l - 1]) + (sum[r] -
                sum[mid]) - (r - mid) * arr[mid];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextLong();
        arr = new long[n + 1];
        sum = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr, 1, n + 1);
        for(int i = 1; i <= n; i++)
        {
            sum[i] = sum[i - 1] + arr[i];
        }

        int left = 1, right = 1, ret = 1;
        while(right <= n) {
            long cost = cal(left, right);
            while(cost > k) {
                left++;
                cost = cal(left, right);
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }

        System.out.println(ret);
    }
}
