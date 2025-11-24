import java.util.Scanner;

public class day69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i < n;i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }
        int ret = 0;
        int r = arr[0][1];
        for(int i = 1;i < n;i++) {
            if(arr[i][0] < r) {
                r = Math.min(r,arr[i][1]);
            } else {
                ret++;
                r = arr[i][1];
            }
        }
        System.out.println(ret+1);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        long[] arr = new long[2 * n];
        for (int i = 0;i < n;i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int p = n;
        if(n != 1) {
            for (int i = n - 2;i >= 0;i--) {
                arr[p++] = arr[i];
            }
        }
        long sum = 0;
        for(int i = 0;i < p;i++) {
            sum = sum * 10 + arr[i];
        }
        if(sum <= 2) {
            System.out.println("prime");
        } else {
            for(int i = 2;i <= Math.sqrt(sum);i++) {
                if(sum % i == 0) {
                    System.out.println("noprime");
                    return;
                }
            }
            System.out.println("prime");
        }
    }
}
