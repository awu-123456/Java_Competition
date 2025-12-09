import java.io.*;
import java.util.StringTokenizer;

public class day82 {
    public static Read read = new Read();
    public static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[][] arr;
    private static int n;
    public static void main(String[] args) throws IOException {
        n = read.nextInt();
        arr = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                arr[i][j] = read.nextInt();
            }
        }
        int q = read.nextInt();
        int row = 0,col = 0;
        while(q-- > 0) {
            int x = read.nextInt();
            if(x == 1) {
                row++;col++;
            } else {
                row++;
            }
        }
        row %= 2;col %= 2;
        if(row != 0) {
            rowChange();
        }
        if(col != 0) {
            colChange();
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(j != 0) {
                    pw.print(" ");
                }
                pw.print(arr[i][j]);
            }
            pw.println();
        }
        pw.close();
    }

    private static void colChange() {
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n / 2;j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = tmp;
            }
        }
    }

    private static void rowChange() {
        for(int i = 0;i < n / 2;i++) {
            for(int j = 0;j < n;j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[n-1-i][j];
                arr[n-1-i][j] = tmp;
            }
        }
    }

    public static void main1(String[] args) throws IOException {
        int n = read.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1;i <= n;i++) {
            arr[i] = read.nextInt();
        }
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        f[1] = arr[1];
        for(int i = 2;i <= n;i++) {
            int x = arr[i];
            f[i] = Math.max(f[i-1],x);
            if(x >= f[i-1]) {
                g[i] = f[i-1];
            } else if(x >= g[i-1]) {
                g[i] = x;
            } else {
                g[i] = g[i-1];
            }
        }
        int q = read.nextInt();
        while(q-- > 0) {
            int x = read.nextInt();
            System.out.println(g[x]);
        }
    }
}
class Read {
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
}
