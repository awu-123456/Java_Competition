import java.util.*;

public class Main8 {
    public static int N = 510,M = 510 * 110 / 2;
    public static int n;
    public static int[] arr = new int[N];
    public static boolean[][] dp = new boolean[N][M];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        if(sum % 2 == 1) {
            System.out.println(false);
        } else {
            sum /= 2;
            dp[0][0] = true;
            for(int i = 1;i <= n;i++) {
                for(int j = 0;j <= sum;j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j >= arr[i]) {
                        dp[i][j] = dp[i][j] || dp[i][j-arr[i]];
                    }
                }
            }
            if(dp[n][sum]) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
    public boolean hostschedule (ArrayList<ArrayList<Integer>> schedule) {
        int m = schedule.size();
        int n = schedule.get(0).size();
        int[][] sc = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                sc[i][j] = schedule.get(i).get(j);
            }
        }
        Arrays.sort(sc,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        for (int i = 1;i < sc.length;i++) {
            if(sc[i][0] < sc[i-1][1]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        for(int i = 2;i <= Math.sqrt(number);i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char[] words = word.toCharArray();
        int[] arr = new int[26];
        for (char ch : words) {
            arr[ch - 'a']++;
        }
        int maxn = 0;
        int minn = 1000;
        for(int i = 0;i < 26;i++) {
            if(arr[i] != 0) {
                if (arr[i] >= maxn) {
                    maxn = arr[i];
                }
                if (arr[i] <= minn) {
                    minn = arr[i];
                }
            }
        }
        int number = maxn - minn;
        if(!isPrime(number)) {
            System.out.println("No Answer");
            System.out.println(0);
        } else {
            System.out.println("Lucky Word");
            System.out.println(number);
        }
    }
}
