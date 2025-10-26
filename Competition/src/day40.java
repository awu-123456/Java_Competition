import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class day40 {
    static class Interval {
        int l, r;
        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                String[] parts = bufferedReader.readLine().split(" ");
                int l = Integer.parseInt(parts[0]);
                int r = Integer.parseInt(parts[1]);
                intervals[i] = new Interval(l, r);
            }
            Arrays.sort(intervals, (a, b) -> a.l - b.l);
            int need = 0;
            int[] selected = new int[n];
            for (int i = 0; i < n; i++) {
                int l = intervals[i].l;
                int r = intervals[i].r;
                if (l <= need && need <= r) {
                    selected[i] = need;
                    need++;
                } else {
                    selected[i] = l;
                    if (l == need) {
                        need++;
                    }
                }
            }
            boolean[] exists = new boolean[n + 2];
            for (int num : selected) {
                if (num <= n + 1) {
                    exists[num] = true;
                }
            }
            int mex = 0;
            while (mex <= n + 1 && exists[mex]) {
                mex++;
            }
            printWriter.println(mex);
        }
        printWriter.flush();
    }
    public static void main3(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine();
            int[] str = new int[n+1];
            for(int i = 0;i < n;i++) {
                str[i+1] = s.charAt(i) - '0';
            }
            int ans = 0;
            for (int assume = 0;assume <= 1;assume++) {
                int prev = assume;
                int cur = 0;
                for(int i = 2;i <= n;i++) {
                    cur = str[i] ^ (1 - prev);
                    prev = cur;
                }
                int first = str[1] ^ (1 - prev);
                if(first == assume) {
                    ans++;
                }
            }
            printWriter.println(ans);
        }
        printWriter.flush();
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long result = n;
            for(int i = 0;i < k;i++) {
                result *= 2;
            }
            System.out.println(result);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        if(s.equals("Accepted")) {
            System.out.println(t + (n - 1) * 20);
        } else {
            System.out.println(0);
        }
    }
}
