import java.util.Scanner;

public class day26 {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public void bfs (char[][] grid,int i,int j,int m,int n) {
        if(grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
        }
        for(int k = 0;k < 4;k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < n && y >= 0 && y < m) {
                if(grid[x][y] == '1') {
                    bfs(grid,x,y,m,n);
                }
            }
        }
    }
    public int solve (char[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int count = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1') {
                    bfs(grid,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0) {
            System.out.println("Yes");
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] ss = s.toCharArray();
        int n = ss.length;
        int len = 0;
        int index = 0;
        for(int i = 0;i < n;i++) {
            if(ss[i] >= '0' && ss[i] <= '9') {
                int left = i;
                int count = 0;
                while(left < n && ss[left] >= '0' && ss[left] <= '9') {
                    count++;
                    left++;
                }
                if(count > len) {
                    len = count;
                    index = i;
                }
                i = left;
            }
        }
        String str = s.substring(index,index+len);
        System.out.println(str);
    }
}
