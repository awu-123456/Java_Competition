import java.util.*;
import java.io.*;
public class day48 {
    public static Read in = new Read();
    //public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = in.nextInt(), m = in.nextInt();
        long[][] arr = new long[n][m];
        long[] row = new long[n];
        long[] col = new long[m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = in.nextInt();
                row[i] += arr[i][j];
                col[j] += arr[i][j];
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.print((row[i] + col[j] - arr[i][j]) + " ");
            }
            System.out.println("");
        }

        //out.close();
    }
}
class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException
    {
        while(!st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException
    {
        return bf.readLine();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
}
