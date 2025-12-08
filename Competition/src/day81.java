import java.io.*;
import java.util.StringTokenizer;

public class day81 {
    static Read8 read = new Read8();
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = read.nextInt();
        double[] foodMoney = new double[n+1];
        int[] foodNumber = new int[n+1];
        for(int i = 1;i <= n;i++) {
            foodMoney[i] = read.nextDouble();
            foodNumber[i] = read.nextInt();
        }
        int m = read.nextInt();
        double[] gukes = new double[101];
        for(int i = 1;i <= m;i++) {
            int guke = read.nextInt();
            int number = read.nextInt();
            int bianhao = read.nextInt();
            if(foodNumber[bianhao] >= number) {
                foodNumber[bianhao] -= number;
                gukes[guke] += 1.0 * foodMoney[bianhao] * number;
                System.out.println("gu ke " + guke +" mai le " + number + " ge " + bianhao);
            } else {
                System.out.println("cai pin " + bianhao + " bu gou le");
            }
        }
        for(int i = 1;i <= 100;i++) {
            if(gukes[i] > 0) {
                System.out.printf("gu ke %d hua fei le %.2f yuan\n",i,gukes[i]);
            }
        }
    }

    public static void main2(String[] args) throws IOException {
        int count = 0;
        int n = read.nextInt();
        int[] arr = new int[n];
        int[] arrRight = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = read.nextInt();
        }
        arrRight[0] = arrRight[1] = arr[0];
        for(int i = 2;i < n;i++) {
            arrRight[i] = arrRight[i-1] + arrRight[i-2];
        }
        int count1 = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] != arrRight[i]) {
                count1++;
            }
        }
        arrRight[0] = arrRight[1] = arr[1];
        for(int i = 2;i < n;i++) {
            arrRight[i] = arrRight[i-1] + arrRight[i-2];
        }
        int count2 = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] != arrRight[i]) {
                count2++;
            }
        }
        count = Math.min(count1,count2);
        System.out.println(count);
    }
    public static void main1(String[] args) throws IOException {
        int count = 0;
        int n = read.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = read.nextInt();
        }
        if(arr[0] != arr[1]) {
            arr[1] = arr[0];
            count++;
        }
        for(int i = 2;i < n;i++) {
            if(arr[i] != arr[i-1] + arr[i-2]) {
                arr[i] = arr[i-1] + arr[i-2];
                count++;
            }
        }
        System.out.println(count);
    }

    int m,n;
    boolean[][] vis;
    char[] word;
    public boolean exist(char[][] board, String _word) {
        m = board.length;n = board[0].length;
        word = _word.toCharArray();
        vis = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == word[0]) {
                    vis[i][j] = true;
                    if(dfsExist(board,i,j,1)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    private boolean dfsExist(char[][] board, int i, int j, int pos) {
        if(pos == word.length) {
            return true;
        }
        for(int k = 0;k < 4;k++) {
            int x = i + dx[k],y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && board[x][y] == word[pos]) {
                vis[x][y] = true;
                if(dfsExist(board,x,y,pos+1)) {
                    return true;
                }
                vis[x][y] = false;
            }
        }
        return false;
    }

    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ret = 0;
        for(int i = n-1;i >= 0;i--) {
            for(int j= i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                }
                if(dp[i][j]) {
                    ret++;
                }
            }
        }
        for(int i = 1;i < n-1;i++) {
            for(int j = i;j < n-1;j++) {
                if(dp[0][i-1] && dp[i][j] && dp[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public String longestPalindrome(String s) {
        int begin = 0,len = 0,n = s.length();;
        for(int i = 0;i < n;i++) {
            int left = i,right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;right++;
            }
            if(right - left - 1 > len) {
                begin = left + 1;
                len = right - left - 1;
            }
            left = i;right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;right++;
            }
            if(right - left - 1 > len) {
                begin = left + 1;
                len = right - left - 1;
            }
        }
        return s.substring(begin,begin+len);
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ret = 0;
        for(int i = n-1;i >= 0;i--) {
            for(int j = i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                }
                if(dp[i][j]) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
class Read8 {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        if(!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    String nextLine() throws IOException {
        return bf.readLine();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
