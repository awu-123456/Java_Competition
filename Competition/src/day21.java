import java.util.Scanner;

public class day21 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 1;
        while(n > c) {
            a = b;
            b = c;
            c = a + b;
        }
        int ret = Math.min(c - n,n - b);
        System.out.println(ret);
    }
}
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int m,n;
    boolean[][] vis;
    char[] word;
    public boolean exist (String[] board, String _word) {
        m = board.length;
        n = board[0].length();
        vis = new boolean[m][n];
        word = _word.toCharArray();
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i].charAt(j) == word[0]) {
                    if(dfs(board,i,j,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(String[] board, int i, int j, int path) {
        if(path == word.length-1) {
            return true;
        }
        vis[i][j] = true;
        for(int k = 0;k < 4;k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && board[x].charAt(y) == word[path+1]) {
                if(dfs(board,x,y,path+1)) {
                     return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
}
