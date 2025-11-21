import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class day64 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int maxPathSum (TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs1(root);
        return ret;
    }

    private int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0,dfs1(root.left));
        int r = Math.max(0,dfs1(root.right));
        ret = Math.max(ret,root.val + l + r);
        return root.val + Math.max(l,r);
    }

    public static int N = 20;
    public static int n,ret = 0;
    public static int[] arr = new int[N];
    public static boolean[] dist = new boolean[N];
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
        }
        dfs(1);
        System.out.println(ret);
    }

    private static void dfs(int pos) {
        if(pos == n+1) {
            ret++;
            return;
        }
        for(int i = 1;i <= n;i++) {
            if(dist[i]) {
                continue;
            }
            if(dist[arr[i]]) {
                return;
            }
            dist[i] = true;
            dfs(pos + 1);
            dist[i] = false;
        }
    }

    public static Read2 read = new Read2();
    public static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main1(String[] args) throws IOException {
        int n = read.nextInt();
        while(n-- > 0) {
            char[] ch = read.next().toCharArray();
            int len = ch.length;
            for(int i = len-1;i >= 0;i--) {
                if((ch[i] - '0') % 2 == 0) {
                    swap(ch,i,len-1);
                }
            }
            if((ch[len-1] - '0') % 2 == 0) {
                pw.append(ch.toString());
            } else {
                pw.append("-1");
            }
        }
        pw.flush();
    }

    private static void swap(char[] ch, int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
}
class Read2 {
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
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
