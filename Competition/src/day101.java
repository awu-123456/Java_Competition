import java.util.Scanner;

public class day101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        int sum = 0;
        for (int i = 0; i < n - m; i++) {
            int x = in.nextInt();
            sum += x;
        }

        double a = (sum + m) * 1.0 / n;
        double b = (sum + m * 5) * 1.0 / n;
        System.out.printf("%.5f %.5f", a, b);
    }
}
