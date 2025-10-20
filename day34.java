import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            int n = scanner.nextInt();
            int[] flg1 = new int[4];
            String s = scanner.next();
            for(int i = 0;i < n;i++) {
                int a = s.charAt(i) - '0';
                flg1[a] = 1;
            }
            int flg2 = 0;
            for(int i = 0;i < 4;i++) {
                flg2 += flg1[i];
            }
            if(flg2 == 3) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] pre1 = new int[n+1];
        int[] pre2 = new int[n+1];
        int[] pre3 = new int[n+1];
        for(int i = 0;i < n;i++) {
            pre1[i+1] = pre1[i] + (s.charAt(i) == '1' ? 1 : 0);
            pre2[i+1] = pre2[i] + (s.charAt(i) == '2' ? 1 : 0);
            pre3[i+1] = pre3[i] + (s.charAt(i) == '3' ? 1 : 0);
        }
        int count = 0;
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j <= n;j++) {
                int cnt1 = pre1[j] - pre1[i];
                int cnt2 = pre2[j] - pre2[i];
                int cnt3 = pre3[j] - pre3[i];
                if(cnt1 == cnt2 && cnt2 == cnt3 && cnt1 > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pos = new int[4];
        for(int i = 1;i < 4;i++) {
            int x = scanner.nextInt();
            pos[x] = i;
        }
        for(int i =1;i < 4;i++) {
            System.out.printf("%d",pos[i]);
            if(i != 3) {
                System.out.printf(" ");
            }
        }
    }
}
