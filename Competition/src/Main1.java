import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        String s1 = str[0];
        String s2 = str[1];
        int prev1 = -1;
        int prev2 = -1;
        int ret = 0x3f3f3f3f;
        for(int i = 0;i < n;i++) {
            String s = reader.readLine();
            if(s.equals(s1)) {
                if(prev2 != -1) {
                    ret = Math.min(ret,i - prev2);
                }
                prev1 = i;
            } else if (s.equals(s2)) {
                if(prev1 != -1) {
                    ret = Math.min(ret,i - prev1);
                }
                prev2 = i;
            }
        }
        System.out.println(ret == 0x3f3f3f3f ? -1 : ret);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int[] dp = new int[n+1];
        for(int i = 2;i < n+1;i++) {
            dp[i] = Math.min(dp[i-1]+arr[i-1],dp[i-2]+arr[i-2]);
        }
        System.out.println(dp[n]);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] ss = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < ss.length;i++) {
            char ch = ss[i];
            if (str.length() != 0 && ch == str.charAt(str.length()-1)) {
                str.deleteCharAt(str.length()-1);
            } else {
                str.append(ch);
            }
        }
        System.out.println(str.length() == 0 ? 0 : str.toString());
    }
}
