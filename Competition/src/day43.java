import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n+1];
        int countGroup = 0;
        for(int i = 0;i < n;i++) {
            int x = scanner.nextInt();
            arr[x]++;
        }
        Arrays.sort(arr);
        for(int i = 0;i < n;i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
    public static void main1(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Long x = scanner.nextLong();
        long tmp = (int) Math.sqrt(x);
        long a = tmp * tmp;
        long b = (tmp + 1) * (tmp + 1);
        if(Math.abs(x - a) <= Math.abs(x - b)) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
