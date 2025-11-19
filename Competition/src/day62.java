import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day62 {
    public static int N = 1010;
    public static int n,m,x1,y1,x2,y2;
    public static char[][] ch = new char[N][N];
    public static int[][] digit = new int[N][N];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        x1 = scanner.nextInt();
        y1 = scanner.nextInt();
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();
        for (int i = 1;i <= n;i++) {
            String s = scanner.nextLine();
            for(int j = 1;j <= m;j++) {
                ch[i][j] = s.charAt(j-1);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        if(ch[x2][y2] == '*') {
            return -1;
        }
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                digit[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1,y1});
        digit[x1][y1] = 0;
        while(!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for(int k = 0;k < 4;k++) {
                int x = a + dx[k],y = b + dy[k];
                if(x >= 1 && x <= n && y >= 1 && y <= m && ch[x][y] == '.'
                        && digit[x][y] != -1) {
                    q.offer(new int[]{x,y});
                    digit[x][y] = digit[a][b] + 1;
                    if(x == x2 && y2 == y) {
                        return digit[x2][y2];
                    }
                }
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = n;
        for(int i = 0;i < m-1;i++) {
            sum = sum * (n-1) % 109;
        }
        System.out.println(sum);
    }
}
