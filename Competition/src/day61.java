import java.util.Scanner;

public class day61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 1;i <= n;i++) {
            f[i] = g[i-1] + arr[i];
            g[i] = Math.max(f[i-1], g[i-1]);
        }
        System.out.println(Math.max(f[n],g[n]));
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        int n = s.length;
        int ret = -1;
        for(int i = 0;i < n;i++) {
            if(i + 1 < n && s[i] == s[i+1]) {
                ret = 2;
                break;
            }
            if(i + 2 < n && s[i] == s[i + 2]) {
                ret = 3;
            }
        }
        System.out.println(ret);
    }
}
