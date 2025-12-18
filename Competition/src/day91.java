import java.util.Arrays;
import java.util.Scanner;

public class day91 {
    public static int n;
    public static int[] arr;
    public static boolean[] use = new boolean[1010];
    public static int path;
    public static int ret = 0x3f3f3f3f;
    public static boolean isPrim(int x) {
        if(x <= 1) return false;
        for(int i = 2; i <= Math.sqrt(x); i++)
        {
            if(x % i == 0) return false;
        }
        return true;
    }
    public static void dfs(int pos) {
        if(pos == n) {
            ret = Math.min(ret, path);
            return;
        }

        for(int i = 2; i <= arr[pos]; i++) {
            if(arr[pos] % i == 0 && !use[i] && isPrim(i)) {
                path += i;
                use[i] = true;
                dfs(pos + 1);
                use[i] = false;
                path -= i;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = in.nextInt();
        dfs(0);
        if(ret == 0x3f3f3f3f) System.out.println(-1);
        else System.out.println(ret);
    }

    public int minDifference (int[] a) {
        Arrays.sort(a);
        long ret = (long)1e16 + 10;
        for(int i = 1; i < a.length; i++)
        {
            ret = Math.min(ret, (long)a[i] - a[i - 1]);
        }
        return (int)ret;
    }
}
