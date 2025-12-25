import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        Set<Long> row = new HashSet<>();
        Set<Long> col = new HashSet<>();
        Set<Long> dig1 = new HashSet<>();
        Set<Long> dig2 = new HashSet<>();
        int ret = (int)1e5 + 10;
        for(int i = 1; i <= k; i++) {
            long x = in.nextLong(), y = in.nextLong();
            if(ret != (int)1e5 + 10) continue;
            if(row.contains(y) || col.contains(x) || dig1.contains(y - x) ||
                    dig2.contains(y + x))
            {
                ret = i;
            }
            row.add(y); col.add(x); dig1.add(y - x); dig2.add(y + x);
        }

        int t = in.nextInt();
        while(t-- != 0) {
            int i = in.nextInt();
            if(i >= ret) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
