import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day33 {
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
        int count = 0;
        int sum = 0;
        int ret = 0;
        int[] arr = new int[n];
        int left = 0,right = 0;
        String s = scanner.next();
        for(int i = 0;i < n;i++) {
            arr[i] = s.charAt(i) - '0';
        }
        for(;right < n;right++) {
            int x = arr[right];
            sum += x;
            if(sum % 6 == 0) {
                count++;
            }
            ret += x;
            if(ret == 6) {
                count++;
                ret -= arr[left++];
            }
            while(ret >= 6) {
                ret -= arr[left++];
            }
        }
        System.out.println(--count);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0;i < 3;i++) {
            int x = scanner.nextInt();
            hash.put(i+1,x);
        }
        for(int i = 0;i < 3;i++) {
            System.out.printf("%d",hash.get(i+1));
            if(i != 2) {
                System.out.printf(" ");
            }
        }
    }
}
