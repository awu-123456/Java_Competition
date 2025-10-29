import java.io.*;
import java.util.*;

public class Main3 {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int n,m;
    public static Map<Integer, List<Integer>> edges = new HashMap<>();
    public static int[] cnt;
    public static Read in = new Read();
    public static void main(String[] args) throws IOException {
        n = in.nextInt();m = in.nextInt();
        cnt = new int[n+1];
        for(int i = 0;i < m;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            cnt[b]++;
            if(!edges.containsKey(a)) {
                edges.put(a,new ArrayList<>());
            }
            edges.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i <= n;i++) {
            if(cnt[i] == 0) {
                q.add(i);
            }
        }
        int[] ret = new int[n];
        int pos = 0;
        while(!q.isEmpty()) {
            int t = q.poll();
            ret[pos++] = t;
            for(int a : edges.getOrDefault(t,new ArrayList<>())) {
                cnt[a]--;
                if(cnt[a] == 0) {
                    q.add(a);
                }
            }
        }
        if(pos == n) {
            for (int i = 0;i < n-1;i++) {
                out.print(ret[i] + " ");
            }
            out.println(ret[n-1]);
        } else {
            out.println(-1);
        }
        out.close();
    }
}
class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        while (!st.hasMoreElements()) {
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