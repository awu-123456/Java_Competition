import java.util.Scanner;

public class day99 {
    public static int[] cnt = new int[5];
    public static int m, x, y;
    public static boolean[][] same = new boolean[13][13];

    public static int ret;
    public static int[] path = new int[13];
    public static boolean isSame(int pos, int cur)
    {
        for(int i = 1; i < pos; i++)
        {
            if(same[pos][i] && path[i] != cur) return false;
        }
        return true;
    }

    public static void dfs(int pos)
    {
        if(pos > 12)
        {
            ret++;
            return;
        }

        for(int i = 1; i <= 4; i++)
        {
            if(cnt[i] == 0) continue;
            if(!isSame(pos, i)) continue;
            path[pos] = i;
            cnt[i]--;
            dfs(pos + 1);
            cnt[i]++;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        for(int i = 1; i <= 4; i++)
        {
            cnt[i] = in.nextInt();
        }
        m = in.nextInt();
        while(m-- != 0)
        {
            x = in.nextInt(); y = in.nextInt();
            same[x][y] = same[y][x] = true;
        }

        dfs(1);

        System.out.println(ret);
    }
}
