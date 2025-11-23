import java.util.Scanner;

public class day67 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- != 0)
        {
            int h = in.nextInt();
            int ret = 0, a = 1;
            while(h != 0)
            {
                h -= a;
                ret++;
                if(h % (a * 2) == 0)
                {
                    a *= 2;
                }
            }
            System.out.println(ret);
        }
    }
}
