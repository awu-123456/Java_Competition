import java.io.PrintWriter;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ret = 0;
        for(int i = Math.max(a,10);i <= b;i++) {
            ret += check(i);
        }
        System.out.println(ret);
    }

    public static int check(int x) {
        int n = 0;
        int[] num = new int[10];
        while(x != 0) {
            num[n++] = x % 10;
            x /= 10;
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(num[i] != 0 && i != j) {
                    if (isPrime(num[i] * 10 + num[j])) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isPrime(int x) {
        if(x < 2) {
            return false;
        }
        for(int i = 2;i <= Math.sqrt(x);i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
