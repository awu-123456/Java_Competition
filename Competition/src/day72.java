import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day72 {
    public static int N = 40;
    public static int n,m, x1, y1;
    public static char[][] arr = new char[N][N];
    public static int[][] dist = new int[N][N];
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 0;i < n;i++) {
            char[] tmp = scanner.next().toCharArray();
            for(int j = 0;j < m;j++) {
                arr[i][j] = tmp[j];
                if(arr[i][j] == 'k') {
                    x1 = i;
                    y1 = j;
                }
            }
        }
        bfs();
        int ret = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(arr[i][j] == 'e' && dist[i][j] != -1) {
                    count++;
                    ret = Math.min(ret,dist[i][j]);
                }
            }
        }
        if(count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ret + ' ' + count);
        }
    }

    private static void bfs() {
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                dist[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        dist[x1][y1] = 0;
        while(!q.isEmpty()) {
            int[] t = q.poll();
            int a = t[0],b = t[1];
            for(int k = 0;k < 4;k++) {
                int x = a + dx[k],y = b + dy[k];
                if(x >= 0 && x < n && y >= 0 && y < m && dist[x][y] == -1 &&
                        arr[x][y] != '*') {
                    dist[x][y] = dist[a][b] + 1;
                    if(arr[x][y] != 'e'){
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
