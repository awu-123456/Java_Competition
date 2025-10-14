import java.util.Scanner;

public class day28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(2);
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        char[] numbers = number.toCharArray();
        int n = number.length();
        int a = n % 3;
        for(int i = 0;i < a;i++) {
            System.out.printf("%c",numbers[i]);
        }
        if(a != 0) {
            System.out.printf(",");
        }
        int count = 0;
        for(int i = a; i < n; i++) {
            System.out.printf("%c",numbers[i]);
            count++;
            if(count == 3 && i != n -1) {
                count = 0;
                System.out.printf(",");
            }
        }
    }
}
