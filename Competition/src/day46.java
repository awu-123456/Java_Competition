import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class day46 {
    static class qujian {
        int l;
        int r;
        int id;
        qujian(int l,int r,int id) {
            this.l = l;
            this.r = r;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = scanner.nextInt();
            int maxLeft = Integer.MIN_VALUE;
            int minRight = Integer.MAX_VALUE;
            while(n-- > 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                maxLeft = Math.max(maxLeft,l);
                minRight = Math.min(minRight,r);
            }
            if(maxLeft <= minRight) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        qujian[] arr = new qujian[n];
        for(int i = 0;i < n;i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            arr[i] = new qujian(l,r,i+1);
        }
        Arrays.sort(arr, Comparator.comparing(a -> a.l));
        int[] lefts = new int[n];
        for(int i = 0;i < n;i++) {
            lefts[i] = arr[i].l;
        }
        StringBuilder sb = new StringBuilder();
        while(q-- > 0) {
            int x = scanner.nextInt();
            int pos = find(lefts,x) - 1;
            if(pos >= 0 && arr[pos].r >= x) {
                sb.append(arr[pos].id).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int find(int[] a, int x) {
        int l = 0;
        int r = a.length;
        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] <= x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] l = new int[n+1];
        int[] r = new int[n+1];
        for(int i = 1;i <= n;i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }
        while(q-- > 0) {
            int x = scanner.nextInt();
            boolean flg = false;
            for(int i = 1;i <= n;i++) {
                if(x >= l[i] && x <= r[i]) {
                    System.out.println(i);
                    flg = true;
                    break;
                }
            }
            if(!flg) {
                System.out.println(-1);
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            if((l1 < l2 && r1 > r2) || (l1 > l2 && r1 < r2)) {
                System.out.println("A");
            } else if(r1 < l2 || l1 > r2) {
                System.out.println("B");
            } else {
                System.out.println("C");
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        int l2 = scanner.nextInt();
        int r2 = scanner.nextInt();
        if(l1 < l2 && r1 > r2) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
