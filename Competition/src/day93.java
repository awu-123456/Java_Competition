import java.util.LinkedList;
import java.util.Queue;

public class day93 {
    int n, m;
    int x1, y1, x2, y2;
    int[][] dist = new int[15][15];
    int[][] cnt = new int[15][15];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int bfs(int[][] CityMap)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1});
        dist[x1][y1] = 0;
        cnt[x1][y1] = 1;
        while(!q.isEmpty())
        {
            int[] t = q.poll();
            int a = t[0], b = t[1];
            for(int i = 0; i < 4; i++)
            {
                int x = a + dx[i], y = b + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && CityMap[x][y] != -1)
                {
                    if(dist[x][y] == -1)
                    {
                        dist[x][y] = dist[a][b] + 1;
                        cnt[x][y] += cnt[a][b];
                        q.offer(new int[]{x, y});
                    }
                    else
                    {
                        if(dist[a][b] + 1 == dist[x][y])
                        {
                            cnt[x][y] += cnt[a][b];
                        }
                    }
                }
            }
        }
        return cnt[x2][y2];
    }
    public int countPath (int[][] CityMap, int _n, int _m)
    {
        n = _n; m = _m;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dist[i][j] = -1;
                if(CityMap[i][j] == 1)
                {
                    x1 = i; y1 = j;
                }
                else if(CityMap[i][j] == 2)
                {
                    x2 = i; y2 = j;
                }
            }
        }
        return bfs(CityMap);
    }
}
