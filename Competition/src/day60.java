import java.util.*;

public class day60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++) {
            arr[i] = scanner.nextInt();
            if(arr[i] >= max) {
                max = arr[i];
            }
            if(arr[i] <= min) {
                min = arr[i];
            }
        }
        int sumMax = 0;
        for(int i = min;i <= max;i++) {
            int sum = 0;
            for(int j = 0;j < n;j++) {
                if(Math.abs(arr[j] - i) <= p) {
                    sum++;
                }
            }
            if(sum >= sumMax) {
                sumMax = sum;
            }
        }
        System.out.println(sumMax);
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0;i < n;i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        int average1 = sum / n;
        int average2 = average1 + 1;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i < n;i++) {
            if(Math.abs(arr[i] - average1) <= p) {
                sum1++;
            }
            if(Math.abs(arr[i] - average2) <= p) {
                sum2++;
            }
        }
        System.out.println(Math.max(sum1,sum2));
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> hash = new HashMap<>();
        int[] arr = new int[n+1];
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
            hash.put(arr[i], i);
        }
        Arrays.sort(arr);
        boolean[] flg = new boolean[n+10];
        long sum = 0;
        for(int i = n;i >= 1;i--) {
            int x = arr[i];
            int index = hash.getOrDefault(x,0);
            if(!flg[index+1] && !flg[index-1]) {
                sum += x;
                flg[index] = true;
            }
        }
        System.out.println(sum);
    }

    public static void main1(String[] args) {
        System.out.println(-1);
    }
}
