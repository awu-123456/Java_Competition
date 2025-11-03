import java.util.Arrays;
import java.util.Scanner;

class Orange {
    int a;
    int b;
    Orange() {};
    Orange(int a,int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main5 {
    public int knapsack (int V, int n, int[][] vw) {
        int[] dp = new int[1010];
        for(int i = 0;i < n;i++) {
            for(int j = V;j >= vw[i][0];j--) {
                dp[j] = Math.max(dp[j],dp[j - vw[i][0]] + vw[i][1]);
            }
        }
        return dp[V];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Orange[] o = new Orange[n];
        for(int i = 0;i < n;i++) {
            o[i] = new Orange();
            o[i].a = in.nextInt();
        }
        for(int i = 0;i < n;i++) {
            o[i].b = in.nextInt();
        }
        Arrays.sort(o,(x,y) -> {
            if(x.b == y.b) {
                return x.a - y.a;
            }
            return y.b - x.b;
        });
        long x = 0;
        long y = 0;
        for(int i = 0;i < k;i++) {
            x += o[i].a;
            y += o[i].b;
        }
        System.out.println(x + " " + y);
    }
    public String compressString (String param) {
        if (param == null || param.isEmpty()) {
            return param;
        }
        int count = 1;
        String result = new String();
        for(int i = 1;i < param.length();i++) {
            if(param.charAt(i) != param.charAt(i-1)) {
                result += param.charAt(i-1);
                if(count != 1) {
                    result += count;
                }
                count = 1;
            } else {
                count++;
            }
        }
        result += param.charAt(param.length()-1);
        if(count != 1) {
            result += count;
        }
        return result;
    }
}
